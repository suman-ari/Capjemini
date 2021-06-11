package com.main;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Test class to test find duplicate value functionality
 * @author Suman
 *
 */
public class FindDuplicateTest {
	

	/* test method for success scenario */
	@Test
	public void testDuplicate() throws Exception {
		List<Integer> inputList = Arrays.asList(3,1,3,4,2);
		int size = inputList.size();
		int expectedValue = 3;
		int actualValue = FindDuplicate.duplicate(inputList, size);
		assertEquals(expectedValue, actualValue);
	}
	
	/* test method for no duplicate scenario */
	@Test
	public void testNoDuplicate() throws Exception {
		List<Integer> inputList = Arrays.asList(3,1,5,4,2);
		int size = inputList.size();
		int expectedValue = -1;
		int actualValue = FindDuplicate.duplicate(inputList, size);
		assertEquals(expectedValue, actualValue);
	}
	
	/* test method to test array size exception */
	@Test
	public void testArraySizeError() {
		List<Integer> inputList = Arrays.asList(3,1,3,4,2);
		int size = 4;
		
		try
		{
			int actualValue = FindDuplicate.duplicate(inputList, size);
		}
		catch(Exception e)
		{
			assertEquals(e.getMessage(), "array size does not match with number of input data");
		}
		
	}

}
