package com.pluralsight.controller;
import com.pluralsight.model.LedgerEntry;
import com.pluralsight.model.LedgerMap;

import java.time.LocalDateTime;

public class TransactionHandler {

    public static void addEntry(String description, String vendor,
                                String menuSelection, float transactionValue) {

//      If Payment, Convert to Negative Value
        if (menuSelection.equals("P")) transactionValue *= -1;

//      TimeStamp
        LocalDateTime entryDateTime = LocalDateTime.now();

//      Instantiate and Insert New Entry
        LedgerEntry entry = new LedgerEntry(entryDateTime, description, vendor, transactionValue);
        LedgerMap.addEntry(entry);
    }
}
