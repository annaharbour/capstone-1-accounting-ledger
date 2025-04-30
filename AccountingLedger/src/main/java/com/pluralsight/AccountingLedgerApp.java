package com.pluralsight;

import com.pluralsight.data.DataHandler;
import com.pluralsight.model.LedgerMap;
import com.pluralsight.view.HomeScreen;
import com.pluralsight.view.UIUtils;

import java.util.Scanner;

public class AccountingLedgerApp {
    private static Scanner scanner = new Scanner(System.in);
//    Creating file handler - one line change in Data Handler and here to switch to a database later
    private static DataHandler dataHandler = DataHandler.createHandler();
    //    data handler call to populate ledger map with entries stored there
    private static LedgerMap ledger = dataHandler.load();

    public static void main(String[] args) {
        UIUtils.displayDollarSign();
        UIUtils.clearScreen();
        boolean running = true;
        while (running) {;
            running = HomeScreen.makeSelection(scanner);
            dataHandler.save(ledger);
        }
    }
}