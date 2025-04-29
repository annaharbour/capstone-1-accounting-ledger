package com.pluralsight.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

public class LedgerMap {
    //    Make a tree map with all the entries listed newest first
    private static TreeMap<LocalDateTime, LedgerEntry> entries = new TreeMap<>(java.util.Collections.reverseOrder());

    //    add entry to tree map
    public static void addEntry(LedgerEntry entry) {
        entries.put(entry.getDateTimeStamp(), entry);
        System.out.println("Entry added and saved successfully.");
    }

    //    get all entries, unfiltered
    public static TreeMap<LocalDateTime, LedgerEntry> getEntries() {
        return entries;
    }

    //    https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
//    Predicate evaluates using parameters of test method
//    here I'm constructing a new tree map of only those that meet the condition, which I'm passing in from
//    LedgerEntries screen (payment/deposit)
    public static TreeMap<LocalDateTime, LedgerEntry> displayFiltered(Predicate<LedgerEntry> filter) {
//        Is creating another data structure the most efficient way to do this???
        TreeMap<LocalDateTime, LedgerEntry> filteredEntries = new TreeMap<>();
        for (Map.Entry<LocalDateTime, LedgerEntry> entry : entries.entrySet()) {
            if (filter.test(entry.getValue())) {
                filteredEntries.put(entry.getKey(), entry.getValue());
            }
        }
        return filteredEntries;
    }

}

