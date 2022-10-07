package cs228hw2;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;

public class test {
	 
	public static void main(String[] args) {
		
		
AmusingLinkedList<Integer> a = new AmusingLinkedList<Integer>();
AmusingLinkedList<Integer> b = new AmusingLinkedList<Integer>();
		String expected = "0 6 1 0\n"
						+ "1 -1 2 1\n"
						+ "2 0 3 2\n"
						+ "3 -1 4 3\n"
						+ "4 2 5 4\n"
						+ "5 -1 6 5\n"
						+ "6 4 7 6\n"
						+ "7 -1 0 null";
			
		a.add(0);
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(null);
		
		System.out.println(a);
		//System.out.println();
		
		
		assertEquals(expected, a.toString());
		
		expected = 		"0 8 1 0\n"
						+ "1 -1 2 1\n"
						+ "2 0 3 2\n"
						+ "3 -1 4 3\n"
						+ "4 2 5 4\n"
						+ "5 -1 6 5\n"
						+ "6 4 7 6\n"
						+ "7 -1 8 null\n"
						+ "8 6 0 null";
						

		//a.add(null);
		//assertThrows(NoSuchElementException.class, () -> {i.next();});
		
	}
		
       
	}


