package com.ecommerce.controller;

import java.util.InputMismatchException;
import java.util.Scanner;

public class eCommerceController {

    public static void mainMenu(){
        System.out.println("Welcome!");

        int choice = 0;

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
                    System.out.println("Logging In");
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
            }

        }while(choice != 3);
    }

    public static void createAccount(){
        String user_id;
        String password;
        String confirmPassword;
        String first_name;
        String last_name;
        String email;
        String phone;
        String address;
        boolean registered = false;

        do {
            Scanner input = new Scanner(System.in);

            System.out.println("Registering a new account");
            System.out.println();
            System.out.println("First Name: ");
                first_name = input.nextLine();
            System.out.println("Last Name: ");
                last_name = input.nextLine();
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

            //ToDo: Also check if user already exists
            if(!confirmPassword.equals(password)){
                System.out.println("Passwords do not match. Please try again.");
            }else{
                System.out.println("Successfully registered");
                registered = true;
            }

        }while(!registered);
    }

}
