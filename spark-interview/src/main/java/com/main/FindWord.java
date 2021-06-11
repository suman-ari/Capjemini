package com.main;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;


/**
 * class to find the word Christmas in a file using spark
 * @author Suman
 *
 */
public class FindWord {

	/* method to find the word */
	public static String findWord(Dataset<String> df) {
		
		String out = "";
		Dataset<String> result = df.filter(f -> f.contains("Christmas"));

		
		if (result.count() > 0) {
			out = "Keyword \"Christmas\" exists in the given file";
		}
		
		return out;
	}

	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder().appName("findWord").master("local").getOrCreate();

		Dataset<String> df = spark.read().textFile("C:\\Users\\HP\\git\\repository\\spark-interview\\src\\main\\resources\\word.txt");

		String output = findWord(df);
		
		System.out.println(output);
	}

}
