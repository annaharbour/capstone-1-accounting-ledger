package com.pluralsight.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LedgerEntry {
    private LocalDateTime dateTimeStamp;
    private String description;
    private String vendor;
    private float amount;

    public LedgerEntry(LocalDateTime dateTimeStamp, String description, String vendor, float amount) {
        this.dateTimeStamp = dateTimeStamp;
        this.description = description;
        this.vendor = vendor;
        this.amount = amount;
    }

    public LocalDateTime getDateTimeStamp() {
        return dateTimeStamp;
    }

    public void setDateTimeStamp(LocalDateTime dateTimeStamp) {
        this.dateTimeStamp = dateTimeStamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmtTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter fmtDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        System.out.printf("Adding entry: %s|%s|%s|%s|%.2f\n", entryDateTime.format(fmtDate),
//                entryDateTime.format(fmtTime), description, vendor,
//                transactionValue);

        return dateTimeStamp.format(fmtDate) + "|" + dateTimeStamp.format(
                fmtTime) + "|" + description + "|" + vendor + "|" + amount;
    }
}
