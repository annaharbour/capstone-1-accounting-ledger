package com.pluralsight.view;

import com.pluralsight.controller.ReportHandler;

import java.util.Scanner;

public class Reports {

    public static String[] menuOptions = {"1) Month To Date", "2) Previous Month", "3) Year To Date", "4) Previous " +
            "Year", "5) Search By Vendor", "0) Back to Ledger", "H) Return to Home Screen"};

    public static void displayMenu() {
        System.out.println("What kind of report would you like to generate?");
        for (String option : menuOptions) {
            System.out.printf("\t\n %s", option);
        }
    }

    public static String promptForVendor(Scanner scanner) {
        System.out.println("Enter the vendor name: ");
        String vendorName = scanner.nextLine();
        return vendorName;
    }


    public static String makeSelection(Scanner scanner) {
        String menuSelection = scanner.nextLine().trim().toUpperCase();
        while(true) {
            switch (menuSelection) {
                case "0":
                    return "LEDGER";
                case "1":
                    ReportHandler.generateMonthToDateReport();
                    break;
                case "2":
                    ReportHandler.generatePreviousMonthReport();
                    break;
                case "3":
                    ReportHandler.generateYearToDateReport();
                    break;
                case "4":
                    ReportHandler.generatePreviousYearReport();
                    break;
                case "5":
                    String vendorName = promptForVendor(scanner);
                    ReportHandler.generateReportByVendor(vendorName);
                    break;
                case "H":
                    return "HOME";
                default:
                    System.out.println("Invalid menu selection.");
                    displayMenu();
            }
        }
    }
}

