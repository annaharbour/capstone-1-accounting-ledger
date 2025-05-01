package com.pluralsight.view;

import com.pluralsight.controller.ReportHandler;

import java.util.Scanner;

public class Reports {

    public static String[] menuOptions = {"1) Month To Date", "2) Previous Month", "3) Year To Date", "4) Previous " +
            "Year", "5) Search By Vendor", "6) Custom Report", "0) Back to Ledger", "H) Return to Home Screen"};

    public static void displayMenu() {
        System.out.println("\nWhat kind of report would you like to generate?");
        for (String option : menuOptions) {
            System.out.printf("\n\t %s\n", option);
        }
    }

    public static String promptForVendor(Scanner scanner) {
        System.out.println("Enter the vendor name: \n");
        String vendorName = scanner.nextLine();
        return vendorName;
    }

    public static void returnToMenu(Scanner scanner) {
      System.out.println("\nPress Enter to return to the menu...");
//        if (scanner.hasNextLine()) {
            scanner.nextLine();
//        }
    }

    public static String makeSelection(Scanner scanner) {
        while (true) {
            UIUtils.clearScreen();
            displayMenu();
            String menuSelection = scanner.nextLine().trim().toUpperCase();
            switch (menuSelection) {
                case "0":
                    return "LEDGER";
                case "1":
                    ReportHandler.generateMonthToDateReport();
                    returnToMenu(scanner);
                    break;
                case "2":
                    ReportHandler.generatePreviousMonthReport();
                    returnToMenu(scanner);
                    break;
                case "3":
                    ReportHandler.generateYearToDateReport();
                    returnToMenu(scanner);
                    break;
                case "4":
                    ReportHandler.generatePreviousYearReport();
                    returnToMenu(scanner);
                    break;
                case "5":
                    String vendorName = promptForVendor(scanner);
                    ReportHandler.generateReportByVendor(vendorName);
                    returnToMenu(scanner);
                    break;
                case "6":
                    ReportHandler.generateCustomReport(scanner);
                    returnToMenu(scanner);
                    break;
                case "H":
                    return "HOME";
                default:
                    UIUtils.printColored("Invalid menu selection", "red");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }
    }
}

