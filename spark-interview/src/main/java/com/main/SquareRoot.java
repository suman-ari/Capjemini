package com.main;

import org.apache.commons.lang3.StringUtils;
import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SquareRoot {

	public static void main(String[] args) {
		
		/* creating saprksession object */
		SparkSession spark = SparkSession.builder().appName("sqrt").master("local").getOrCreate();

		/* Reading data from text file and creating a dataset of string values */ 
		Dataset<String> df = spark.read().textFile("<Path>");

		/* converting dataset of string to dataset of its squre value in long*/ 
		Dataset<Long> fd1 = df.map((MapFunction<String, Long>) row -> 
		{
			long sqr=0;
			if(StringUtils.isNumeric(row))
				sqr = Long.parseLong(row)* Long.parseLong(row);
			return sqr;
		}, Encoders.LONG());

		/* summation of all the values in dataset */
		long sum = fd1.reduce((a, b) -> a + b);

		System.out.println(Math.sqrt(sum));
	}

}
