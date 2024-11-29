package de.tum.cit.ase;

public class CheckingAccount extends BankAccount {
    private final SavingsAccount overdraft;

    public CheckingAccount(int accountId, double initial, SavingsAccount savings) {
        super(accountId, initial);
        overdraft = savings;
    }

    @Override
    public boolean withdraw(double amount) {
        if (!super.withdraw(amount)) {
            System.out.println("Using overdraft...");
            if (!overdraft.withdraw(amount - balance)) {
                System.out.println("Overdraft source insufficient.\n");
                return false;
            } else {
                balance = 0;
                System.out.println("New balance on account " + accountId + ": 0\n");
            }
        }
        return true;
    }
}
