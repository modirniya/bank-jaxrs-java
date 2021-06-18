package dev.cyrus.data;

import dev.cyrus.model.Account;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private static final Map<Integer, Account> accounts = new HashMap<>();

    public static Map<Integer, Account> getAccounts() {
        return accounts;
    }
}
