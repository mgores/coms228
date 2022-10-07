package cs228hw2;

import static org.junit.Assert.assertEquals;

public class PreciseNumberTests {
	public static void main(String[] args) {
		AmusingPreciseNumber x = new AmusingPreciseNumber(512);
		AmusingPreciseNumber y = new AmusingPreciseNumber(12);
		x.add(y);
		assertEquals("524", x.toString());
		
		x = new AmusingPreciseNumber(500);
		y = new AmusingPreciseNumber(390);
		x.add(y);
		assertEquals("890", x.toString());
		
		//Basic adding tests (may also test subtract, depending on how you did it)
		x = new AmusingPreciseNumber(99847);
		y = new AmusingPreciseNumber(99910083);
		y.add(x);
		assertEquals("100009930", y.toString());
		x = new AmusingPreciseNumber(-99847);
		y = new AmusingPreciseNumber(99910083);
		y.add(x);
		assertEquals("99810236", y.toString());
		x = new AmusingPreciseNumber(99847);
		y = new AmusingPreciseNumber(-99910083);
		y.add(x);
		assertEquals("-99810236", y.toString());
		x = new AmusingPreciseNumber(-99847);
		y = new AmusingPreciseNumber(-99910083);
		y.add(x);
		assertEquals("-100009930", y.toString());
		
		//Subtraction tests
		x = new AmusingPreciseNumber(99847);
		y = new AmusingPreciseNumber(99910083);
		y.subtract(x);
		assertEquals("99810236", y.toString());
		x = new AmusingPreciseNumber(-99847);
		y = new AmusingPreciseNumber(99910083);
		y.subtract(x);
		assertEquals("100009930", y.toString());
		x = new AmusingPreciseNumber(99847);
		y = new AmusingPreciseNumber(-99910083);
		y.subtract(x);
		assertEquals("-100009930", y.toString());
		x = new AmusingPreciseNumber(-99847);
		y = new AmusingPreciseNumber(-99910083);
		y.subtract(x);
		assertEquals("-99810236", y.toString());
		
		//A few zero cases, if you think you need more due to your implementation, you might want to
		x = new AmusingPreciseNumber(0);
		y = new AmusingPreciseNumber(0);
		x.add(y);
		assertEquals("0", x.toString());
		x.subtract(y);
		assertEquals("0", x.toString());
		//sorry about this
		x.negate();
		assertEquals("0", x.toString());
		x = new AmusingPreciseNumber(800);
		x.add(y);
		assertEquals("800", x.toString());
		x.subtract(y);
		assertEquals("800", x.toString());
		y = AmusingPreciseNumber.negate(x);
		x.add(y);
		assertEquals("0", x.toString());
	}
}
	