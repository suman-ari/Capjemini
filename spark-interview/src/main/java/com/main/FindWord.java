package com.main;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.SparkSession;

public class FindWord {

	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder().appName("findWord").master("local").getOrCreate();
		
		Dataset<String> df = spark.read()
				.textFile("F:\\work\\canada\\java-scala-wspace\\spark-interview\\src\\main\\resources\\word.txt");
		
		Dataset<String> result = df.filter(f-> f.contains("Christmas"));
		
		if(result.count()>0)
		{
			System.out.println("Keyword \"Christmas\" exists in the given file");
		}

	}

}
