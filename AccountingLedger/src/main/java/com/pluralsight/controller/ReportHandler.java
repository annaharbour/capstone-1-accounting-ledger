package com.pluralsight.controller;

public class ReportHandler {
    public static void generateMonthToDateReport(){
        System.out.println("Generating month to date report...");
    }

    public static void generatePreviousMonthReport(){
        System.out.println("generating prev month report...");
    }

    public static void generateYearToDateReport(){
        System.out.println("Generating year to date report...");
    }

    public static void generatePreviousYearReport(){
        System.out.println("Generating report from previous year...");
    }

    public static void generateReportByVendor(String vendorName){
        System.out.println("Generating report by vendor..." + vendorName);
    }
}
