package com.pluralsight.controller;

import java.math.BigDecimal;

public class TransactionHandler {
    public static void addEntry(String transactionDateTime, String description, String vendor,
                                char menuSelection, Double transactionValue) {
//TODO: format datetime for insertion
        if (menuSelection == 'P') transactionValue *= -1;
        BigDecimal amount = new BigDecimal(transactionValue);
//TODO: filehandler
        System.out.println("Adding entry");
    }
}
