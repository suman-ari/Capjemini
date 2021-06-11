package com.main;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class to test reverse array functionality
 * @author Suman
 *
 */
public class ReverseTest {

	/* test method to test success scenario */
	@Test
	public void testReverse() {
		String input = "Hello";
		char[] reversed = Reverse.reverse(input);
		String expected_value = "olleH";
		String actual_value = new String(reversed);
		assertEquals(expected_value, actual_value);
	}
	
	/* test method to test null pointer exception with null input given */
	@Test(expected = NullPointerException.class)
	public void testThrowNPE(){
		String input = null;
		Reverse.reverse(input);
	}
	

}
