package sort;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		sorting a = new sorting();
		int[] b = {100 ,3 , 14, 1, 20, 300, 234, 6, 8, 2, 248, 649, 27};
		//int[] c = a.selectionSort(b);
		int[] d = a.mergesort(b);
		System.out.println(Arrays.toString(b));
	}

}
