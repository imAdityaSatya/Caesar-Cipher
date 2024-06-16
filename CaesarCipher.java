import java.util.*;

class CaesarCipher {
    public static String encrypt(String plainText, int key) {
        String encryptedText = "";
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            if (Character.isAlphabetic(c)) {
                int shift = c + key;
                if (Character.isLowerCase(c)) {
                    if (shift > 'z') {
                        shift -= 26;
                    }
                    encryptedText += (char) shift;
                } else if (Character.isUpperCase(c)) {
                    if (shift > 'Z') {
                        shift -= 26;
                    }
                    encryptedText += (char) shift;
                }
            } else {
                encryptedText += c;
            }
        }
        return encryptedText;
    }

    public static String decrypt(String encryptedText, int key) {
        String plainText = "";
        for (int i = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            if (Character.isAlphabetic(c)) {
                int shift = c - key;
                if (Character.isLowerCase(c)) {
                    if (shift < 'a') {
                        shift += 26;
                    }
                    plainText += (char) shift;
                } else if (Character.isUpperCase(c)) {
                    if (shift < 'A') {
                        shift += 26;
                    }
                    plainText += (char) shift;
                }
            } else {
                plainText += c;
            }
        }
        return plainText;
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        String plainText;
        int key;
        String operation;

        while (true) {
            System.out.print("Enter the text to be encrypted/decrypted: ");
            plainText = sc.nextLine();
            if (!plainText.isEmpty()) {
                break;
            }
            System.out.println("Text cannot be empty. Please enter some text.");
        }

        while (true) {
            System.out.print("Enter the key (a number): ");
            try {
                key = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Key must be a number. Please enter a valid number.");
            }
        }

        while (true) {
            System.out.println("Enter:\t'e' to encrypt\n\t'd' to decrypt");
            System.out.print("Do you wanna encrypt or decrypt? ");
            operation = sc.nextLine();
            if (operation.equals("e") || operation.equals("d")) {
                break;
            }
            System.out.println("Invalid operation! Please enter 'e' for encrypt or 'd' for decrypt.");
        }

        if (operation.equals("e")) {
            String encryptedText = encrypt(plainText, key);
            System.out.println("Encrypted text: " + encryptedText);
        } else if (operation.equals("d")) {
            String decryptedText = decrypt(plainText, key);
            System.out.println("Decrypted text: " + decryptedText);
        }
        sc.close();
    }
}
