package bank;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        for (int i = 1; i <= 5; i++) {
            bank.addAccount(new Account(i));
        }

        Thread[] threads = new Thread[10];
        for (int i = 0; i < 5; i++) {
            threads[i] = new CustomerThread(bank, i + 1);
            threads[i].start();
        }

        for (int i = 0; i < 5; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 1; i <= 5; i++) {
            Account account = bank.getAccount(i);
            System.out.println("Account " + i + " Balance: $" + account.getBalance());
            System.out.println("Transaction History: " + account.getTransactionHistory());
        }
    }
}
