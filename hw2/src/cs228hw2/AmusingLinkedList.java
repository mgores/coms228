package cs228hw2;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.naming.OperationNotSupportedException;

import java.io.IOException;
import java.lang.RuntimeException.*;
import java.io.IOException;

/**
 * linked list where the prev node is only in effect on even indexes and 
 * points to the prev even index, index 0's prev points at the last even, 
 * and the last elements next points at the first element in the list creating a loop
 * 
 * @author markgores
 *
 * @param <E>
 */
public class AmusingLinkedList<E> implements List<E> {
	IndexOutOfBoundsException e;
	UnsupportedOperationException a;
	int lindex =0;
	private Node<E> head=new Node<>(null);
	/**
	 * Creates a node that stores data and a next and prev pointer
	 * @author markgores
	 *
	 * @param <T>
	 */
	public class Node<T>{
		private T data;
		private Node<T> next;
		private Node<T> prev;
		
		 Node(T item) {
			data = item;	
		}
		 /**
		  * 
		  * @return
		  * returns the data of this node
		  */
		private T getData() {
			return data;	
		}
		/**
		 * 
		 * @return
		 * returns the next node 
		 */
		private Node<T> getNext() {
			return next;
		}
		/**
		 * 
		 * @return
		 * returns the prev node
		 */
		private Node<T> getPrev() {
			return prev;
		}
	}

private int size;
/**
 * basic constructor for the list
 */
public AmusingLinkedList() {
	head = null;
	size = 0;
	
}

/**
 * creates an iterator that will walk through the list
 * optional methods are not supported
 * @author markgores
 *
 * @param <E>
 */
public class AmusingListIterator<E> implements ListIterator <E>{
  AmusingLinkedList<E>.Node<E> current;
  UnsupportedOperationException a;
  int index= 0;
	public AmusingListIterator(AmusingLinkedList<E> list){
	 current = list.getHead();
	 	
}
	public AmusingListIterator(AmusingLinkedList<E> list, int index){
		 current = list.getHead();
		 lindex=index;	
	}
	@Override
	public boolean hasNext() {
		if(current.next!=null&& lindex<size) {
			return true;
		}
			
		return false;
	}

	@Override
	public E next() {
		if(lindex==0) {
			lindex++;
			return current.getData();
		}
		else {
		lindex++;
		current=current.next;
		return current.getData();
		}
		
	}

	@Override
	public boolean hasPrevious() {
		if(current!=head) {
			return true;
		}
		return false;
	}

	@Override
	public E previous() {
		if(hasPrevious()) {
		if(lindex%2==0) {
			current=current.prev.next;
			lindex--;
			return current.getData();
		}
		else {
			current=current.next.prev;
			lindex--;
			return current.getData();
		}
		}
		return null;
	}

	@Override
	public int nextIndex() {
		if(lindex==size) {
			return size;
		}
		int newindex=lindex+1;
		return newindex;
	}

	@Override
	public int previousIndex() {
		if(lindex==0) {
			return -1;
		}
		int newindex=lindex-1;
		return newindex;
	}

	@Override
	public void set(E e) {
		throw a;// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		throw a;
		
	}

	@Override
	public void add(E e) {
		throw a;// TODO Auto-generated method stub
		
	}
	

}
/**
 * 
 * @return
 * returns the head of the list
 */
	public Node<E> getHead() 
	{ 
	    return head; 
	} 
/**
 * returns the size of the list
 */
	@Override
	public int size() {
		return size;
	}
/**
 * returns true if the list is empty
 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head == null;
	}
/**
 * returns true if the object is contained in the list
 */
	@Override
	public boolean contains(Object o) {
		Node<E> a = head;
		for(int i=0; i<size;i++) {
			if(o==a.getData()) {
				return true;
			}
			a=a.next;
		}
		return false;
	}
/**
 * returns an iterator for this list
 */
	@Override
	public Iterator<E> iterator() {
		
		return new AmusingListIterator<E>(this);
	}
/**
 * converts this list to an array
 * and returns it to an array
 */
	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];
		Node<E> temp = head;
		for(int i=0;i<size;i++) {
			arr[i]=temp.getData();
			temp=temp.next;
		}
		return arr;
	}
