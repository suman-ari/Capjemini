package com.main;

import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class SquareRoot {

	public static void main(String[] args) {
		SparkSession spark = SparkSession.builder().appName("sqrt").master("local").getOrCreate();

		Dataset<Row> df = spark.read()
				.text("F:\\work\\canada\\java-scala-wspace\\spark-interview\\src\\main\\resources\\data.txt");

		Dataset<Integer> fd1 = df.map((MapFunction<Row, Integer>) row -> Integer.parseInt(row.getString(0))
				* Integer.parseInt(row.getString(0)), Encoders.INT());

		int sum = fd1.reduce((a, b) -> a + b);

		System.out.println(Math.sqrt(sum));
	}

}
