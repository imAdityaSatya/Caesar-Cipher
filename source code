# Caesar Cipher 2.0
def encrypt(plain_text, key):
    encrypted_text = ""
    for char in plain_text:
        if char.isalpha():
            shift = ord(char) + key
            if char.islower():
                if shift > ord('z'):
                    shift -= 26
                encrypted_text += chr(shift)
            elif char.isupper():
                if shift > ord('Z'):
                    shift -= 26
                encrypted_text += chr(shift)
        else:
            encrypted_text += char
    return encrypted_text

def decrypt(encrypted_text, key):
    plain_text = ""
    for char in encrypted_text:
        if char.isalpha():
            shift = ord(char) - key
            if char.islower():
                if shift < ord('a'):
                    shift += 26
                plain_text += chr(shift)
            elif char.isupper():
                if shift < ord('A'):
                    shift += 26
                plain_text += chr(shift)
        else:
            plain_text += char
    return plain_text

def main():
    while True:
        plain_text = input("Enter the text to be encrypted/decrypted: ")
        if plain_text:
            break
        print("Text cannot be empty. Please enter some text.")

    while True:
        try:
            key = int(input("Enter the key (a number): "))
            break
        except ValueError:
            print("Key must be a number. Please enter a valid number.")

    while True:
        print("Enter:\t'e' to encrypt","\n\t'd' to decrypt")
        operation = input("Do you wanna encrypt or decrypt? ")
        if operation in ['e', 'd']:
            break
        print("Invalid operation! Please enter 'e' for encrypt or 'd' for decrypt.")

    if operation == 'e':
        encrypted_text = encrypt(plain_text, key)
        print("Encrypted text:", encrypted_text)
    elif operation == 'd':
        decrypted_text = decrypt(plain_text, key)
        print("Decrypted text:", decrypted_text)

if __name__ == "__main__":
    main()
