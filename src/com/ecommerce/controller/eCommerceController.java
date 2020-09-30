package com.ecommerce.controller;

import java.sql.SQLOutput;
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
        String first_name;
        String last_name;
        String email;
        String phone;
        String address;
        boolean registered = false;

        System.out.println("Registering a new account");

        do {
            Scanner input = new Scanner(System.in);

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
                input.close();
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

        //ToDo: implement loop to allow re-enter and exiting from login to main menu
            System.out.println();
            System.out.println("Username: ");
            user_id=input.nextLine();
            System.out.println("Password: ");
            password=input.nextLine();

    }

}
