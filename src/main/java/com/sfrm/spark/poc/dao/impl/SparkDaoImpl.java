package com.sfrm.spark.poc.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sfrm.spark.poc.dao.SparkDao;

@Repository
public class SparkDaoImpl implements SparkDao {

	/*@Autowired
	private SparkSession sparkSession;
	*/
	
	@Autowired
	private JavaSparkContext javaSparkContext;

	@Override
	public long getWordCount() {
		List<String> worlds = Arrays.asList("spark", "hadoop", "spark", "hive", "pig", "cassandra", "hadoop");
		//Dataset<String> wordDataSet = javaSparkContext.createDataset(worlds, Encoders.STRING());
		//System.out.println("Count>>>>>>>: " + wordDataSet.count());
		/*String columns[] = wordDataSet.columns();
		for (int i = 0; i < columns.length; i++) {
			System.out.println(">>>" + columns[i]);

		}*/
		//return wordDataSet.count();
		return 1;
	}

}
