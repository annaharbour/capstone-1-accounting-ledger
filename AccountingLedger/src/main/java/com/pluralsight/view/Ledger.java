package com.pluralsight.view;

import java.util.Scanner;

public class Ledger {
    static String[] menuOptions = {"A) Display All Entries", "D) Display All Deposits", "P) Display All Payments",
            "R) Reports", "H) Return to Home Screen"};

    public static void displayMenu() {
        for (String option : menuOptions) {
            System.out.println("\t\n" + option);
        }
    }

    public static void makeSelection(Scanner scanner) {
        String menuSelection = scanner.nextLine().trim().toUpperCase();
        switch (menuSelection) {
            case "A":
                LedgerEntries.displayAll();
                break;
            case "D":
                LedgerEntries.displayDeposits();
                break;
            case "P":
                LedgerEntries.displayPayments();
                break;
            case "R":
                Reports.displayMenu();
                Reports.makeSelection(scanner);
                break;
            case "H":
                break;
            default:
                System.out.println("Invalid menu selection.");
                displayMenu();
        }
    }
}


