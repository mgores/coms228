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
	
}
