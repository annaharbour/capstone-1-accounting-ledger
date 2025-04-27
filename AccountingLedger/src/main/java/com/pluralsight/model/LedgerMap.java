package com.pluralsight.model;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;

public class LedgerMap {
    private static TreeMap<LocalDateTime, LedgerEntry> entries = new TreeMap<>(java.util.Collections.reverseOrder());

    public static void addEntry(LedgerEntry entry) {
        entries.put(entry.getDateTimeStamp(), entry);
    }

    public TreeMap<LocalDateTime, LedgerEntry> getEntries() {
        return entries;
    }

    public TreeMap<LocalDateTime, LedgerEntry> displayFiltered(Predicate<LedgerEntry> filter) {
        TreeMap<LocalDateTime, LedgerEntry> filteredEntries = new TreeMap<>();
        for (Map.Entry<LocalDateTime, LedgerEntry> entry : entries.entrySet()) {
            if (filter.test(entry.getValue())) {
                filteredEntries.put(entry.getKey(), entry.getValue());
            }
        }
        return filteredEntries;
    }
}

