package Iterator;

import java.util.Iterator;

// Ylläpitää tilaa (nykyinen ja edellinen luku) ja generoi seuraavan fibonacci numeron
public class FibonacciIterator implements Iterator<Integer> {
    private int prev1;
    private int prev2;
    private final FibonacciSequence sequence;
    private int currentIndex;
    private final int maxElements;

    public FibonacciIterator(FibonacciSequence sequence) {
        this(sequence, Integer.MAX_VALUE);
    }

    public FibonacciIterator(FibonacciSequence sequence, int maxElements) {
        this.sequence = sequence;
        this.maxElements = maxElements;
        this.prev1 = 1;
        this.prev2 = 1;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < maxElements;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more elements in the Fibonacci sequence.");
        }

        int nextFibonacci;
        if (currentIndex < 2) {
            nextFibonacci = 1;
        } else {
            nextFibonacci = sequence.generateNextFibonacci(prev1, prev2);
            prev1 = prev2;
            prev2 = nextFibonacci;
        }

        currentIndex++;
        return nextFibonacci;
    }

    public void reset() {
        this.prev1 = 0; // Reset to the first number
        this.prev2 = 1; // Reset to the second number
        this.currentIndex = 0; // Reset the index
    }

}
