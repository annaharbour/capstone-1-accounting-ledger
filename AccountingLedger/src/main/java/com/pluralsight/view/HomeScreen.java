package com.pluralsight.view;

import java.util.Scanner;

public class HomeScreen {
    static String[] menuOptions = {"D) Add Deposit", "P) Make Payment (Debit)", "L) View Ledger", "X) Exit " +
            "Program"};

    public static void displayMenu() {
        UIUtils.clearScreen();
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
                UIUtils.clearScreen();
                System.out.println("Make a deposit: \n");
                Transaction.handleTransaction(menuSelection, scanner);
                UIUtils.clearScreen();
                break;
            case "P":
                UIUtils.clearScreen();
                System.out.println("Make a payment: \n");
                Transaction.handleTransaction(menuSelection, scanner);
                UIUtils.clearScreen();
                break;
            case "L":
                Ledger.makeSelection(scanner);
                UIUtils.clearScreen();
                break;
            case "X":
                UIUtils.clearScreen();
                System.out.println("Goodbye...\n");
                scanner.close();
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                UIUtils.clearScreen();
                return false;
            default:
                UIUtils.printColored("Invalid menu selection", "red");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        return true;
    }
}
