package com.shao.scsst;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TriangleTest {
	Triangle triangle;
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	

	@Test
	public final void testIdentify() {
		triangle = new Triangle(1,1,1);
		assertEquals(0, triangle.identify());//equilateral
		triangle = new Triangle(-1,1,1);
		assertEquals(-1, triangle.identify());//input wrong
		triangle = new Triangle(1,2,3);
		assertEquals(-1, triangle.identify());//input wrong
		triangle = new Triangle(2,2,3);
		assertEquals(1, triangle.identify());//isosceles
		triangle = new Triangle(2,3,4);
		assertEquals(2, triangle.identify());//scalene
	}

}
