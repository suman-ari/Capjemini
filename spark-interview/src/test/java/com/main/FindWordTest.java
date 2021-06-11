package com.main;

import static org.junit.Assert.assertEquals;

import org.apache.spark.sql.Dataset;
import org.junit.Test;

import com.wrapper.SparkSessionTestWrapper;
/**
 * Test class to test Find Word functionality
 * @author Suman
 *
 */
public class FindWordTest implements SparkSessionTestWrapper {

	/* method to test the success scenario of finding the word */
	@Test
	public void testFindWord() {
		Dataset<String> df = spark.read().textFile("C:\\Users\\HP\\git\\repository\\spark-interview\\src\\test\\resources\\word.txt");
		String actual = FindWord.findWord(df);
		String expected = "Keyword \"Christmas\" exists in the given file";
		assertEquals(expected,actual);
	}
	
	/* method to test the scenario of not finding the word */
	@Test
	public void testNotFindWord() {
		Dataset<String> df = spark.read().textFile("C:\\Users\\HP\\git\\repository\\spark-interview\\src\\test\\resources\\no_word.txt");
		String actual = FindWord.findWord(df);
		String expected = "";
		assertEquals(expected,actual);
	}

}
