package de.tum.cit.ase;

public class SavingsAccount extends BankAccount {
    protected final double interestRate;

    public SavingsAccount(int accountId, double initial, double rate) {
        super(accountId, initial);
        interestRate = rate;
    }

    public void addInterest() {
        balance = balance * (1 + interestRate);
        System.out.println("Interest added to account: " + accountId
                + "\nNew balance:\t" + balance + "\n");
    }
}
