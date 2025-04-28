package com.pluralsight.data;

import com.pluralsight.model.LedgerMap;

public abstract class DataHandler {
    public abstract void save(LedgerMap ledger);
    public abstract LedgerMap load();

    public static DataHandler createHandler() {
        return new FileHandler();
    }
}
