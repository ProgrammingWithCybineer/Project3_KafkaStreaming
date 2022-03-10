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

object Kafka {
var a=true

    def main(args: Array[String]): Unit = {



    Logger.getLogger("org").setLevel(Level.OFF)
    Logger.getLogger("akka").setLevel(Level.OFF)

    println("program started")

    val conf = new SparkConf().setMaster("local[4]").setAppName("kafkar")
    val ssc = new StreamingContext(conf, Seconds(20))
 

 while (a==true)
    //my kafka topic name is 'mytest'
  {  val kafkaStream = KafkaUtils.createStream(ssc, "localhost:2181","spark-streaming-consumer-group", Map("mytest" -> 5) )
 Thread.sleep(5000)
var  kafkaStream1=kafkaStream
kafkaStream1.union(kafkaStream)
   
   var kafkaStream2=kafkaStream1.saveAsTextFiles("/mnt/c/Users/leifr/Desktop/Kafka/prefix-TIME_IN_MS[.suffix]")
   
   /* kafkaStream.print()
      var file=ssc.textFileStream("")
      file.toString()
 val newOutPut =new BufferedWriter(new FileWriter("src/main/append.csv"))
    val csvWriter= new CSVWriter(newOutPut)
   // val Schema=ArrayBuffer()
    var newList= new ListBuffer[Array[String]]()
   var newList1=Array(file)
    newList+=newList1
    csvWriter.write(newList.toList)
   newOutPut.close()
    println(unit)
*/
      ssc.start
      ssc.awaitTermination() 
   }
  }
}
