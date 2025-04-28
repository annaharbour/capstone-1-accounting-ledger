package com.pluralsight.controller;

import com.pluralsight.model.LedgerEntry;
import com.pluralsight.model.LedgerMap;

import java.time.LocalDateTime;
import java.util.TreeMap;

public class ReportHandler {
    public static void generateMonthToDateReport() {
        System.out.println("Month To Date Report: \n");
        LedgerMap ledgerMap = new LedgerMap();
        TreeMap<LocalDateTime, LedgerEntry> entries = ledgerMap.displayFiltered(entry ->
                entry.getDateTimeStamp().getMonth() == LocalDateTime.now().getMonth() &&
                        entry.getDateTimeStamp().getYear() == LocalDateTime.now().getYear()
        );
        for (LedgerEntry entry : entries.values()) {
            System.out.println(entry.toString());
        }
    }

    public static void generatePreviousMonthReport() {
        System.out.println("Previous Month Report: \n");
        LedgerMap ledgerMap = new LedgerMap();
        TreeMap<LocalDateTime, LedgerEntry> entries = ledgerMap.displayFiltered(entry ->
                entry.getDateTimeStamp().getMonth() == LocalDateTime.now().minusMonths(1).getMonth() &&
                        entry.getDateTimeStamp().getYear() == LocalDateTime.now().minusMonths(1).getYear()
        );
        for (LedgerEntry entry : entries.values()) {
            System.out.println(entry.toString());
        }
    }

    public static void generateYearToDateReport() {
        System.out.println("Year To Date Report: \n");
        LedgerMap ledgerMap = new LedgerMap();
        TreeMap<LocalDateTime, LedgerEntry> entries = ledgerMap.displayFiltered(entry ->
                entry.getDateTimeStamp().getYear() == LocalDateTime.now().getYear()
        );
        for (LedgerEntry entry : entries.values()) {
            System.out.println(entry.toString());
        }
    }

    public static void generatePreviousYearReport() {
        System.out.println("Previous Year Report: \n");
        LedgerMap ledgerMap = new LedgerMap();
        TreeMap<LocalDateTime, LedgerEntry> entries = ledgerMap.displayFiltered(entry ->
                entry.getDateTimeStamp().getYear() == LocalDateTime.now().minusYears(1).getYear()
        );
        for (LedgerEntry entry : entries.values()) {
            System.out.println(entry.toString());
        }
    }

    public static void generateReportByVendor(String vendorName) {
        System.out.println("Report By Vendor: " + vendorName + "\n");
        LedgerMap ledgerMap = new LedgerMap();
        TreeMap<LocalDateTime, LedgerEntry> entries = ledgerMap.displayFiltered(entry ->
                entry.getVendor().equalsIgnoreCase(vendorName)
        );
        for (LedgerEntry entry : entries.values()) {
            System.out.println(entry.toString());
        }
    }
}