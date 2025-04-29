package com.pluralsight.view;

import com.pluralsight.model.LedgerEntry;
import com.pluralsight.model.LedgerMap;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.function.Predicate;

public class CustomSearch {
    public static TreeMap<LocalDateTime, LedgerEntry> promptUser(Scanner scanner) {
//        List of filters
        List<Predicate<LedgerEntry>> filters = new ArrayList<>();

        System.out.println("Start Date (yyyy-MM-dd): ");
        String startDateStr = scanner.nextLine();
        if (!startDateStr.isEmpty()) {
            try {
                LocalDateTime start = LocalDate.parse(startDateStr).atStartOfDay();
                filters.add(entry -> !entry.getDateTimeStamp().isBefore(start));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Bypassing filter.");
            }
        }

        System.out.println("End Date (yyyy-MM-dd): ");
        String endDateStr = scanner.nextLine();
        if (!endDateStr.isEmpty()) {
            try {
                LocalDateTime end = LocalDateTime.parse(endDateStr);
                filters.add(entry -> !entry.getDateTimeStamp().isAfter(end));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Bypassing filter.");
            }
        }

        System.out.println("Description: ");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            filters.add(entry -> entry.getDescription().toLowerCase().contains(description.toLowerCase()));
        }

        System.out.println("Vendor: ");
        String vendor = scanner.nextLine();
        if (!vendor.isEmpty()) {
            filters.add(entry -> entry.getVendor().equalsIgnoreCase(vendor));
        }

        System.out.println("Amount: ");
        String amountStr = scanner.nextLine();
        if (!amountStr.isEmpty()) {
            try {
                float amount = Float.parseFloat(amountStr);
                filters.add(entry -> entry.getAmount() == amount);
            } catch (NumberFormatException e) {
                System.out.println("Invalid value. Bypassing filter.");
            }
        }

        System.out.println("\nGenerating your custom report...\n");

        TreeMap<LocalDateTime, LedgerEntry> entries = LedgerMap.displayFiltered(entry ->
                filters.stream().allMatch(f -> f.test(entry))
        );

        return entries;
    }
}
