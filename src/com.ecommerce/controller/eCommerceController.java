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
                    System.out.println("Registering");
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
}
