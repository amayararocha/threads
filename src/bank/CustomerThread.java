package bank;

class CustomerThread extends Thread {
    private Bank bank;
    private int accountNumber;

    public CustomerThread(Bank bank, int accountNumber) {
        this.bank = bank;
        this.accountNumber = accountNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            bank.deposit(accountNumber, 80);
            bank.withdraw(accountNumber, 50);
        }
    }
}
