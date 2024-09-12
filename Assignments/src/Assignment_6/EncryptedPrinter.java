package Assignment_6;

public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        super.print(encryptedMessage);
    }

    // Encryption using a Caesar cipher with a shift of 3
    private String encrypt(String message) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : message.toCharArray()) {
            encrypted.append((char) (c + 3));
        }
        return encrypted.toString();
    }

    // Decryption reverses the encryption (shift of 3)
    public String decrypt(String encryptedMessage) {
        StringBuilder decrypted = new StringBuilder();
        for (char c : encryptedMessage.toCharArray()) {
            decrypted.append((char) (c - 3));
        }
        return decrypted.toString();
    }
}
