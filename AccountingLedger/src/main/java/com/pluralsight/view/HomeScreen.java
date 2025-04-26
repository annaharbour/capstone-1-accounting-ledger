package com.pluralsight.view;

public class HomeScreen {
    static String[] menuOptions = {"D) Add Deposit", "P) Make Payment (Debit)", "L) View Ledger", "X) Exit " +
            "Program"};

    public static void displayMenu() {
        for (String option : menuOptions) {
            System.out.println("\t\n" + option);
        }
    }
}
