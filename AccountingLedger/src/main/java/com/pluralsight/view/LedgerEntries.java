package com.pluralsight.view;

import com.pluralsight.model.LedgerEntry;
import com.pluralsight.model.LedgerMap;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class LedgerEntries {
    public static void displayPayments() {
        TreeMap<LocalDateTime, LedgerEntry> payments = LedgerMap.displayFiltered(entry -> entry.getAmount() < 0);
        if (payments.isEmpty()) {
            System.out.println("No deposits found");
            return;
        }
        UIUtils.printColored("PAYMENTS", "yellow");
        UIUtils.printColored(String.format("%-20s%-20s%-30s%-30s%-10s\n", "DATE", "TIME", "DESCRIPTION", "VENDOR",
                "AMOUNT"), "yellow");
        for (LedgerEntry payment : payments.values()) {
            UIUtils.printColored(payment.toString(), "yellow");
        }
    }

    public static void displayDeposits() {
        TreeMap<LocalDateTime, LedgerEntry> deposits = LedgerMap.displayFiltered(entry -> entry.getAmount() > 0);
        if (deposits.isEmpty()) {
            System.out.println("No deposits found");
            return;
        }
        System.out.println("DEPOSITS: \n");
        UIUtils.printColored(String.format("%-20s%-20s%-30s%-30s%-10s\n", "DATE", "TIME", "DESCRIPTION", "VENDOR",
                "AMOUNT"), "green");
        for (LedgerEntry deposit : deposits.values()) {
            UIUtils.printColored(deposit.toString(), "green");
        }
    }

    public static void displayAll() {
        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.getEntries();
        if (entries.isEmpty()) {
            System.out.println("No entries found");
            return;
        }
        UIUtils.printColored("ALL ENTRIES", "magenta");
        UIUtils.printColored(String.format("%-20s%-20s%-30s%-30s%-10s\n", "DATE", "TIME", "DESCRIPTION", "VENDOR",
                "AMOUNT"), "magenta");
        for (LedgerEntry entry : entries.values()) {
            UIUtils.printColored(entry.toString(), "magenta");
        }
    }
}
