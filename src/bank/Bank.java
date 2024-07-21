package bank;

import bank.Account;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Bank {
    private Map<Integer, Account> accounts;

    public Bank() {
        accounts = new ConcurrentHashMap<>();
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void deposit(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
        }
    }

    public void withdraw(int accountNumber, double amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        }
    }
}
