package com.pluralsight;

import com.pluralsight.view.HomeScreen;
import com.pluralsight.view.Transaction;

import java.util.Scanner;

public class AccountingLedgerApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HomeScreen.displayMenu();
        boolean running = true;
        while (running) {
            char menuSelection = Character.toUpperCase(scanner.nextLine().trim().charAt(0));
            switch (menuSelection) {
                case 'D':
                    System.out.println("Make a deposit: \n");
                    Transaction.handleTransaction(menuSelection, scanner);
                    break;
                case 'P':
                    System.out.println("Make a payment: \n");
                    Transaction.handleTransaction(menuSelection, scanner);
                    break;
                case 'L':
                    System.out.println("View Ledger\n");
                    break;
                case 'X':
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