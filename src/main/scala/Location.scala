import scala.collection.mutable.ArrayBuffer
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.sql._
import org.apache.log4j._
import java.util.Scanner
import java.sql.DriverManager
import java.sql.Connection
// import com.mysql.cj.xdevapi.UpdateStatement
import java.io.File
import java.io.PrintWriter
import java.io.Console;

class Location {

  def getLocation():String = {

        val spark=SparkSession
        .builder
        .appName("sparkSQL")
        .master("local[*]")
        .getOrCreate()
        spark.sparkContext.setLogLevel("ERROR")

        //Loading CSV file and creating DataFrame
        val csvFile =spark.read.format("csv")
        .option("mode", "FAILFAST")
        .option("inferSchema", "true")
        .option("header", "true")
        .load("datasets/worldcities.csv")
        csvFile.createOrReplaceTempView("temp_data")
        


        
        var result = spark.sql("SELECT * FROM temp_data ")
        //println("")
        //println("City and Country")
        var result2 = spark.sql("SELECT * FROM temp_data ORDER BY RAND() LIMIT 1").collect.mkString(",")
        var formattedResult2 = result2.filterNot(x => x == '[' || x == ']')
        var separator = ","
        var sepPos = formattedResult2.lastIndexOf(separator)
        var city = formattedResult2.substring(0,sepPos)
        var country = formattedResult2.substring(sepPos + 1)
        var finalResult2 = city + ", " + country
        return finalResult2
                
    
    }
}