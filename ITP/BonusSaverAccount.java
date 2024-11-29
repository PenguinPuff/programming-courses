package de.tum.cit.ase;

public class BonusSaverAccount extends SavingsAccount {
    private final int penalty;
    private final double bonus;

    public BonusSaverAccount(int accountId, double initial, double rate) {
        super(accountId, initial, rate);
        penalty = 25;
        bonus = 0.03;
    }

    @Override
    public boolean withdraw(double amount) {
        System.out.println("Penalty incurred:\t" + penalty);
        return super.withdraw(amount + penalty);
    }

    @Override
    public void addInterest() {
        balance = balance * (1 + interestRate + bonus);
        System.out.println("Interest added to account: "
                + accountId + "\nNew balance:\t" + balance + "\n");

    }
}
