package com.ecommerce.controller;

import com.ecommerce.data.InitialData;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Invoice;
import com.ecommerce.model.Product;
import com.ecommerce.service.eCommerceService;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class eCommerceController {

    public static NumberFormat formatter = new DecimalFormat("00.00");
    public static String formatPrice;
    public static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("h:s a  MM/dd/yyyy");

    public static void mainMenu(){
        System.out.println("Welcome!");

        int choice = 0;

        InitialData initialData = new InitialData();
        initialData.generateInitialData();

        do {
            Scanner input = new Scanner(System.in);

            System.out.println();
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");

            System.out.println("Enter choice (1, 2, or 3)");

            try {
                choice = input.nextInt();
            }catch(InputMismatchException e) {
                System.out.println("Please enter a valid choice of 1, 2, or 3");
            }

            switch(choice){
                case 1:
                    createAccount();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    input.close();
                    break;
            }

        }while(choice != 3);
    }

    public static void createAccount(){
        String user_id;
        String password;
        String confirmPassword;
        String name;
        String email;
        String phone;
        String address;
        boolean registered = false;

        System.out.println("Registering a new account");

        //ToDo: implement a way to exit registration
        do {
            Scanner input = new Scanner(System.in);

            System.out.println();
            System.out.println("Name: ");
            name = input.nextLine();
            System.out.println("Email: ");
            email = input.nextLine();
            System.out.println("Phone: ");
            phone = input.nextLine();
            System.out.println("Address: ");
            address = input.nextLine();
            System.out.println("Username: ");
            user_id = input.nextLine();
            System.out.println("Password: ");
            password = input.nextLine();
            System.out.println("Confirm Password: ");
            confirmPassword = input.nextLine();

            if(eCommerceService.loginCheck().containsKey(user_id)) {
                System.out.println("Username already exists.");
            }else if(!confirmPassword.equals(password)){
                System.out.println("Passwords do not match. Please try again.");
            }else{
                Customer newCustomer = new Customer(user_id, password, name, email, phone, address);
                eCommerceService.addCustomer(newCustomer);
                System.out.println("Successfully registered!");
                registered = true;
            }

        }while(!registered);
    }

    public static void login(){
        String user_id;
        String password;
        boolean exists;
        int exit = 0;

        System.out.println("Login");

        Scanner input = new Scanner(System.in);

            System.out.println();
            System.out.println("Username: ");
            user_id=input.nextLine();
            System.out.println("Password: ");
            password=input.nextLine();

            if(eCommerceService.loginCheck().containsKey(user_id)){

                if(password.equals(eCommerceService.loginCheck().get(user_id))){
                    System.out.println("Successfully logged in!");
                    loggedMenu(eCommerceService.getCustomerByUsername(user_id));

                }else{
                    System.out.println("Username and Password do not match");
                }

            }else{
                System.out.println("Username does not exist!");
            }
    }

    public static void loggedMenu(Customer customer) {

        int choice = 0;
        do {

            Scanner input = new Scanner(System.in);

            System.out.println();
            System.out.println("    Item " + "     " + " Price " + "  " + "Item Code ");
            System.out.println("-----------------------------------");

            for (Product p : eCommerceService.getProducts()) {
                formatPrice = formatter.format(p.getPrice());
                String productLine = String.format("   %-10s  $%-5s      %-3d", p.getProductName(), formatPrice, p.getProductCode());
                System.out.println(productLine);
            }

            System.out.println();
            System.out.println("1. Purchase Item(s)");
            System.out.println("2. Return item");
            System.out.println("3. Log Out");

            choice = input.nextInt();

            if(choice == 1){
                purchase(customer);
            }else if(choice == 2){
                returns();
            }else if(choice < 1 || choice > 3){
                System.out.println("Not a valid choice. Please input a valid option.");
                choice = input.nextInt();
            }

        }while(choice != 3);
    }

    public static void purchase(Customer customer) {
        Scanner input = new Scanner(System.in);
        String purchaseCodes;
        List<Product> purchaseList;

        System.out.println("Enter the code(s) of what you want to purchase separated by , (i.e. 1,3,5)");
        purchaseCodes = input.next();

        purchaseList = eCommerceService.purchaseList(purchaseCodes);

        for(Product p : purchaseList){
            formatPrice = formatter.format(p.getPrice());
            String purchase = String.format("   %-3d  %-10s  $%-5s  ", p.getProductCode(), p.getProductName(), formatPrice);
            System.out.println(purchase);
        }

        System.out.println("Confirm purchase? (Y/N)");
        String confirm = input.next();

        if(confirm.toUpperCase().equals("Y")){
            Invoice newInvoice = new Invoice(customer, purchaseList);
            eCommerceService.addInvoice(newInvoice);

            System.out.println();
            System.out.println("                    Receipt");
            System.out.println("------------------------------------------------");

            Invoice invoice = eCommerceService.getInvoiceByNumber(newInvoice.getInvoiceNumber());
            showInvoice(invoice);

            purchaseList.clear();
        }else if(confirm.toUpperCase().equals("N")){
            purchaseList.clear();
        }

    }

    public static void returns() {

    }

    public static void showInvoice(Invoice invoice) {

        String datetime = invoice.getPurchaseDate().format(dateTimeFormatter);
        System.out.println("Customer Name: " + invoice.getCustomerName() + "    " + "Date: " + datetime);
        System.out.println("Invoice Number: " + invoice.getInvoiceNumber());
        for(Product p : invoice.getPurchaseList()){
            formatPrice = formatter.format(p.getPrice());
            String purchase = String.format("   %-3d  %-10s  $%-5s  ", p.getProductCode(), p.getProductName(), formatPrice);
            System.out.println(purchase);
        }
        System.out.println();
        NumberFormat totalFormatter = new DecimalFormat("000.00");
        formatPrice = totalFormatter.format(invoice.getTotal());
        System.out.println("Total: $" + formatPrice);
    }

}
