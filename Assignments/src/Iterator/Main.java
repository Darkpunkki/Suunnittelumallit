package Iterator;

public class Main {
    public static void main(String[] args) {
        FibonacciSequence sequence = new FibonacciSequence();
        FibonacciIterator iterator = sequence.iterator();

        // Print the first 10 Fibonacci numbers
        System.out.println("First 10 Fibonacci numbers:");
        for (int i = 0; i < 10 && iterator.hasNext(); i++) {
            System.out.print(iterator.next() + " ");
        }

        // Reset the iterator
        System.out.println("\n\nResetting the iterator...");
        iterator.reset();

        // Print Fibonacci numbers infinitely with delay
        System.out.println("Infinity Fibonacci numbers:");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
            try {
                Thread.sleep(500); // Slow down output
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted");
                break;
            }
        }
    }
}

