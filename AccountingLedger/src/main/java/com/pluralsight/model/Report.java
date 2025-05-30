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
            UIUtils.printColored(entry.toString(), "magenta");
            if (entry.getAmount() <= 0) {
                payments.add(entry);
            } else {
                deposits.add(entry);
            }
        }
        UIUtils.printColored(String.format("Balance: %.2f\n", balance), "magenta");

    }

    public void displayDeposits() {
        System.out.println("\nDEPOSITS:");
        for (LedgerEntry deposit : deposits) {
            UIUtils.printColored(deposit.toString(), "green");
            totalDeposits += deposit.getAmount();
        }
        if(totalDeposits != 0) {
            UIUtils.printColored(String.format("Total Deposits: %.2f\n", totalDeposits), "green");
        }
    }

    public void displayPayments() {
        System.out.println("\nPAYMENTS:");
        for (LedgerEntry payment : payments) {
            UIUtils.printColored(payment.toString(), "yellow");
            totalPayments -= payment.getAmount();
        }
        if(totalPayments != 0) {
            UIUtils.printColored(String.format("Total Payments: %.2f\n", totalPayments), "yellow");
        }
    }
}