package com.pluralsight.data;

import com.pluralsight.model.LedgerEntry;
import com.pluralsight.model.LedgerMap;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileHandler extends DataHandler {
    private static final String FILE_NAME = "transactions.csv";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void save(LedgerMap ledger) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("Date,Time,Description,Vendor,Amount\n"); // CSV header
            for (var entry : ledger.getEntries().entrySet()) {
                LocalDateTime dateTime = entry.getKey(); // TreeMap Key
                LedgerEntry ledgerEntry = entry.getValue(); // Corresponding value
                writer.write(String.format("%s,%s,%s,%s,%.2f\n", // entry fields
                        ledgerEntry.getFormattedDate(),
                        ledgerEntry.getFormattedTime(),
                        ledgerEntry.getDescription(),
                        ledgerEntry.getVendor(),
                        ledgerEntry.getAmount()));
            }
        } catch (IOException e) {
            System.err.println("Error saving ledger to file: " + e.getMessage());
        }
    }

    @Override
    public LedgerMap load() {
        LedgerMap ledger = new LedgerMap();
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
                return new LedgerMap();
            } catch (IOException e) {
                System.err.println("Error loading ledger from file: " + e.getMessage());
            }
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            reader.readLine(); // Skip header
            String line;
            // add each row to treemap of entries
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    LocalDateTime dateTime = LocalDateTime.parse(parts[0] + " " + parts[1], DATE_FORMATTER);
                    String description = parts[2];
                    String vendor = parts[3];
                    float amount = Float.parseFloat(parts[4]);
                    LedgerEntry entry = new LedgerEntry(dateTime, description, vendor, amount);
                    ledger.addEntry(entry);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading ledger from file: " + e.getMessage());
        }
        return ledger;
    }
}