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
            System.out.println("\nEnter a description for the ledger entry:");
            description = scanner.nextLine().trim();
            if (description.isEmpty()) {
                UIUtils.printColored("Description required. Enter to try again or type \"H\" to return to the home " +
                        "screen.", "red");
                String returnChoice = scanner.nextLine().trim().toLowerCase();
                if (returnChoice.equalsIgnoreCase("h")) {
                    return;
                }
            }
        } while (description.isEmpty());

        do {
            System.out.println("\nEnter the vendor:");
            vendor = scanner.nextLine().trim();
            if (vendor.isEmpty()) {
                UIUtils.printColored(
                        "Vendor required. Enter to try again or type \"H\" to return to the home screen.", "red");
                String returnChoice = scanner.nextLine().trim().toLowerCase();
                if (returnChoice.equalsIgnoreCase("H")) {
                    return;
                }
            }
        } while (vendor.isEmpty());

        do {
            System.out.println("\nEnter the amount:");
            try {
                transactionValue = Math.abs(scanner.nextFloat());
                scanner.nextLine();
                validAmount = true;
            } catch (InputMismatchException e) {
                UIUtils.printColored(
                        "Invalid amount input. Try again.", "red");
                scanner.nextLine();
                String returnChoice = scanner.nextLine().trim().toLowerCase();
                if (returnChoice.equalsIgnoreCase("H")) {
                    return;
                }
            }
        } while (!validAmount);
        System.out.println("Enter to return to menu.");
        scanner.nextLine();
        TransactionHandler.addEntry(description, vendor, menuSelection, transactionValue);
    }
}