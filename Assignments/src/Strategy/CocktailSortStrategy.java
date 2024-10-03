package Strategy;

class CocktailSortStrategy implements SortingStrategy {

    @Override
    public void sort(int[] a) {
        boolean swapped = true;
        int start = 0;
        int end = a.length;

        while (swapped) {
            swapped = false;

            // Loop from bottom to top (left to right)
            for (int i = start; i < end - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }

            // If no elements were swapped, the array is sorted
            if (!swapped)
                break;

            swapped = false;

            // Move the end point back by one
            end--;

            // Loop from top to bottom (right to left)
            for (int i = end - 1; i >= start; i--) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    swapped = true;
                }
            }

            // Move the starting point forward
            start++;
        }
    }
}
