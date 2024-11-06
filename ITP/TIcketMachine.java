package de.tum.cit.ase;
import java.math.BigInteger;

public class TIcketMachine {
    private static final int PRICE = 10; // Price per ticket
    private static int ticketsSoldCount = 0; // Count of tickets sold

    // Processes payment and increments ticket count if valid
    public static boolean processPaymentMethod(BigInteger accountNumber) {
        BigInteger iban = IBANValidator.generateIBAN(accountNumber);

        // Check if IBAN is blacklisted
        if (ibanIsBlacklisted(iban)) {
            return false;
        }

        // Validate IBAN and increment ticket count if valid
        if (IBANValidator.validateIBAN(iban)) {
            ticketsSoldCount++;
            return true;
        }
        return false;
    }

    // Checks if a given IBAN is blacklisted
    public static boolean ibanIsBlacklisted(BigInteger iban) {
        BigInteger blacklistedIBAN = new BigInteger("27100777770209299700");
        return iban.equals(blacklistedIBAN);
    }

    // Calculates and returns the total revenue
    public static int getTotalRevenue() {
        return ticketsSoldCount * PRICE;
    }
}

