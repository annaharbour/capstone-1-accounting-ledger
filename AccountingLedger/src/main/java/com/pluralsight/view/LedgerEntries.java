package com.pluralsight.view;

import com.pluralsight.model.LedgerEntry;
import com.pluralsight.model.LedgerMap;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class LedgerEntries {
    public static void displayPayments() {
        System.out.println("PAYMENTS: \n");
        LedgerMap ledgerMap = new LedgerMap();
        TreeMap<LocalDateTime, LedgerEntry> payments = ledgerMap.displayFiltered(entry -> entry.getAmount() < 0);
        for (LedgerEntry payment : payments.values()) {
            System.out.println(payment.toString());
        }
    }

    public static void displayDeposits() {
        System.out.println("DEPOSITS: \n");
        LedgerMap ledgerMap = new LedgerMap();
        TreeMap<LocalDateTime, LedgerEntry> deposits = ledgerMap.displayFiltered(entry -> entry.getAmount() > 0);
        for (LedgerEntry deposit : deposits.values()) {
            System.out.println(deposit.toString());
        }
    }

    public static void displayAll() {
        System.out.println("Displaying all entries...");
        LedgerMap ledgerMap = new LedgerMap();
        TreeMap<LocalDateTime, LedgerEntry> entries = ledgerMap.getEntries();
        for (LedgerEntry entry : entries.values()) {
            System.out.println(entry.toString());
        }
    }
}
