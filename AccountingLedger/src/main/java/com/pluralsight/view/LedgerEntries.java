package com.pluralsight.view;

import com.pluralsight.model.LedgerEntry;
import com.pluralsight.model.LedgerMap;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class LedgerEntries {
    public static void displayPayments(){
        System.out.println("Displaying payments...");

    }

    public static void displayDeposits(){
        System.out.println("Displaying deposits...");
    }

    public static void displayAll(){
        System.out.println("Displaying all entries...");
        LedgerMap ledgerMap = new LedgerMap();
        TreeMap<LocalDateTime, LedgerEntry> entries = ledgerMap.getEntries();
        for(LedgerEntry entry: entries.values()){
            System.out.println(entry.toString());
        }
    }
}
