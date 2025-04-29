package com.pluralsight.controller;

import com.pluralsight.model.LedgerEntry;
import com.pluralsight.model.LedgerMap;
import com.pluralsight.model.Report;
import com.pluralsight.view.CustomSearch;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.TreeMap;

public class ReportHandler {

    public static void generateMonthToDateReport() {
        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.displayFiltered(entry ->
                entry.getDateTimeStamp().getMonth() == LocalDateTime.now().getMonth() &&
                        entry.getDateTimeStamp().getYear() == LocalDateTime.now().getYear()
        );

        System.out.printf("\n\nMONTH TO DATE REPORT: %s %s\n\n",
                LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth());
        Report report = new Report(entries);
        report.displayTransactions();
        report.displayDeposits();
        report.displayPayments();
    }

    public static void generatePreviousMonthReport() {
        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.displayFiltered(entry ->
                entry.getDateTimeStamp().getMonth() == LocalDateTime.now().minusMonths(1).getMonth() &&
                        entry.getDateTimeStamp().getYear() == LocalDateTime.now().minusMonths(1).getYear()
        );
        System.out.printf("\n\nPREVIOUS MONTH REPORT: %s %s\n\n",
                LocalDateTime.now().minusMonths(1).getMonth(), LocalDateTime.now().getDayOfMonth());
        Report report = new Report(entries);
        report.displayTransactions();
        report.displayDeposits();
        report.displayPayments();
    }

    public static void generateYearToDateReport() {
        System.out.println("\n\nYear To Date Report: \n\n");
        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.displayFiltered(entry ->
                entry.getDateTimeStamp().getYear() == LocalDateTime.now().getYear()
        );
        System.out.printf("\n\nYEAR TO DATE REPORT: %s\n\n",
                LocalDateTime.now().getYear());
        Report report = new Report(entries);
        report.displayTransactions();
        report.displayDeposits();
        report.displayPayments();
    }

    public static void generatePreviousYearReport() {
        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.displayFiltered(entry ->
                entry.getDateTimeStamp().getYear() == LocalDateTime.now().minusYears(1).getYear()
        );
        System.out.printf("\n\nPREVIOUS YEAR REPORT: %s\n\n",
                LocalDateTime.now().minusYears(1).getYear());
        Report report = new Report(entries);
        report.displayTransactions();
        report.displayDeposits();
        report.displayPayments();
    }

    public static void generateReportByVendor(String vendorName) {
        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.displayFiltered(entry ->
                entry.getVendor().equalsIgnoreCase(vendorName)
        );
        System.out.printf("\n\nVENDOR REPORT: %s\n\n", vendorName);
        Report report = new Report(entries);
        report.displayTransactions();
        report.displayDeposits();
        report.displayPayments();
    }

    public static void generateCustomReport(Scanner scanner){
        TreeMap<LocalDateTime, LedgerEntry> entries = CustomSearch.promptUser(scanner);
        System.out.printf("\n\nYOUR CUSTOM REPORT:\n\n");
        Report report = new Report(entries);
        report.displayTransactions();
        report.displayDeposits();
        report.displayPayments();
    }
}