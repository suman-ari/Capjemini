package com.wrapper;

import org.apache.spark.sql.SparkSession;

public interface SparkSessionTestWrapper {
	
	SparkSession spark = SparkSession.builder().appName("TestSession").master("local").getOrCreate();

}
