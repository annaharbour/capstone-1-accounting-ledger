package com.pluralsight.view;

import java.util.Scanner;

public class Ledger {
    static String[] menuOptions = {"A) Display All Entries", "D) Display All Deposits", "P) Display All Payments",
            "R) Reports", "H) Return to Home Screen"};

    public static void displayMenu() {
        System.out.println("\nWelcome to the digital ledger - please choose from the following options: \n");
        for (String option : menuOptions) {
            System.out.printf("\n\t %s\n", option);
        }
    }

    public static void returnToMenu(Scanner scanner) {
        System.out.println("\nPress Enter to return to the menu...");
        scanner.nextLine();
    }

    public static void makeSelection(Scanner scanner) {
        while (true) {
            UIUtils.clearScreen();
            displayMenu();
            String menuSelection = scanner.nextLine().trim().toUpperCase();
            switch (menuSelection) {
                case "A":
                    LedgerEntries.displayAll();
                    returnToMenu(scanner);
                    break;
                case "D":
                    LedgerEntries.displayDeposits();
                    returnToMenu(scanner);
                    break;
                case "P":
                    LedgerEntries.displayPayments();
                    returnToMenu(scanner);
                    break;
                case "R":
                    String result = Reports.makeSelection(scanner);
                    if ("HOME".equals(result)) {
                        return;
                    }
                    break;
                case "H":
                    return;
                default:
                    UIUtils.printColored("Invalid menu selection", "red");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}


