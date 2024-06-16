import java.util.Scanner;

public class CaesarCipher2 {

    /**
     * Encrypts the given plain text using the Caesar Cipher as per the given key.
     * @param plainText The plain text to be encrypted.
     * @param key The encryption key.
     * @return The encrypted text.
     */
    public static String encrypt(String plainText, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i=0; i < plainText.length(); i++) {
            char ch = plainText.charAt(i);
            if(Character.isAlphabetic(ch)) {
                char base = Character.isLowerCase(ch) ? 'a' : 'A';
                ch = (char) ((ch - base + key) % 26 + base);
            }
            encryptedText.append(ch);
        }
        return encryptedText.toString();
    }

    /**
     * Decrypts the given encrypted text using the Caesar Cipher as per the given key.
     * @param encryptedText The encrypted text to be decrypted.
     * @param key The decryption key.
     * @return The decrypted text.
     */
    public static String decrypt(String encryptedText, int key) {
        System.out.println("\nDecryption Completed...!\n");
        return encrypt(encryptedText, (26-key));    // Code-Reusability by utilizing encrypt function
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text;
        int key;
        String operation;

        String jargon = "Plain Text : the text to be encrypted or decrypted\n"+
                        "Key : the num of shifts chosen for encryption or decryption\n"+
                        "Cipher Text : the text after encryption or decryption performed\n";

        System.out.println("\nWelcome to CaesarCipher\n\n"+jargon);

        // Prompting the user for input of plain text
        while (true) {
            System.out.print("Enter the Plain Text: ");     
            text = sc.nextLine().trim();
            if (!text.isEmpty()) {
                break;
            }
            System.out.println("Text cannot be empty. Please enter some text.");
        }

        // Asking user for the key (number of shifts)
        while(true) {
            System.out.print("Enter the Key: ");
            try {
                key = Integer.parseInt(sc.nextLine().trim());
                break;
            } 
            catch(NumberFormatException e) {
                System.out.println("Please enter a valid key. \nThe key must be a number.");
            }
        }

        // Asking the user for choice of operation e/d
        while(true) {
            System.out.println("\nEnter :\t'e' to encrypt\n\t'd' to decrypt");
            System.out.print("Do you wanna encrypt or decrypt? ");
            operation = sc.nextLine().trim();
            if (operation.equals("e") || operation.equals("d")) {
                break;
            }
            System.out.println("Invalid operation! Please enter 'e' for encrypt or 'd' for decrypt.");
        }

        // Performing the operation as chosen
        if(operation.equals("e")) {
            String encryptedText = encrypt(text, key);
            System.out.println("\nEncryption Completed...!\n");
            System.out.println("Cipher Text: " + encryptedText +"\n");
        } else {
            String decryptedText = decrypt(text, key);
            System.out.println("Cipher Text: " + decryptedText +"\n");
        }
        sc.close();
    }

}
