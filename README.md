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
2023-04-15|10:13:25|ergonomic keyboard|Amazon|-89.50
2023-04-15|11:15:00|Invoice 1001 paid|Joe|1500.00


