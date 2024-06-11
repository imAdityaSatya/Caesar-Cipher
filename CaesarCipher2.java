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
        return encrypt(encryptedText, (26-key));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text;
        int key;
        String operation;

        // Prompting the user for input of plain text
        while (true) {
            System.out.print("Enter the Plain Text (to be encrypted/decrypted): ");
            text = sc.nextLine().trim();
            if (!text.isEmpty()) {
                break;
            }
            System.out.println("Text cannot be empty. Please enter some text.");
        }

        // Asking user for the key (number of shifta)
        while(true) {
            System.out.print("Enter the key (a number): ");
            try {
                key = Integer.parseInt(sc.nextLine().trim());
                break;
            } 
            catch(NumberFormatException e) {
                System.out.println("Key must be a number. Please enter a valid number.");
            }
        }

        // Asking the user for choice of operation e/d
        while(true) {
            System.out.println("Enter:\t'e' to encrypt\n\t'd' to decrypt");
            System.out.print("Do you want to encrypt or decrypt? ");
            operation = sc.nextLine().trim();
            if (operation.equals("e") || operation.equals("d")) {
                break;
            }
            System.out.println("Invalid operation! Please enter 'e' for encrypt or 'd' for decrypt.");
        }

        // Performing the operation
        if(operation.equals("e")) {
            String encryptedText = encrypt(text, key);
            System.out.println("Encrypted text: " + encryptedText);
        } else {
            String decryptedText = decrypt(text, key);
            System.out.println("Decrypted text: " + decryptedText);
        }
        sc.close();
    }
}