/**
 * Returns an array containing all of the elements in this list in proper sequence (from first to last element); the runtime type of the returned array is that of the specified array.
 */
	@Override
	public <T> T[] toArray(T[] a) {
		 Node<E> temp = head;
			for(int i=0;i<size;i++) {
				a[i]=(T) temp.getData();
				temp=temp.next;
			}
		return a;
	}
/**
 * Appends the specified element to the end of this list 
 * returns true if element was added
 */
	@Override
	public boolean add(E e) {
		Node<E> newnode= new Node<>(e);
		Node<E> temp = head;
		if(size==0) {
		head=newnode;
		newnode.next=newnode;
		newnode.prev=newnode;
		size++;
		return true;
		}
		if(size>0) {
			if(size%2==1) {
				newnode.next=temp;
				temp.prev.next=newnode;
				size++;
				unlink();
				link();
				
			}
			else if(size%2==0) {
				newnode.next=temp;
				if(size==2) {
					temp.prev.next.next=newnode;
				}
				else {
				temp.prev.next.next=newnode;
				}
				size++;
				unlink();
				link();
				
			}
				
			return true;
		}
		
		return false;
	}
/**
 * Returns true if this list contains all of the elements of the specified collection.
 * 
 */
	@Override
	public boolean containsAll(Collection c) {
		Node<E> temp=head;
		for(int i=0;i<size;i++) {
			for(Object a:c) {
			if(a!=temp.getData()) {
				return false;
			}	
		}
			temp=temp.next;
		}
		return true;
	}
/**
 * Appends all of the elements in the specified collection to the end of this list, in the order that they are returned by the specified collection's iterator
 * returns true if correctly added
 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		if(head!=null) {
		for(E a:c) {
			add(a);
		}
		return true;
		}
		return false;
	}
/**
 * Inserts all of the elements in the specified collection into this list at the specified position (optional operation). Shifts the element currently at that position (if any) and any subsequent elements to the right (increases their indices). T
 * returns true if added
 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		int i=index;
		for(E a:c) {
			add(i,a);
			i++;
			return true;
		}
		return false;
	}
/**
 * Removes from this list all of its elements that are contained in the specified collection
 * returns true if removed
 */
	@Override
	public boolean removeAll(Collection<?> c) {
		for(Object a:c) {
			if(contains(a)) {
				remove(a);
			}
			return true;
		}
		return false;
	}
/**
 * Retains only the elements in this list that are contained in the specified collection
 * returns true if changed 
 */
	@Override
	public boolean retainAll(Collection<?> c) {
	Node<E> temp=head;
	for(Object a:c) {
		for(int i =0;i<size;i++) {
			if(temp.getData()!=a) {
				remove(temp);
			}
			temp=temp.next;
		}
		return true;
	}
		return false;
	}
/**
 * emptys the given list
 */
	@Override
	public void clear() {
		head=null;
		size=0;

		
	}
/**
 * Returns the element at the specified position in this list
 */
	@Override
	public E get(int index) {
		Node <E> temp = head;
		for(int i=0;i<index;i++) {
		temp=temp.next;
		}
		return temp.getData();
	}
/**
 * Replaces the element at the specified position in this list with the specified element
 */
	@Override
	public E set(int index, E element) {
		Node<E> temp = head;
		if(index<0|index>=size) {
			throw e;
		}
		for(int i=0;i<index;i++) {
			temp=temp.next;
		}
		E a =temp.data;
		temp.data=element;
		return a;
	}
/**
 * Inserts the specified element at the specified position in this list
 * 
 */
	@Override
	public void add(int index, Object element)throws IndexOutOfBoundsException {
		Node<E> temp = head;
		Node<E> newnode= new Node(element);
		if(index<0|index>size) {
			throw e;
		}
		for(int i = 0; i<index+1;i++) {
			temp=temp.next;
		}
		if(index==0) {
			newnode.next=temp;
			temp=newnode;
			if(size%2==1) {
			newnode.next.prev.next=newnode;	
			}
			else {
				newnode.next.prev.next.next=newnode;
			}
			size++;
			unlink();
			link();
		}
		else {
		newnode.next=temp.next;
		temp.next=newnode;
		
		size++;
		unlink();
		link();
		}
		
	}
/**
 * Removes the element at the specified position in this list 
 * returns the element at that index
 */
	@Override
	public E remove(int index) {
		if(isEmpty()) {
			return null;
		}
		Node<E> data = head;
		Node<E> temp= head;
		for(int i=0;i<index-1;i++) {
			temp=temp.next;
			data = data.next;
		}
		E val = data.next.getData();
		if(index==0) {
			head=temp.next;
			
		}
		
		temp.next=temp.next.next;
		temp=temp.next;
		size--;
		unlink();
		link();
		return val;
	}
