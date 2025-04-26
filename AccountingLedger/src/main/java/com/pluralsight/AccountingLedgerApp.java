package com.pluralsight;

import com.pluralsight.view.HomeScreen;

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
                    System.out.println("Deposit Screen\n");
                    break;
                case 'P':
                    System.out.println("Payment Screen\n");
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
            }
        }
    }

}