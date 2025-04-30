package com.pluralsight.view;

import java.util.Scanner;

public class HomeScreen {
    static String[] menuOptions = {"D) Add Deposit", "P) Make Payment (Debit)", "L) View Ledger", "X) Exit " +
            "Program"};

    public static void displayMenu() {
        System.out.println("What would you like to do? Select from the following options: ");
        for (String option : menuOptions) {
            System.out.printf("\n\t %s\n", option);
        }
    }

    public static boolean makeSelection(Scanner scanner) {
        displayMenu();
        String menuSelection = scanner.nextLine().trim().toUpperCase();
        switch (menuSelection) {
            case "D":
                System.out.println("Make a deposit: \n");
                Transaction.handleTransaction(menuSelection, scanner);
                UIUtils.clearScreen();
                break;
            case "P":
                System.out.println("Make a payment: \n");
                Transaction.handleTransaction(menuSelection, scanner);
                UIUtils.clearScreen();
                break;
            case "L":
                Ledger.makeSelection(scanner);
                UIUtils.clearScreen();
                break;
            case "X":
                System.out.println("Goodbye...\n");
                scanner.close();
                return false;
            default:
                System.out.println("Invalid menu selection.");
        }
        return true;
    }
}
