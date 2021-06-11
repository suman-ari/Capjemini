package com.main;

import org.apache.commons.lang3.StringUtils;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

/**
 * class compute the square root of sum of squares of all these numbers provided in a file 
 * @author Suman
 *
 */
public class SquareRoot {
	
	/* method to calculate the value */
	public static double squareRootValue(Dataset<String> df)
	{
		/* converting dataset of string to dataset of its square value in long*/ 
		Dataset<Long> fd1 = df.map((MapFunction<String, Long>) row -> 
		{
			long sqr=0;
			if(StringUtils.isNumeric(row))
				sqr = Long.parseLong(row)* Long.parseLong(row);
			return sqr;
		}, Encoders.LONG());

		/* summation of all the values in dataset */
		long sum = fd1.reduce((a, b) -> a + b);
		
		return Math.sqrt(sum);
	}

	public static void main(String[] args) {
		
		/* creating saprksession object */
		SparkSession spark = SparkSession.builder().appName("sqrt").master("local").getOrCreate();

		/* Reading data from text file and creating a dataset of string values */ 
		Dataset<String> df = spark.read().textFile("C:\\Users\\HP\\git\\repository\\spark-interview\\src\\main\\resources\\data.txt");

		double value = squareRootValue(df);

		System.out.println(value);
	}

}
