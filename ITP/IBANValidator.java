package de.tum.cit.ase;
import java.math.BigInteger;

public class IBANValidator {
    // Checks if the IBAN has 20 digits and is non-negative
    public static boolean checkLengthAndSignWhenValidating(BigInteger iban) {
        String ibanStr = iban.toString();
        return ibanStr.length() == 20 && iban.compareTo(BigInteger.ZERO) >= 0;
    }

    // Validates the IBAN using the checksum test
    public static boolean validateIBAN(BigInteger iban) {
        if (!checkLengthAndSignWhenValidating(iban)) {
            return false;
        }

        // Rearrange: Move last 18 digits, then "DE" and checksum to the end
        String ibanStr = iban.toString();
        String rearrangedIBAN = ibanStr.substring(2) + "1314" + ibanStr.substring(0, 2);

        // Convert to BigInteger and check mod 97
        BigInteger transformedIBAN = new BigInteger(rearrangedIBAN);
        return transformedIBAN.mod(BigInteger.valueOf(97)).equals(BigInteger.ONE);
    }

    // Generates a German IBAN with the correct checksum
    public static BigInteger generateIBAN(BigInteger accountNumber) {
        // Append "DE00" as a placeholder checksum for calculation
        String accountStr = accountNumber.toString();

        // Pad account number to ensure it's exactly 18 digits
        if (accountStr.length() > 18) {
            throw new IllegalArgumentException("Account number exceeds 18 digits");
        }
        accountStr = String.format("%018d", accountNumber);

        // Start with placeholder IBAN using checksum "00"
        String placeholderIBAN = accountStr + "131400"; // 'DE' -> 1314 and checksum as '00'

        // Convert placeholder IBAN to numeric-only and calculate checksum
        BigInteger transformedIBAN = new BigInteger(placeholderIBAN);
        int checksum = 98 - transformedIBAN.mod(BigInteger.valueOf(97)).intValue();

        // Format checksum as two digits
        String formattedChecksum = String.format("%02d", checksum);

        // Build the final numeric-only IBAN without "DE" prefix
        return new BigInteger(formattedChecksum + accountStr);
    }
}
