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

##  📸 Screenshots

Flash Screen / Home Screen

![Screenshot 2025-05-01 15 38 40](https://github.com/user-attachments/assets/575ea1f7-5770-469e-bbf8-73c25f42e8ba)![Screenshot 2025-05-01 15 39 42](https://github.com/user-attachments/assets/2adf0c0d-d882-48bc-95ce-2e56313d4a44)

Add a Deposit or Payment

![Screenshot 2025-05-01 15 40 26](https://github.com/user-attachments/assets/a530b38d-d14f-46a3-b2af-93e8b073f0a3)![Screenshot 2025-05-01 15 43 50](https://github.com/user-attachments/assets/6d2407ad-5b60-4039-9557-ae7210c27639)


Ledger: All Entries / Payments / Deposits

![Screenshot 2025-05-01 16 09 27](https://github.com/user-attachments/assets/ac0f338d-288a-432f-a9f8-3caddf7c171d)

![Screenshot 2025-05-01 15 45 52](https://github.com/user-attachments/assets/32608c87-73fd-4b54-ae8f-fdf88687ed66)

Reports Examples:

![Screenshot 2025-05-01 16 10 19](https://github.com/user-attachments/assets/c2d0fc9a-0893-454d-9f60-1814029a6c68)

![Screenshot 2025-05-01 15 46 38](https://github.com/user-attachments/assets/b7e9ae16-ab01-4093-8769-fc2e6482725f)
![Screenshot 2025-05-01 15 46 38](https://github.com/user-attachments/assets/1879dbad-076d-4cc4-8e73-240bacc690c1)
![Screenshot 2025-05-01 15 51 02](https://github.com/user-attachments/assets/3468a1ef-dd65-4929-8003-fe9bfeb43d34)



## 📌 Interesting Code Snippets

### 🧠 State Management Using a Tree Map

*** ➤ Why TreeMap? ***
- **Sorted Order:** TreeMap maintains sorted keys – in this case, `LocalDateTime` – enabling efficient chronological storage and retrieval.
- **Reverse Chronological View:** Using `Collections.reverseOrder()` ensures the newest entries appear first, ideal for user display without additional sorting logic.
- **Efficient Filtering:** Leveraging Java’s functional interfaces (e.g., `Predicate<LedgerEntry>`), we can easily implement flexible, on-the-fly filters without restructuring the data.
- **Single Source of Truth:** The TreeMap acts as the application's stateful in-memory data model that reflects all loaded or user-added transactions.

```java
public class LedgerMap {
    //    Make a tree map with all the entries listed newest first
    private static TreeMap<LocalDateTime, LedgerEntry> entries = new TreeMap<>(java.util.Collections.reverseOrder());

    //    add entry to tree map
    public static void addEntry(LedgerEntry entry) {
        entries.put(entry.getDateTimeStamp(), entry);
    }

    //    get all entries, unfiltered
    public static TreeMap<LocalDateTime, LedgerEntry> getEntries() {
        return entries;
    }

    //    https://docs.oracle.com/javase/8/docs/api/java/util/function/Predicate.html
//    Predicate evaluates using parameters of test method
//    here I'm constructing a new tree map of only those that meet the condition, which I'm passing in from
//    LedgerEntries screen (payment/deposit)
    public static TreeMap<LocalDateTime, LedgerEntry> displayFiltered(Predicate<LedgerEntry> filter) {
        TreeMap<LocalDateTime, LedgerEntry> filteredEntries = new TreeMap<>(java.util.Collections.reverseOrder());
        for (Map.Entry<LocalDateTime, LedgerEntry> entry : entries.entrySet()) {
            if (filter.test(entry.getValue())) {
                filteredEntries.put(entry.getKey(), entry.getValue());
            }
        }
        return filteredEntries;
    }

}

```

### ➤ What is being done:
The application uses a `TreeMap<LocalDateTime, LedgerEntry>` (in reverse order) to store all ledger entries in memory.

---

### 💾 Data Persistence: CSV + Abstraction Layer

*** ➤ File-Based Storage:***
The application persists entries to a CSV file (`transactions.csv`) via the `FileHandler` class.

### ➤ Design Pattern Used:
`FileHandler` **extends** the abstract class `DataHandler`.


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

### ➤ Why this abstraction matters:
- This architectural choice cleanly separates **data format/IO logic** from **business logic**.
- The app only references `DataHandler`, so swapping out storage (e.g., moving from file to database) requires:
  1. Implementing a new subclass like `DatabaseHandler`
  2. Changing **one line** in the app:
     ```java
     private static DataHandler dataHandler = DataHandler.createHandler();
     ```
  Inside `createHandler()`, you can return the database version instead.
---

## 📦 Summary of Key Architectural Choices

| Component        | Purpose                                                                 | Benefit                                                   |
|------------------|-------------------------------------------------------------------------|------------------------------------------------------------|
| `TreeMap`        | Holds ledger entries sorted by `LocalDateTime`                         | Sorted order, fast access, reverse view for UI display     |
| `LedgerMap`      | Encapsulates TreeMap and provides filter capabilities                  | Centralized state with reusable filtering logic            |
| `DataHandler`    | Abstract base for data persistence                                     | Makes it easy to swap between File/DB without rewriting app|
| `FileHandler`    | Concrete class for CSV storage                                         | Lightweight, file-based storage                            |
| `createHandler()`| Factory method to choose storage method                                | One-line switch from file to DB                            |

---

## 🧩 Next Steps / Extensibility Ideas

- Implement a `DatabaseHandler` for SQL-based persistence.
- Add GUI or web front-end for broader usability.
- Enhance filtering and reporting features using the predicate system.
