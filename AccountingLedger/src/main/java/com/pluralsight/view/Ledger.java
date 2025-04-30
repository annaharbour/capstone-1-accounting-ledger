package com.pluralsight.view;

import java.util.Scanner;

public class Ledger {
    static String[] menuOptions = {"A) Display All Entries", "D) Display All Deposits", "P) Display All Payments",
            "R) Reports", "H) Return to Home Screen"};

    public static void displayMenu() {
        for (String option : menuOptions) {
            System.out.printf("\n\t %s", option);
        }
    }

    public static void returnToMenu(Scanner scanner){
        System.out.println("\nPress Enter to return to the menu...");
            scanner.nextLine();

    }

    public static void makeSelection(Scanner scanner) {
        while(true) {
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
                    System.out.println("Invalid menu selection.");
            }
        }
    }
}


