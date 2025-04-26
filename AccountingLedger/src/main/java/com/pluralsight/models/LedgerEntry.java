package com.pluralsight.models;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LedgerEntry {
    private LocalDateTime dateTimeStamp;
    private String description;
    private String vendor;
    private BigDecimal amount;

    public LedgerEntry(LocalDateTime dateTimeStamp, String description, String vendor, BigDecimal amount) {
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

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "LedgerEntry{" +
                "dateTimeStamp=" + dateTimeStamp +
                ", description='" + description + '\'' +
                ", vendor='" + vendor + '\'' +
                ", amount=" + amount +
                '}';
    }
}
