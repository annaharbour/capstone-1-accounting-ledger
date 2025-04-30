package com.pluralsight.model;

import com.pluralsight.view.UIUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeMap;

public class Report {
    private float balance = 0;
    private float totalPayments = 0;
    private float totalDeposits = 0;
    private ArrayList<LedgerEntry> deposits = new ArrayList<>();
    private ArrayList<LedgerEntry> payments = new ArrayList<>();
    private TreeMap<LocalDateTime, LedgerEntry> entries;

    public Report(TreeMap<LocalDateTime, LedgerEntry> entries) {
        this.entries = entries;
    }

    public void displayTransactions() {
        System.out.println("\nTRANSACTIONS:");
        for (LedgerEntry entry : this.entries.values()) {
            balance += entry.getAmount();
            System.out.println(entry);

            if (entry.getAmount() <= 0) {
                payments.add(entry);
            } else {
                deposits.add(entry);
            }
        }
        System.out.printf("Balance: %.2f\n", balance);
    }

    public void displayDeposits() {
        System.out.println("\nDEPOSITS:");
        for (LedgerEntry deposit : deposits) {
//            System.out.println(deposit);
            UIUtils.printColored(deposit.toString(), "green");

            totalDeposits += deposit.getAmount();
        }
        UIUtils.printColored(String.format("Total Deposits: %.2f\n", totalDeposits), "green");
    }

    public void displayPayments() {
        System.out.println("\nPAYMENTS:");
        for (LedgerEntry payment : payments) {
            System.out.println(payment);
            totalPayments -= payment.getAmount();
        }
        System.out.printf("Total Payments: %.2f\n", totalPayments);
    }
}