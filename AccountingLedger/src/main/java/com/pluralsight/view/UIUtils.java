package com.pluralsight.view;

public class UIUtils {
    public static void main(String[] args) {
        displayDollarSign();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clearScreen();
        Ledger.displayMenu();
    }

    public static void printColored(String message, String colorName) {
        String colorCode;
        switch (colorName.toLowerCase()) {
            case "black":
                colorCode = "\u001b[30m";
                break;
            case "red":
                colorCode = "\u001b[31m";
                break;
            case "green":
                colorCode = "\u001b[32m";
                break;
            case "yellow":
                colorCode = "\u001b[33m";
                break;
            case "blue":
                colorCode = "\u001b[34m";
                break;
            case "magenta":
                colorCode = "\u001b[35m";
                break;
            case "cyan":
                colorCode = "\u001b[36m";
                break;
            case "white":
                colorCode = "\u001b[37m";
                break;
            default:
                colorCode = "\u001b[0m"; // Reset to default if color is invalid
        }
        System.out.println(colorCode + message + "\u001b[0m");
    }

    public static void clearScreen() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }

    public static void displayDollarSign() {
        printColored(
                "                                $$$$$$$$$$$                                \n" +
                        "                             $$$$$$$$$$$$$$$$$                             \n" +
                        "                          $$$$$$    $$$    $$$$$$                          \n" +
                        "                         $$$$       $$$       $$$$                        \n" +
                        "                         $$$$       $$$       $$$$                        \n" +
                        "                         $$$$       $$$                                    \n" +
                        "                         $$$$$$$$$$$$$$$                                  \n" +
                        "                                  $$$$$$$$$$$$                            \n" +
                        "                                       $$$$$$$$$$                         \n" +
                        "                                          $$$$$$$$                        \n" +
                        "                         $$$$       $$$       $$$$                        \n" +
                        "                         $$$$       $$$       $$$$                        \n" +
                        "                         $$$$       $$$       $$$$                        \n" +
                        "                          $$$$$$    $$$    $$$$$$                         \n" +
                        "                             $$$$$$$$$$$$$$$$                            \n" +
                        "                                $$$$$$$$$$$                              \n",
                "green");
        printColored(
                "                   Welcome to Anna's Accounting Ledger\n", "magenta");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


