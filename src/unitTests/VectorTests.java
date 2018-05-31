package unitTests;
import primitives.*;
import static org.junit.Assert.*;


import org.junit.Test;


public class VectorTests {
	Vector x;
	Vector y;

	@Test
	public void testAdd() {
		x=new Vector(2.0,3.0,4.0);
		y=new Vector(3.0,5.0,5.0);
		assertEquals(new Vector(5.0,8.0,9.0).getHead(),x.add(y).getHead());
	}
	
	@Test
	public void testSubtract() {
		x=new Vector(5.5,5.0,6.0);
		y=new Vector(3.5,8.0,3.5);
		assertEquals(new Vector(2.0,-3.0,2.5).getHead(),x.subtract(y).getHead());
	}
	
	@Test
	public void testScaling() {
		x= new Vector(0.0,5.5,4.5);
		double z= 3;
		assertEquals(new Vector(0.0,16.5,13.5).getHead(),x.scale(z).getHead());
	}
	
	@Test
	public void testDotProduct() {
		x=new Vector(0.0,5.0,5.0);
		y=new Vector(1.0,2.0,3.0);
		assertEquals(x.dotProduct(y),25.0,0.0001);
	}
	
	@Test
	public void testCrossProduct() {
		x=new Vector(0.0,5.0,5.0);
		y=new Vector(1.0,2.0,3.0);
		assertEquals(new Vector(5.0,5.0,-5.0).getHead(),x.crossproduct(y).getHead());
	}
	@Test
	public void testLength() {
		x=new Vector(1.0,2.0,3.0);
		assertEquals(Math.sqrt(14),x._length(),0.0001);
	}
	@Test
	public void testNormalize() {
		x=new Vector(3.0,4.0,5.0);
		double z=x._length();
		assertEquals(new Vector(3.0/z,4.0/z,5.0/z).getHead(),x._normalize().getHead());
	}
	
}
