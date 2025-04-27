package com.pluralsight.view;

import com.pluralsight.controller.TransactionHandler;

import java.util.Scanner;

public class Transaction {
    public static void handleTransaction(String menuSelection, Scanner scanner) {
        System.out.println("Enter a description for the ledger entry:\n");
        String description = scanner.nextLine();
        System.out.println("Enter the vendor\n");
        String vendor = scanner.nextLine();
        System.out.println("Enter the amount: \n");
        float transactionValue = Math.abs(scanner.nextFloat());
        scanner.nextLine();

        TransactionHandler.addEntry(description, vendor, menuSelection, transactionValue);
    }
}
