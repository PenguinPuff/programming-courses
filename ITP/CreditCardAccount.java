package de.tum.cit.ase;

public class CreditCardAccount extends BankAccount {
    private double creditBalance;
    private final double limit;
    private double overdraftInterest;

    // Constructor
    public CreditCardAccount(int accountId, double initial, double creditLimit) {
        super(accountId, initial);  // Call the constructor of BankAccount
        this.creditBalance = 0;     // Initialize the credit balance to 0
        this.limit = creditLimit;
    }

    // Method to pay from the credit account
    public boolean pay(double amount) {
        System.out.println("Pay from account " + accountId + "\nAmount:\t\t\t\t" + amount);

        // Check if the payment can be processed within the credit limit
        if (creditBalance - amount < -limit) {
            System.out.println("Sorry, insufficient balance...\n");
            return false;
        }

        // Process the payment
        creditBalance -= amount;
        System.out.println("New credit balance:\t" + creditBalance + "\n");
        return true;
    }

    // Method to compensate the credit balance
    public void compensate() {
        System.out.println("Compensate account " + accountId);
        balance += creditBalance;
        creditBalance = 0;

        // Print the new balances
        System.out.println("New balance:\t\t" + balance);
        System.out.println("New credit balance:\t" + creditBalance + "\n");
    }

    // Method to handle overdraft interest
    public void handleOverdraftInterest() {
        System.out.println("Handle overdraft interest for account " + accountId);

        // Check if the balance is negative
        if (balance < 0) {
            overdraftInterest = -balance * 0.05;
            System.out.println("Overdraft interest:\t" + overdraftInterest);

            // Deduct the overdraft interest from the balance
            balance -= overdraftInterest;
        }

        // Print the updated balance
        System.out.println("New balance:\t\t" + balance + "\n");
    }
}