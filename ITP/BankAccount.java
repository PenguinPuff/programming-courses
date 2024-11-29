package de.tum.cit.ase;

public class BankAccount {
    protected final int accountId;
    protected double balance;

    public BankAccount(int accountId, double initial) {
        this.accountId = accountId;
        balance = initial;
    }

    public void deposit(double amount) {
        balance = balance + amount;
        System.out.println("Deposit into account " + accountId + "\n" + "Amount:\t\t\t"
                + amount + "\n" + "New balance:\t" + balance + "\n");
    }

    public boolean withdraw(double amount) {
        System.out.println("Withdrawal from account " + accountId + "\n" + "Amount:\t\t\t" + amount);
        if (amount > balance) {
            System.out.println("Sorry, insufficient funds...\n");
            return false;
        }
        balance = balance - amount;
        System.out.println("New balance:\t" + balance + "\n");
        return true;
    }
}
