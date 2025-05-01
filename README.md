# Accounting Ledger CLI Application

## 📘 Overview

This is a **Java-based command-line accounting ledger application** developed as part of the Java Development Fundamentals Capstone 1 project for the Pluralsight Learn to Code Academy. The application allows users to track personal or business financial transactions such as deposits and payments. All data is stored in a `transactions.csv` file for easy access and persistence.

Users can add deposits and payments to their ledger, filter and view view transactions, and generate financial reports from a clean and simple text-based interface.

---

## 🚀 Features

- Make New **Deposits** and **Payments**
- View Ledger Data
  - **All Transactions**
  - **Deposits**
  - **Payments**
- Generate Financial Reports:
  - **Month-to-Date**
  - **Previous Month**
  - **Year-to-Date**
  - **Previous Year**
  - **Search by Vendor**
  -  **Custom Search** by Date Start/End, Description, Vendor, Amount
- All transactions are retrieved from and stored in a CSV file: `transactions.csv`
- Easy to navigate CLI menu system
- Entries sorted by most recent at the top

---

## 📁 Transaction File Format

All ledger entries are saved to a file named `transactions.csv` in the following format:


date|time|description|vendor|amount

![Screenshot 2025-04-30 15 51 18](https://github.com/user-attachments/assets/218282a9-445e-4f7a-9b0e-b1d0730b475a)



## 📌 Interesting Code Snippets

One interesting piece of logic in this application is the dynamic filtering in the **Custom Search** feature. It allows users to input any combination of search fields, and the program applies only the filters provided:

```java
if (!startDateInput.isEmpty()) {
    filteredList = filteredList.stream()
        .filter(entry -> !entry.getDate().isBefore(LocalDate.parse(startDateInput)))
        .collect(Collectors.toList());
}

if (!vendorInput.isEmpty()) {
    filteredList = filteredList.stream()
        .filter(entry -> entry.getVendor().equalsIgnoreCase(vendorInput))
        .collect(Collectors.toList());
}
```
Another interesting architectural decision is the extension of a DataHandler class to create the FileHandler which writes and reads from the transactions csv. This allows for the easy integration of other forms of data handler, such as a SQL database, with minimal to no code changes throughout the rest of the app.

```java

public abstract class DataHandler {
    public abstract void save(LedgerMap ledger);
    public abstract LedgerMap load();

    public static DataHandler createHandler() {
        return new FileHandler();
    }
}

public class FileHandler extends DataHandler {
    private static final String FILE_NAME = "transactions.csv";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void save(LedgerMap ledger) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write("Date,Time,Description,Vendor,Amount\n"); // CSV header
            for (var entry : ledger.getEntries().entrySet()) {
                LocalDateTime dateTime = entry.getKey(); // TreeMap Key
                LedgerEntry ledgerEntry = entry.getValue(); // Corresponding value
                writer.write(String.format("%s,%s,%s,%s,%.2f\n", // entry fields
                        ledgerEntry.getFormattedDate(),
                        ledgerEntry.getFormattedTime(),
                        ledgerEntry.getDescription(),
                        ledgerEntry.getVendor(),
                        ledgerEntry.getAmount()));
            }
        } catch (IOException e) {
            System.err.println("Error saving ledger to file: " + e.getMessage());
        }
    }

    @Override
    public LedgerMap load() {
        LedgerMap ledger = new LedgerMap();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            reader.readLine(); // Skip header
            String line;
            // add each row to treemap of entries
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    LocalDateTime dateTime = LocalDateTime.parse(parts[0] + " " + parts[1], DATE_FORMATTER);
                    String description = parts[2];
                    String vendor = parts[3];
                    float amount = Float.parseFloat(parts[4]);
                    LedgerEntry entry = new LedgerEntry(dateTime, description, vendor, amount);
                    ledger.addEntry(entry);
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading ledger from file: " + e.getMessage());
        }
        return ledger;
    }
}

```
## Project Structure

project-root/
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   ├── pluralsight/
│   │   │   │   │   ├── AccountingLedgerApp.java
│   │   │   │   │   ├── controller/
│   │   │   │   │   │   ├── TransactionHandler.java
│   │   │   │   │   │   ├── ReportHandler.java
│   │   │   │   │   ├── data/
│   │   │   │   │   │   ├── DataHandler.java
│   │   │   │   │   ├── model/
│   │   │   │   │   │   ├── LedgerEntry.java
│   │   │   │   │   │   ├── LedgerMap.java
│   │   │   │   │   ├── view/
│   │   │   │   │   │   ├── HomeScreen.java
│   │   │   │   │   │   ├── LedgerEntries.java
│   │   │   │   │   │   ├── Reports.java
│   │   │   │   │   │   ├── Transaction.java
│   │   │   │   │   │   ├── UIUtils.java
