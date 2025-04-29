package com.pluralsight.controller;

import com.pluralsight.model.LedgerEntry;
import com.pluralsight.model.LedgerMap;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.TreeMap;

public class ReportHandler {
    public static void generateMonthToDateReport() {
        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.displayFiltered(entry ->
                entry.getDateTimeStamp().getMonth() == LocalDateTime.now().getMonth() &&
                        entry.getDateTimeStamp().getYear() == LocalDateTime.now().getYear()
        );

        System.out.printf("\n\nMONTH TO DATE REPORT: %s %s\n\n",
                LocalDateTime.now().getMonth(), LocalDateTime.now().getDayOfMonth());
        float balance = 0;
        float totalPayments = 0;
        float totalDeposits = 0;
        ArrayList<LedgerEntry> deposits = new ArrayList<>();
        ArrayList<LedgerEntry> payments = new ArrayList<>();

        System.out.println("TRANSACTIONS:");
        for (LedgerEntry entry : entries.values()) {
            balance += entry.getAmount();
            System.out.println(entry);

            if (entry.getAmount() <= 0) {
                payments.add(entry);
            } else {
                deposits.add(entry);
            }
        }
        System.out.printf("Balance: %.2f\n", balance);

        System.out.println("\nDEPOSITS:");
        for (LedgerEntry deposit : deposits) {
            System.out.println(deposit);
            totalDeposits += deposit.getAmount();
        }
        System.out.printf("Total Deposits: %.2f\n", totalDeposits);

        System.out.println("\nPAYMENTS:");
        for (LedgerEntry payment : payments) {
            System.out.println(payment);
            totalPayments += payment.getAmount();
        }
        System.out.printf("Total Payments: %.2f\n", totalPayments);
//        return following info then pass into Report() in reports

//        time frame heading
//        red - all payments
//        green - all deposits
//        together, listed by datetime stamp
        //account balance

//        all payments
//        total amount of payments
//        
//        all deposits
//        total amount of deposits
//
//        prompt user whether they want to export a csv
//        y/n
//        return to reports screen
    }

    public static void generatePreviousMonthReport() {
        System.out.println("Previous Month Report: \n");
        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.displayFiltered(entry ->
                entry.getDateTimeStamp().getMonth() == LocalDateTime.now().minusMonths(1).getMonth() &&
                        entry.getDateTimeStamp().getYear() == LocalDateTime.now().minusMonths(1).getYear()
        );
        for (LedgerEntry entry : entries.values()) {
            System.out.println(entry.toString());
        }
    }

    public static void generateYearToDateReport() {
        System.out.println("Year To Date Report: \n");
        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.displayFiltered(entry ->
                entry.getDateTimeStamp().getYear() == LocalDateTime.now().getYear()
        );
        for (LedgerEntry entry : entries.values()) {
            System.out.println(entry.toString());
        }
    }

    public static void generatePreviousYearReport() {
        System.out.println("Previous Year Report: \n");
        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.displayFiltered(entry ->
                entry.getDateTimeStamp().getYear() == LocalDateTime.now().minusYears(1).getYear()
        );
        for (LedgerEntry entry : entries.values()) {
            System.out.println(entry.toString());
        }
    }

    public static void generateReportByVendor(String vendorName) {
        System.out.println("Report By Vendor: " + vendorName + "\n");
        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.displayFiltered(entry ->
                entry.getVendor().equalsIgnoreCase(vendorName)
        );
        for (LedgerEntry entry : entries.values()) {
            System.out.println(entry.toString());
        }
    }
}