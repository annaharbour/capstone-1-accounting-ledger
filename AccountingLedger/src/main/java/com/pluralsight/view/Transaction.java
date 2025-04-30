package com.pluralsight.view;

import com.pluralsight.controller.TransactionHandler;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Transaction {

    public static void handleTransaction(String menuSelection, Scanner scanner) {
        String description;
        String vendor;
        float transactionValue = 0;
        boolean validAmount = false;

        do {
            System.out.println("Enter a description for the ledger entry:\n");
            description = scanner.nextLine().trim();
            if (description.isEmpty()) {
                System.out.println("Description cannot be empty. lease try again or type \\\"H\\\" to return to the \" +\n" +
                        "                        \"home screen\" +\n" +
                        "                        \".\"");
                String returnChoice = scanner.nextLine().trim().toLowerCase();
                if (returnChoice.equalsIgnoreCase("H")) {
                    return;
                }
            }
        } while (description.isEmpty());

        do {
            System.out.println("Enter the vendor:\n");
            vendor = scanner.nextLine().trim();
            if (vendor.isEmpty()) {
                System.out.println("Vendor cannot be empty. Please try again or type \"H\" to return to the " +
                        "home screen" +
                        ".");
                String returnChoice = scanner.nextLine().trim().toLowerCase();
                if (returnChoice.equalsIgnoreCase("H")) {
                    return;
                }
            }
        } while (vendor.isEmpty());

        do {
            System.out.println("Enter the amount:\n");
            try {
                transactionValue = Math.abs(scanner.nextFloat());
                validAmount = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. lease try again or type \\\"H\\\" to return to the \" +\n" +
                        "                        \"home screen\" +\n" +
                        "                        \".\"");
                scanner.next();
                String returnChoice = scanner.nextLine().trim().toLowerCase();
                if (returnChoice.equalsIgnoreCase("H")) {
                    return;
                }
            }
        } while (!validAmount);

        scanner.nextLine();
        TransactionHandler.addEntry(description, vendor, menuSelection, transactionValue);
    }
}