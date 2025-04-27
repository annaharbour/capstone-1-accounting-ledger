package com.pluralsight.model;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class LedgerMap {
    private static TreeMap<LocalDateTime, LedgerEntry> entries = new TreeMap<>();

    public static void addEntry(LedgerEntry entry) {
        entries.put(entry.getDateTimeStamp(), entry);
    }

    public TreeMap<LocalDateTime, LedgerEntry> getEntries() {
        return entries;
    }
}

