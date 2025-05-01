package com.pluralsight.view;

import com.pluralsight.model.LedgerEntry;
import com.pluralsight.model.LedgerMap;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class LedgerEntries {
    public static void displayPayments() {
        System.out.println("PAYMENTS: \n");
        TreeMap<LocalDateTime, LedgerEntry> payments = LedgerMap.displayFiltered(entry -> entry.getAmount() < 0);
        if (payments.isEmpty()) {
            System.out.println("No deposits found");
            return;
        }
        for (LedgerEntry payment : payments.values()) {
            UIUtils.printColored(payment.toString(), "yellow");
        }
    }

    public static void displayDeposits() {
        System.out.println("DEPOSITS: \n");
        TreeMap<LocalDateTime, LedgerEntry> deposits = LedgerMap.displayFiltered(entry -> entry.getAmount() > 0);
        if (deposits.isEmpty()) {
            System.out.println("No deposits found");
            return;
        }
        for (LedgerEntry deposit : deposits.values()) {
            UIUtils.printColored(deposit.toString(), "green");
        }
    }

    public static void displayAll() {
        System.out.println("Displaying all entries...");
        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.getEntries();
        if (entries.isEmpty()) {
            System.out.println("No entries found");
            return;
        }
        for (LedgerEntry entry : entries.values()) {
            UIUtils.printColored(entry.toString(), "magenta");
        }
    }
}
