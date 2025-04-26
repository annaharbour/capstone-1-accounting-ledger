package com.pluralsight.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class TransactionHandler {
    public static void addEntry(String transactionDateTime, String description, String vendor,
                                String menuSelection, Double transactionValue) {
//TODO: format datetime for insertion
        if (menuSelection == "P") transactionValue *= -1;
        BigDecimal amount = new BigDecimal(transactionValue);
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        String formattedAmount = decimalFormat.format(amount);

//        TODO: format amount for entry
//TODO: filehandler
        System.out.printf("Adding entry: YYYY-MM-dd|HH:mm:ss|description|vendor|$$$\n");
    }
}
