package Iterator;

// tarjoaa logiikan fibonacci numeroiden generoimiseen, mutta ei ylläpidä tilaa
public class FibonacciSequence implements Sequence {

    @Override
    public FibonacciIterator iterator() {
        return new FibonacciIterator(this);
    }

    public int generateNextFibonacci(int prev1, int prev2) {
        return prev1 + prev2;
    }
}
