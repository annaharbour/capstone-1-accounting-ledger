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

    public String getFormattedDate() {
        DateTimeFormatter fmtDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return dateTimeStamp.format(fmtDate);
    }

    public String getFormattedTime() {
        DateTimeFormatter fmtTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        return dateTimeStamp.format(fmtTime);
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
        return this.getFormattedDate() + "|" + this.getFormattedTime() + "|" + description + "|" + vendor + "|" + String.format(
                "%.2f", amount);
    }
}