/**
 * Returns the index of the first occurrence of the specified element in this list, or -1 if this list does not contain the element. More formally, returns the lowest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
 */
	@Override
	public int indexOf(Object o) {
		Node<E> temp=head;
		int index=0;
		int index1=-1;
		for(int i=0;i<size;i++) {
			if(temp.getData()==o) {
				return index; 
			}
			temp=temp.next;
			index++;
			
		}
		return index1;
	}
/**
 * Returns the index of the last occurrence of the specified element in this list, or -1 if this list does not contain the element. More formally, returns the highest index i such that (o==null ? get(i)==null : o.equals(get(i))), or -1 if there is no such index.
 * 
 */
	@Override
	public int lastIndexOf(Object o) {
		Node<E> temp=head;
		int index=0;
		int index1=-1;
		for(int i=0;i<size;i++) {
			if(temp.getData()==o) {
				index1=index; 
			}
			temp=temp.next;
			index++;
			
		}
		return index1;
	}
/**
 * Returns a list iterator over the elements in this list (in proper sequence).
 */
	@Override
	public ListIterator<E> listIterator() {
		 AmusingListIterator a= new AmusingListIterator(this);
		return a;
	}
/**
 * Returns a list iterator over the elements in this list (in proper sequence), starting at the specified position in the list. The specified index indicates the first element that would be returned by an initial call to next. An initial call to previous would return the element with the specified index minus one.
 */
	@Override
	public ListIterator listIterator(int index) {
		AmusingListIterator a= new AmusingListIterator(this,index);
		return a;
	}
/**
 * operation not supported
 */
	@Override
	public List subList(int fromIndex, int toIndex) {
		throw a;
	}
/**
 * Removes the first occurrence of the specified element from this list, if it is present 
 */
	@Override
	public boolean remove(Object o) {
		if(indexOf(o)!=-1) {
	int a = indexOf(o);
			remove(a);
			return true;
		}
		return false;
	}
	/**
	 * unlinks all the prev nodes and sets them to null
	 */
	private void unlink() {
		Node<E> a = head;
		for(int i=0;i<size;i++) {
			a.prev=null;
			a=a.next;
		}
		
		/**
		 * relinks all the prev nodes to the correct locations
		 */
	}
	private void link() {
		Node<E> a = head;
		Node<E> index0=a;
		Node<E> lasteven=head;
		int index = 0;
		for(int i=0;i<size;i++) {
			
			if(index%2==0) {
			a.prev=lasteven;
			index0.prev = a;
			lasteven=a;
		}
			index++;
			a=a.next;
		}
	}
	/**
	 * retunrs node at give index
	 * @param index
	 * @return
	 * node
	 */
public Node<E> getNodeAtIndex(int index) {
	Node<E> temp = head;
	for(int i=0;i<index;i++) {
		temp=temp.next;
	}
	return temp;
}
/**
 * Returns a string representation of the class.
 * lists the index of current node, prev node, current node, and data of node or negative 1 if null
 */
public String toString() {
Node<E> temp = head;	
int curin=0;
int previn = 0;
String ans ="";
if(size%2==0) {
	 previn=size-2;
}
else {
	 previn=size-1;
}
int nextin=curin+1;
String vals=Integer.toString(curin)+" "+Integer.toString(previn)+" "+Integer.toString(nextin)+" "+temp.getData();
ans=ans+vals+"\n";
for(int i=1;i<size;i++) {
	temp = temp.next;
	curin++;
	if(curin%2==0) {
		previn=curin-2;
	}
	if(curin%2==1) {
		previn=-1;
	}
	if(nextin==size-1) {
		nextin=0;
	}
	else {
	nextin++;
	}
	if(i==size-1) {
		vals=Integer.toString(curin)+" "+Integer.toString(previn)+" "+Integer.toString(nextin)+" "+temp.getData();
		ans=ans+vals;
	}
	else {
	vals=Integer.toString(curin)+" "+Integer.toString(previn)+" "+Integer.toString(nextin)+" "+temp.getData();
	ans=ans+vals+"\n";
	}
}





return ans;
}
}
