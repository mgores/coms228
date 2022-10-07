package cs228hw2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * This class is implements a stack and queue and uses the to make a post fix calculator
 * that will do specific calculations on a AmusingPericiseNumber
 * @author markgores
 *
 */
public class Deque228<E> implements Deque {
	/**
	 * The Deque is implemented with a linkedList called list
	 * All of the methods will confrom exactly to the javadocs for linked list
	 */
private LinkedList<E> list= new LinkedList<>();

@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return list.isEmpty();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return list.toArray();
	}

	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return list.toArray(a);
	}

	@Override
	public boolean containsAll(Collection c) {
		// TODO Auto-generated method stub
		return list.containsAll(c);
	}

	@Override
	public boolean addAll(Collection c) {
		// TODO Auto-generated method stub
		return list.addAll(c);
	}

	@Override
	public boolean removeAll(Collection c) {
		// TODO Auto-generated method stub
		return list.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection c) {
		// TODO Auto-generated method stub
		return list.retainAll(c);
	}

	@Override
	public void clear() {
		list.clear();// TODO Auto-generated method stub
		
	}

	@Override
	public void addFirst(Object e) {
		// TODO Auto-generated method stub
		list.addFirst((E) e);
	}

	@Override
	public void addLast(Object e) {
		// TODO Auto-generated method stub
		list.addLast((E) e);
	}

	@Override
	public boolean offerFirst(Object e) {
		// TODO Auto-generated method stub
		return list.offerFirst((E) e);
	}

	@Override
	public boolean offerLast(Object e) {
		// TODO Auto-generated method stub
		return list.offerLast((E) e);
	}

	@Override
	public Object removeFirst() {
		// TODO Auto-generated method stub
		return list.removeFirst();
	}

	@Override
	public Object removeLast() {
		// TODO Auto-generated method stub
		return list.removeLast();
	}

	@Override
	public Object pollFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object pollLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object peekFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object peekLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeLastOccurrence(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return list.add((E) e);
	}

	@Override
	public boolean offer(Object e) {
		// TODO Auto-generated method stub
		return list.offer((E) e);
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return list.remove();
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		return list.poll();
	}

	@Override
	public Object element() {
		// TODO Auto-generated method stub
		return list.element();
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return list.peek();
	}

	@Override
	public void push(Object e) {
		// TODO Auto-generated method stub
		list.push((E) e);
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		return list.pop();
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return list.remove(o);
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return list.contains(o);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return list.iterator();
	}

	@Override
	public Iterator descendingIterator() {
		// TODO Auto-generated method stub
		return list.descendingIterator();
	}
	/**
	 * implements the calculator
	 * @param args
	 */
	public static void main(String[] args) {
		Deque228<AmusingPreciseNumber> stack = new Deque228<AmusingPreciseNumber>();
		Scanner in = new Scanner(System.in);
		String a=in.nextLine();
		String b= "";
		int i=0;
		char c=a.charAt(i);
		while(i<a.length()) {
		while(!(c==' ')&&i<a.length()-1) {
			b=b+c;
			i++;
			c=a.charAt(i);
		}
		if(i==a.length()-1) {
			b=b+c;
		}
		
		if(b.charAt(0)=='+'||b.charAt(0)=='-'||b.matches("abs")||b.matches("neg"))
		{
			if(b.charAt(0)=='+') {
				AmusingPreciseNumber temp = (AmusingPreciseNumber) stack.pop();
				temp.add((AmusingPreciseNumber) stack.pop());
				stack.push(temp);
			}
			if(b.charAt(0)=='-') {
				AmusingPreciseNumber temp = (AmusingPreciseNumber) stack.pop();
				temp.subtract((AmusingPreciseNumber) stack.pop());
				stack.push(temp);
			}
			if(b.matches("abs")) {
				AmusingPreciseNumber temp = (AmusingPreciseNumber) stack.pop();
				temp.abs();
				stack.push(temp);
			}
			if(b.matches("neg")) {
				AmusingPreciseNumber temp = (AmusingPreciseNumber) stack.pop();
				temp.negate();
				stack.push(temp);
			}
		}
		else {
		AmusingPreciseNumber num = new AmusingPreciseNumber(b);
		stack.push(num);
		}
		b = "";
		i++;
		if(i<=a.length()-1) {
		c=a.charAt(i);
		}
		}
		System.out.println(stack.pop().toString());
	}
	

}
