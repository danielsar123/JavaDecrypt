public class assignment1_1_danielSarkisian{
    private static final String SYMBOLS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890 !?,."; // list of symbols used for shift cipher

    public static String shiftDecrypt(String ciphertext, int key) {
        String plaintext = "";
        for (int i = 0; i < ciphertext.length(); i++) { //iterate through each character in cipher text
            char curLetter = ciphertext.charAt(i);  //get the letter at the current index
            if (SYMBOLS.indexOf(curLetter) != -1) {
                int symbolIndex = SYMBOLS.indexOf(curLetter);  //if the current letter exists in SYMBOLS, get the index of the current letter in SYMBOLS
                plaintext += SYMBOLS.charAt((symbolIndex - key + SYMBOLS.length()) % SYMBOLS.length()); // add the new letter corresponding to SYMBOLS using key.
                //add length of SYMBOLS to index-key to ensure the index always stays positive.
                // Use % the length of SYMBOLS to ensure there will always be a corresponding index in the SYMBOLS.
            } else {
                plaintext += curLetter; //if the current Letter is not in SYMBOLS, just add it itself without using key
            }
        }
        return plaintext;
    }

    public static void bruteForceAttack(String ciphertext) {
        for (int key = 0; key < SYMBOLS.length(); key++) { //iterate through each character in SYMBOLS
            String decryptedText = shiftDecrypt(ciphertext, key); //call decrypt method
            System.out.println("Key #" + key + ": " + decryptedText);
        }
    }

    public static void main(String[] args) {
        String ciphertext = "hpGsl7pG46nnp44q6ww0G5lvpyGnzy53zwGzqG5spGpypx0G4611w0GwtypKGcptyqz3npx\n" + //text to be decrypted
                "py54Gl3pGpyG3z65pG5zGz63G1z4t5tzyKGZ63G4nz654Gsl7pG3p1z35poGspl70Gpypx0\n" +
                "Gln5t7t50Gl5G5spGyz35sKGhpGyppoG5zGmpG13p1l3poGqz3GlyGl55lnvGl5Gol8yK";
        bruteForceAttack(ciphertext);
    }
}
