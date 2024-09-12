package Assignment_6;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrinter extends PrinterDecorator {

    public FilePrinter(Printer decoratedPrinter) {
        super(decoratedPrinter);
    }

    @Override
    public void print(String message) {
        try (FileWriter writer = new FileWriter("output.txt", true)) {
            writer.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
