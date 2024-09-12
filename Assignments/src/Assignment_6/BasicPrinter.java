package Assignment_6;

public class BasicPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println("Printing to console: " + message);
    }
}
