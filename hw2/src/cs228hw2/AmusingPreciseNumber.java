package cs228hw2;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.management.RuntimeOperationsException;
/**
 * stores a number to very precise accuracy in a list
 * @author markgores
 *
 * @param <E>
 */
public class AmusingPreciseNumber<E> {
	LinkedList stack = new LinkedList<E>();
	LinkedList sum = new LinkedList<E>();
	/**
	 * Creates an AmusingPreciseNumber from an int type.
	 * @param numb
	 * int
	 */
	public AmusingPreciseNumber(int numb) {
		String a = Integer.toString(numb);
		for(int i=0;i<a.length();i++) {
			stack.push(a.charAt(i));
		}
		
	}
	/**
	 * Creates an AmusingPreciseNumber from a String.
	 * @param numb
	 */
	public AmusingPreciseNumber(String numb) {
	try {
		Number temp = Float.parseFloat(numb);
	}
	catch(RuntimeOperationsException e){
		throw e;
	}
	for(int i=0;i<numb.length();i++) {
		stack.push(numb.charAt(i));
	}
	}
	/**
	 * Creates an amusingprecisenumber from a reader
	 * @param r
	 * @throws IOException
	 */
	public AmusingPreciseNumber( Reader r ) throws IOException {
		char data;
		String a = "";
		while((data =(char) r.read())!=' ') {
			a+=data;
			
			}
		try {
			Number temp = Float.parseFloat(a);
		}
		catch(RuntimeOperationsException e){
			throw e;
		}
		for(int i=0;i<a.length();i++) {
			stack.push(a.charAt(i));
		}
		
		
	}

/**
 * makes a amusingprecisenumber from an amusingprecisenumber
 * @param numb
 */
public AmusingPreciseNumber( AmusingPreciseNumber numb ) {
	for(int i=0;i<numb.stack.size();i++) {
	stack.add(numb.stack.get(i));
	}
}
/**
 * adds newnum to this amusingprecisenumber
 * @param newnum
 */
public void add( AmusingPreciseNumber newnum ) {
	int carry=1;
	List decn= new LinkedList<E>();
	List inn= new LinkedList<E>();
	List in= new LinkedList<E>();
	List dec= new LinkedList<E>();
	
	boolean isnegative=false;
	if(newnum.stack.contains('.')||stack.contains('.')) {
		LinkedList<String> a;
		LinkedList<String> b;
	if(newnum.stack.contains('.')) {
		 inn= splitin(newnum.stack);
		 decn= splitdec(newnum.stack);
		 
	}
	if(!newnum.stack.contains('.')) {
		inn=splitin(newnum.stack);
		decn.add('0');
		
	}
	if(stack.contains('.')) {
		 in= splitin(stack);
		 dec= splitdec(stack);
	}
	if(!stack.contains('.')) {
		in=splitin(stack);
		dec.add('0');
	}
	if(in.contains('-')&& !inn.contains('-')) {
		in.remove(in.size()-1);
		carry=-1;
		inn=pad(inn,in);
		decn=pad(decn,dec);
		in=pad(in,inn);
		dec=pad(dec,decn);
		
		b = (LinkedList<String>) sum(dec,decn,carry);
		a = (LinkedList<String>) sum(inn,in,carry);

		while(!a.isEmpty()) {
			sum.add(a.pop());
		}
		sum.add('.');
		
		while(!b.isEmpty()){
			sum.add(b.pop());
		}
	}
	if(in.contains('-')&& inn.contains('-')) {
		in.remove(in.size()-1);
		inn.remove(inn.size()-1);
		carry=1;
		inn=pad(inn,in);
		decn=pad(decn,dec);
		in=pad(in,inn);
		dec=pad(dec,decn);
		b = (LinkedList<String>) sum(dec,decn,carry);
		a = (LinkedList<String>) sum(in,inn,carry);
		while(!a.isEmpty()) {
			sum.add(a.pop());
		}
		sum.add('.');
		
		while(!b.isEmpty()){
			sum.add(b.pop());
		}
		sum.push('-');
	}
	if(!in.contains('-')&& inn.contains('-')) {
		inn.remove(inn.size()-1);
		carry=-1;
		inn=pad(inn,in);
		decn=pad(decn,dec);
		in=pad(in,inn);
		dec=pad(dec,decn);
		b = (LinkedList<String>) sum(dec,decn,carry);
		a = (LinkedList<String>) sum(in,inn,carry);

		while(!a.isEmpty()) {
			sum.add(a.pop());
		}
		sum.add('.');
		
		while(!b.isEmpty()){
			sum.add(b.pop());
		}
		
	}
	else {
		inn=pad(inn,in);
		decn=pad(decn,dec);
		in=pad(in,inn);
		dec=pad(dec,decn);
		b = (LinkedList<String>) sum(dec,decn,carry);
		a = (LinkedList<String>) sum(in,inn,carry);

		while(!a.isEmpty()) {
			sum.add(a.pop());
		}
		sum.add('.');
		
		while(!b.isEmpty()){
			sum.add(b.pop());
		}
	
	while(!a.isEmpty()) {
		sum.add(a.pop());
	}
	sum.add('.');
	
	while(!b.isEmpty()){
		sum.add(b.pop());
	}
	}
	
	
	}
	
	
	else {
		LinkedList<String> a;
	if(stack.contains('-')&& !newnum.stack.contains('-')) {
		stack.removeLast();
		pad(newnum.stack,stack);
		pad(stack,newnum.stack);
		carry=-1;
		if(isgreater(stack,newnum.stack)) {
			a = (LinkedList<String>) sum(stack,newnum.stack,carry);
			isnegative= true;
			}
			else {
				a = (LinkedList<String>) sum(newnum.stack,stack,carry);
				
			}
	}
	else if(stack.contains('-')&& newnum.stack.contains('-')) {
		stack.removeLast();
		newnum.stack.removeLast();
		pad(newnum.stack,stack);
		pad(stack,newnum.stack);
		carry=1;
		a = (LinkedList<String>) sum(stack,newnum.stack,carry);
		
		isnegative=true;
		
		
	}
	else if(!stack.contains('-')&& newnum.stack.contains('-')) {
		newnum.stack.removeLast();
		pad(newnum.stack,stack);
		pad(stack,newnum.stack);
		carry=-1;
		if(isgreater(stack,newnum.stack)) {
		a = (LinkedList<String>) sum(stack,newnum.stack,carry);
		}
		else {
			a = (LinkedList<String>) sum(newnum.stack,stack,carry);
			isnegative= true;
			
		}
		
	}
	else {
	pad(newnum.stack,stack);
	pad(stack,newnum.stack);
	a = (LinkedList<String>) sum(stack,newnum.stack,carry);
	}
	int i =0;
	while(!a.isEmpty()) {
		if(a.peekFirst()=="0" &&i==0) {
			a.pop();
		}
		i++;
		sum.add(a.pop());
	}
	if(isnegative) {
		sum.push('-');
	}
	}
	
	while(!sum.isEmpty()) {
	stack.push(sum.removeFirst());
	newnum.stack.push(stack.getFirst());
	}
}
/**
 * subtracts newnum from this amusingprecisenumber
 * by negateing it and adding it to this
 * @param newnum
 */
public void subtract( AmusingPreciseNumber newnum ) {
	newnum.negate();
	this.add(newnum);
}
/**
 * removes or adds a negative sign
 */
public void negate() {
	if(stack.contains('-')) {
		stack.removeLast();
	}
	else {
		stack.add('-');
	}
}
/**
 * removes the negative sign if it has one
 */
public void abs() {
	if(stack.contains('-')) {
		stack.removeLast();
	}
}
/**
 * adds numb1 to numb2 and returns the result as an amusingPreciseNumber
 * @param numb1
 * @param numb2
 * @return
 */
public static AmusingPreciseNumber add( AmusingPreciseNumber numb1, AmusingPreciseNumber numb2) {
	AmusingPreciseNumber a = new AmusingPreciseNumber(numb1);
	AmusingPreciseNumber b = new AmusingPreciseNumber(numb2);
	a.add(b);
	return a;
	
}
/**
 * subtracts numb2 from numb1 and returns the result in an AmusingPerciseNumber
 * @param numb1
 * @param numb2
 * @return
 */
public static AmusingPreciseNumber subtract( AmusingPreciseNumber numb1, AmusingPreciseNumber numb2){
	AmusingPreciseNumber a = new AmusingPreciseNumber(numb1);
	AmusingPreciseNumber b = new AmusingPreciseNumber(numb2);
	a.subtract(b);
	return a;
	
}
/**
 * negates the given numb and returns it
 * @param numb
 * @return
 */
public static AmusingPreciseNumber negate( AmusingPreciseNumber numb) {
	AmusingPreciseNumber a = new AmusingPreciseNumber(numb);
	a.negate();
	return a;
	
}
/**
 * removes the negative sign from numb and returns a new AmusingPreciseNumber
 * @param numb
 * @return
 */
public static AmusingPreciseNumber abs( AmusingPreciseNumber numb) {
	AmusingPreciseNumber a = new AmusingPreciseNumber(numb);
	a.abs();
	return a;
	
}
/**
 * splits the list between the integer portion and the decimal portion and returns the integer portion
 * @param a
 * @return
 */
private List<E> splitin(List a) {
	List b= new LinkedList<E>();
	
	List inn= a.subList(a.indexOf('.')+1, a.size());
	for(int i=0;i<inn.size();i++) {
		b.add(inn.get(i));
	}
	return b;
}
/**
 * splits the list between the integer portion and the decimal portion and returns the decimal portion
 * @param a
 * @return
 */
private List<E> splitdec(List a) {
	List b= new LinkedList<E>();
	
	List inn= a.subList(0, a.indexOf('.'));
	for(int i=0;i<inn.size();i++) {
		b.add(inn.get(i));
	}
	return b;
}
/**
 * pads list a with 0's until it matches the size of list b
 * @param a
 * @param b
 * @return
 */
private List<E> pad(List a, List b){
	
	while(a.size()<b.size()) {
		a.add('0');
	}
	return a;
}
/**
 * either adds newnum and newnum1 or subtracts newnum1 from newnum 
 * the add or subtract is based off the value of carry1 if carry1 >0 it adds else it subtracts
 * and returns the reslut of the mathmatical operation
 * @param newnum
 * @param newnum1
 * @param carry1
 * @return
 */
private LinkedList<E> sum(List newnum,List newnum1, int carry1) {
	LinkedList total = new LinkedList<>();
	char tot =' ';
	if(carry1<0) {
		int carry=0;
		int result=0;
	while(!newnum.isEmpty()) {
		int a = Character.getNumericValue((char) newnum.remove(0));
		int b = Character.getNumericValue((char) newnum1.remove(0));
		if(b>a) {
			a=10+a;
		}
		result = (a-carry)-(b);
		
		if(result==0&&newnum.isEmpty()) {
			total.push('0');
		}
		else if(result<0) {
			if(newnum.isEmpty()&&carry>0) {
				total.push('-');
			}
			else {
			result=result*-1;
			tot = (char)(result+'0');
			carry=1;
			total.push(tot);
			}
		}
		else {
			tot = (char)(result+'0');
			total.push(tot);
			if(a>=10) {
				carry=1;
			}
			else {
			carry=0;
			}
		}
	}
	}
	else {
		int carry=0;
		
		while(!newnum.isEmpty()) {
			
			int a = Character.getNumericValue((char) newnum.remove(0));
			int b = Character.getNumericValue((char) newnum1.remove(0));
			int result = a+b+carry;
			if(result>=10) {
				int temp=result;
				result=result%10;
				carry=temp/10;
				tot = (char)(result+'0');
				total.push(tot);
				if(stack.isEmpty()&&carry>=1) {
					tot = (char)(carry+'0');
					total.push(tot);
				}
				
			}
			else {
				tot = (char)(result+'0');
				total.push(tot);
				carry=0;
			}
			
			}
	
	}
	return total;
}
/**
 * returns the string value of this AmusingPreciseNumber
 */
public String toString() {
	String a="";

		for(int i=stack.size()-1;i>=0;i--) {
			a= a+stack.get(i);
			}	
	return a;
}
/**
 * returns true if the contents of list a is greater than list b
 * @param a
 * @param b
 * @return
 */
private boolean isgreater(List a, List b) {
	String sa = "";
	String sb="";
	if(a.size()==1) {
		sa=sa+a.get(0);
		sb=sb+b.get(0);
	}
	else {
	for(int i=a.size()-1;i>0;i--) {
		sa=sa+a.get(i);
	}
	
	for(int i=b.size()-1;i>0;i--) {
		sb=sb+b.get(i);
	}
	}
	int a1=Integer.parseInt(sa);
	int b1=Integer.parseInt(sb);
	if(a1>=b1) {
	return true;
	}
	return false;
}
}
