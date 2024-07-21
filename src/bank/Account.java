package bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Account {
    private int accountNumber;
    private double balance;
    private List<String> transactionHistory;

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        transactionHistory.add(new Date() + " - Deposit: $" + amount);
    }

    public synchronized void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(new Date() + " - Withdraw: $" + amount);
        } else {
            transactionHistory.add(new Date() + " - Withdraw Failed: $" + amount);
        }
    }

    public double getBalance() {
        return balance;
    }

    public List<String> getTransactionHistory() {
        return transactionHistory;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
}
