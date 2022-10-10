package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class sorting {
    public sorting() {

    }
    public int[] selectionSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < len; j++)
                if (a[j] < a[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = a[min_idx];
            System.out.println("swapping: " + temp + " with: " + a[i]);
            a[min_idx] = a[i];
            a[i] = temp;
            System.out.println("new array: " + Arrays.toString(a));
        }


        return a;
    }
    public int[] insertionsort(int[] a){
        int size = a.length;
        for (int i = 1; i < size; ++i) {
            int key = a[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && a[j] > key) {
                System.out.println("switching: "+ a[j] +" with: " +a[j+1]);
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
            System.out.println("new array: " + Arrays.toString(a));
        }
        return a;
    }
    public int[] mergesort(int a[]){
        mergs(a, a.length);

        return a;
    }
    private void mergs(int a[], int n){
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        System.out.println("mid: "+ mid);
        int[] l = new int[mid];

        int[] r = new int[n - mid];


        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        System.out.println("left arr: " + Arrays.toString(l));
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        System.out.println("right arr: " + Arrays.toString(r));
        mergs(l, mid);
        mergs(r, n - mid);

        merge(a, l, r, mid, n - mid);

    }
    private static void merge(int[] a, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        System.out.println("merging: "+ Arrays.toString(l) + " with: " + Arrays.toString(r));
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
        System.out.println("current array: "+ Arrays.toString(a));
    }
    public int[] quicksort(int[] a){
        quicks(a, 0, a.length -1);
        return a;

    }
    private void quicks(int[] a, int low, int high){
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(a, low, high);

            // Separately sort elements before
            // partition and after partition
            quicks(a, low, pi - 1);
            quicks(a, pi + 1, high);
        }
    }
    private static int partition(int[] a, int low, int high)
    {

        // pivot
        int pivot = a[high];

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller
            // than the pivot
            if (a[j] < pivot) {

                // Increment index of
                // smaller element
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, high);
        return (i + 1);
    }
    private static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

}