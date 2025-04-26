package com.pluralsight.view;

import com.pluralsight.controller.TransactionHandler;

import java.util.Scanner;

public class Transaction {
    public static void handleTransaction(String menuSelection, Scanner scanner) {
        System.out.println("Enter the date of the transaction or press enter to autofill with today's date and time: " +
                "\n");
        String dateString = scanner.nextLine();
        System.out.println("Enter a description for the ledger entry:\n");
        String description = scanner.nextLine();
        System.out.println("Enter the vendor\n");
        String vendor = scanner.nextLine();
        System.out.println("Enter the amount: \n");
        Double transactionValue = Math.abs(scanner.nextDouble());
        scanner.nextLine();

        TransactionHandler.addEntry(dateString, description, vendor, menuSelection, transactionValue);
    }
}
