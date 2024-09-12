package Assignment_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        Printer printer2 = new EncryptedPrinter(new FilePrinter(new BasicPrinter()));
        printer2.print("Hello World!");

        // Decrypt and print the content from the file
        decryptFileContent();
    }

    private static void decryptFileContent() {
        try (BufferedReader reader = new BufferedReader(new FileReader("output.txt"))) {
            String line;
            EncryptedPrinter encryptedPrinter = new EncryptedPrinter(new BasicPrinter());

            System.out.println("\nDecrypted messages from file:");
            while ((line = reader.readLine()) != null) {
                String decryptedMessage = encryptedPrinter.decrypt(line);
                System.out.println(decryptedMessage); // Output decrypted message to the console
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
