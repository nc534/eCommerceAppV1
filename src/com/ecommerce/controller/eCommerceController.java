package com.ecommerce.controller;

import com.ecommerce.data.InitialData;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Product;
import com.ecommerce.service.eCommerceService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class eCommerceController {

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
                }else{
                    System.out.println("Username and Password do not match");
                }

            }else{
                System.out.println("Username does not exist!");
            }
    }

}
