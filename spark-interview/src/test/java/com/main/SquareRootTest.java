package com.main;

import static org.junit.Assert.*;

import org.apache.spark.sql.Dataset;
import org.junit.Test;

import com.wrapper.SparkSessionTestWrapper;

/**
 * Test class to test Square root functionality
 * @author Suman
 *
 */
public class SquareRootTest implements SparkSessionTestWrapper{

	/* test method to test success scenario */
	@Test
	public void testData() {
		Dataset<String> df = spark.read().textFile("C:\\Users\\HP\\git\\repository\\spark-interview\\src\\test\\resources\\data.txt");

		double expected = Math.sqrt((1*1)+(10*10)+(50*50)+(100*100));
		double actual = SquareRoot.squareRootValue(df);
		
		assertEquals(Double.doubleToLongBits(expected), Double.doubleToLongBits(actual));
	}
	
	/* test method to test success scenario with random data */
	@Test
	public void testArbitraryData() {
		Dataset<String> df = spark.read().textFile("C:\\Users\\HP\\git\\repository\\spark-interview\\src\\test\\resources\\arbitrary_data.txt");

		double expected = Math.sqrt((1*1)+(10*10)+(50*50)+(100*100));
		double actual = SquareRoot.squareRootValue(df);
		
		assertEquals(Double.doubleToLongBits(expected), Double.doubleToLongBits(actual));
	}
	
	/* test method to test not Equal data */
	@Test
	public void testNotEqualData() {
		Dataset<String> df = spark.read().textFile("C:\\Users\\HP\\git\\repository\\spark-interview\\src\\test\\resources\\data.txt");

		double expected = 0.0;
		double actual = SquareRoot.squareRootValue(df);
		
		assertNotEquals(Double.doubleToLongBits(expected), Double.doubleToLongBits(actual));
	}

}
