import org.apache.log4j.{Level, Logger}
import org.apache.spark.SparkConf
import org.apache.spark.streaming.kafka.KafkaUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import org.apache.spark.streaming._
import org.apache.spark.streaming.kafka
import org.apache.spark.streaming.StreamingContext._

import scala.collection.mutable.ArrayBuffer
import java.io.{BufferedWriter, OutputStreamWriter}
import scala.collection.JavaConversions._
import scala.util.Random
import java.io.{File, FileWriter}
import au.com.bytecode.opencsv.CSVWriter

import scala.collection.mutable.ListBuffer
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession


object Kafka {
var a=true

    def main(args: Array[String]): Unit = {

      val spark=SparkSession
      .builder
      .appName("Consumer")
      .config("spark.master", "local")
      .getOrCreate()
  
      spark.sparkContext.setLogLevel("WARN")
      var lines=spark
      .readStream
      .format("kafka")
      .option("kafka.bootstrap.servers", "localhost:9092")
      .option("subscribe", "mytopic")
      .option("failOnDataLoss", "false")
      .load()

      var r=lines.selectExpr("Cast(key AS STRING)", "CAST(value AS STRING)")
       
        
         
      r.writeStream
       .format("csv")
       .option("path", "/home/ec2-user/G2Folder/project3/src/main/output")
       .option("checkpointLocation",  "/home/ec2-user/G2Folder/project3/src/main/output")
       .start()
       //  .awaitTermination(5000)
         //.stop()
       
       var r2=r

       for (i<-0 to 5)
       {
        r=lines.selectExpr("Cast(key AS STRING)", "CAST(value AS STRING)")
        r2.union(r)
        Thread.sleep(5000)}
        
        r2.writeStream
          .format("csv")
          .option("path", "/home/ec2-user/G2Folder/project3/src/main/output1")
          .option("checkpointLocation",  "/home/ec2-user/G2Folder/project3/src/main/output1")
          .start()
          .awaitTermination(5000)


            

        // val dataFrame=spark.read.option("header", "true").csv("/home/ec2-user/G2Folder/project3/src/main/output1")
        //  dataFrame.repartition(1).write.format("com.databricks.spark.csv").mode("overwrite").csv("/home/ec2-user/G2Folder/project3/src/main/FinalOutput")

  }
}
