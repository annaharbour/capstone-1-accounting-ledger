package com.pluralsight;

import com.pluralsight.data.DataHandler;
import com.pluralsight.model.LedgerMap;
import com.pluralsight.view.HomeScreen;
import com.pluralsight.view.Ledger;
import com.pluralsight.view.Transaction;

import java.util.Scanner;

public class AccountingLedgerApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {;
            HomeScreen.displayMenu();
            String menuSelection = scanner.nextLine().trim().toUpperCase();
            switch (menuSelection) {
                case "D":
                    System.out.println("Make a deposit: \n");
                    Transaction.handleTransaction(menuSelection, scanner);
                    break;
                case "P":
                    System.out.println("Make a payment: \n");
                    Transaction.handleTransaction(menuSelection, scanner);
                    break;
                case "L":
                    Ledger.displayMenu();
                    Ledger.makeSelection(scanner);
                    break;
                case "X":
                    System.out.println("Goodbye\n");
                    running = false;
                    scanner.close();
                    break;
                default:
                    System.out.println("Invalid menu selection.");
                    HomeScreen.displayMenu();
            }
        }
    }

}