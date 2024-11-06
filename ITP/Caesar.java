package de.tum.cit.ase;

public class Caesar {

    /**
     * Encrypts a String with the Caesar cipher by shifting the chars by a specified amount.
     * Only letters from 'a' to 'z' and 'A' to 'Z' will be encrypted. All other chars stay the same.
     * Positive numbers indicate a right shift. Negative numbers indicate a left shift.
     *
     * @param plainText The plain text
     * @param shift     The shift amount
     * @return The encrypted text
     */
    public String encrypt(String plainText, int shift) {
        // Normalize the shift within the range -25 to 25
        shift = (shift % 26 + 26) % 26;  // Ensures shift is always positive within 0-25 range

        StringBuilder encryptedText = new StringBuilder();

        for (char ch : plainText.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                // Shift uppercase letters
                char encryptedChar = (char) ((ch - 'A' + shift) % 26 + 'A');
                encryptedText.append(encryptedChar);
            } else if (ch >= 'a' && ch <= 'z') {
                // Shift lowercase letters
                char encryptedChar = (char) ((ch - 'a' + shift) % 26 + 'a');
                encryptedText.append(encryptedChar);
            }
            else {
                // Non-letter characters remain unchanged
                encryptedText.append(ch);
            }
        }
        return encryptedText.toString();
    }

    /**
     * Decrypts a String with the Caesar cipher by shifting the chars by a specified amount.
     * Only letters from 'a' to 'z' and 'A' to 'Z' will be decrypted. All other chars stay the same.
     *
     * @param encryptedText The encrypted text
     * @param shift         The shift amount
     * @return The plain text
     */
    public String decrypt(String encryptedText, int shift) {
        // Use the inverse shift for decryption
        shift = (shift % 26 + 26) % 26;  // Ensures shift is within 0-25 range
        return encrypt(encryptedText, -shift);
    }

    /**
     * Finds the Caesar shift between a plain and encrypted text.
     *
     * @param plainText     The plain text
     * @param encryptedText The encrypted text
     * @return The shift in range -25 to 25, or 0 if no valid shift is found
     */
    public int getShift(String plainText, String encryptedText) {
        if (plainText.length() != encryptedText.length()) return 0;

        Integer possibleShift = null;

        for (int i = 0; i < plainText.length(); i++) {
            char plainChar = plainText.charAt(i);
            char encryptedChar = encryptedText.charAt(i);

            if (Character.isLetter(plainChar) && Character.isLetter(encryptedChar)) {
                int calculatedShift = (encryptedChar - plainChar + 26) % 26;

                if (possibleShift == null) {
                    possibleShift = calculatedShift;
                } else if (possibleShift != calculatedShift) {
                    return 0;  // Inconsistent shift
                }
            } else if (plainChar != encryptedChar) {
                return 0;  // Non-letter mismatch
            }
        }

        // Convert shift to range -25 to 25
        if (possibleShift != null && possibleShift > 13) {
            possibleShift -= 26;
        }
        return (possibleShift != null) ? possibleShift : 0;
    }
}
