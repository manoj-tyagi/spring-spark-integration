package com.sfrm.spark.poc.conf;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SparkConfig {
	private static final Logger logger = LoggerFactory
			.getLogger(HiveConfig.class);

	@Autowired
	private Environment env;

	/*@Bean(name = "sparkSession")
	@Qualifier("sparkSession")
	public SparkSession sparkSession() {
		SparkSession session = SparkSession
				.builder()
				.appName("WordCount001")
				.master("yarn")
				.config("spark.hadoop.fs.defaultFS", "hdfs://quickstart.cloudera:8020")
				//.config("spark.hadoop.dfs.nameservices", "quickstart.cloudera:8020")
				.config("spark.yarn.access.hadoopFileSystems", "hdfs://quickstart.cloudera:8020")		
				.config("spark.hadoop.yarn.resourcemanager.hostname", "quickstart.cloudera")
				// for cloudera (8050 for hdp)
				.config("spark.hadoop.yarn.resourcemanager.address", "quickstart.cloudera:8032")
				// this my local ip
				.config("spark.driver.host", "127.0.0.1")
				// cdh vmnat ip
				.config("spark.local.ip", "127.0.0.1")
				// copy spark assembly lib from /usr/lib/spark/lib in your cdh and put it into an hdfs path	
					.config("spark.yarn.jars","hdfs://quickstart.cloudera:8020/user/cloudera/share/lib/*.jar")				
				.config("spark.hadoop.yarn.application.classpath",
						"$HADOOP_CONF_DIR, $HADOOP_COMMON_HOME/*, $HADOOP_COMMON_HOME/lib/*,"
								+ "$HADOOP_HDFS_HOME/*, $HADOOP_HDFS_HOME/lib/*,"
								+ "$HADOOP_YARN_HOME/*, $HADOOP_YARN_HOME/lib/*,"
								+ "$HADOOP_MAPRED_HOME/* ,$HADOOP_MAPRED_HOME/lib/*")
				.getOrCreate();
		return session;
	}*/

	@Bean
	public SparkConf sparkConf() {
		SparkConf sparkConf = new SparkConf().setAppName("wordCount")
		// .setSparkHome(sparkHome)
				.setMaster("yarn-client")
				.set("spark.hadoop.fs.defaultFS", "hdfs://quickstart.cloudera:8020")
				//.cosetnfig("spark.hadoop.dfs.nameservices", "quickstart.cloudera:8020")
				.set("spark.yarn.access.hadoopFileSystems", "hdfs://quickstart.cloudera:8020")		
				.set("spark.hadoop.yarn.resourcemanager.hostname", "quickstart.cloudera")
				// for cloudera (8050 for hdp)
				.set("spark.hadoop.yarn.resourcemanager.address", "quickstart.cloudera:8032")
				// this my local ip
				.set("spark.driver.host", "127.0.0.1")
				// cdh vmnat ip
				.set("spark.local.ip", "127.0.0.1")
				// copy spark assembly lib from /usr/lib/spark/lib in your cdh and put it into an hdfs path	
			     .set("spark.yarn.jars","hdfs://quickstart.cloudera:8020/user/cloudera/share/lib/*.jar")				
				.set("spark.hadoop.yarn.application.classpath",
						"$HADOOP_CONF_DIR, $HADOOP_COMMON_HOME/*, $HADOOP_COMMON_HOME/lib/*,"
								+ "$HADOOP_HDFS_HOME/*, $HADOOP_HDFS_HOME/lib/*,"
								+ "$HADOOP_YARN_HOME/*, $HADOOP_YARN_HOME/lib/*,"
								+ "$HADOOP_MAPRED_HOME/* ,$HADOOP_MAPRED_HOME/lib/*");

		return sparkConf;
	}

	@Bean
	public JavaSparkContext javaSparkContext() {
		return new JavaSparkContext(sparkConf());
	}

}
