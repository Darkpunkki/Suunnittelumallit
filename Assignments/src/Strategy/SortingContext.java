package Strategy;

import java.util.Random;

public class SortingContext {

    private SortingStrategy strategy;

    // Set the sorting strategy
    public void setStrategy(SortingStrategy strategy) {
        this.strategy = strategy;
    }

    // Sort array with current strategy
    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }

    public static void main(String[] args) {
        SortingContext context = new SortingContext();

        // Generate data sets
        int[] smallArray = generateRandomArray(30);
        int[] largeArray = generateRandomArray(50000);

        // Test BubbleSort strategy on small array
        context.setStrategy(new BubbleStrategy());
        System.out.println("Testing BubbleSort on small array");
        long startTime = System.nanoTime();
        context.executeStrategy(smallArray);
        System.out.println("Sorted array: " + java.util.Arrays.toString(smallArray));
        long endTime = System.nanoTime();
        System.out.println("BubbleSort took: " + (endTime - startTime) / 1e6 + " ms on small array");
        System.out.println(" ");

        // Test BubbleSort strategy on large array
        context.setStrategy(new BubbleStrategy());
        System.out.println("Testing BubbleSort on large array");
        startTime = System.nanoTime();
        context.executeStrategy(largeArray);
        endTime = System.nanoTime();
        System.out.println("BubbleSort took: " + (endTime - startTime) / 1e6 + " ms on large array");
        System.out.println(" ");

        // Test QuickSort strategy on small array
        context.setStrategy(new QuickSortStrategy());
        System.out.println("Testing QuickSort on small array");
        startTime = System.nanoTime();
        context.executeStrategy(smallArray);
        System.out.println("Sorted array: " + java.util.Arrays.toString(smallArray));
        endTime = System.nanoTime();
        System.out.println("QuickSort took: " + (endTime - startTime) / 1e6 + " ms on small array");
        System.out.println(" ");

        /*
        // Test QuickSort strategy on large array
        context.setStrategy(new QuickSortStrategy());
        System.out.println("Testing QuickSort on large array");
        startTime = System.nanoTime();
        context.executeStrategy(largeArray);
        endTime = System.nanoTime();
        System.out.println("QuickSort took: " + (endTime - startTime) / 1e6 + " ms on large array");
        System.out.println(" ");
        */

        // Test CocktailSort strategy on small array
        context.setStrategy(new CocktailSortStrategy());
        System.out.println("Testing CocktailSort on small array");
        startTime = System.nanoTime();
        context.executeStrategy(smallArray);
        System.out.println("Sorted array: " + java.util.Arrays.toString(smallArray));
        endTime = System.nanoTime();
        System.out.println("CocktailSort took: " + (endTime - startTime) / 1e6 + " ms on small array");
        System.out.println(" ");

        // Test CocktailSort strategy on large array
        context.setStrategy(new CocktailSortStrategy());
        System.out.println("Testing CocktailSort on large array");
        startTime = System.nanoTime();
        context.executeStrategy(largeArray);
        endTime = System.nanoTime();
        System.out.println("CocktailSort took: " + (endTime - startTime) / 1e6 + " ms on large array");
        System.out.println(" ");

    }

    // Method to generate an array of random integers
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        return array;
    }
}
