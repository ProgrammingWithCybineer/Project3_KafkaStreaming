import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.SparkConf
import java.sql.DriverManager
import java.sql.Connection

object KafkaSparkIntegration {
    def main(args:Array[String]): Unit = {
  
        val spark = SparkSession
            .builder
            .appName("KafkaSparkIntegration")
            .master("local")
            .getOrCreate()

        spark.sparkContext.setLogLevel("WARN")

        import spark.implicits._
        // Create object
       var a = true
       var le = new leif
       var ana = new anass
       var my = new myclass
       var loc = new Location
    //    var date = new DateTimeGen
       var chris1 = new EcommerceWebsiteName
       var chris2 = new PaymentTransId
       var id = new ID
       var proID = new ProductID
       var proName = new RandomName


      // create while loop 
        while (a == true) 
        {
        Thread.sleep(200)

        
        

        
        // var result1 = ana.Quantity
        // var result2 = my.Greetings
        
        
        // var result1 = id.idGen(digits)
        // var result2 = id.idGen(cat)
        var result3 = proID.getNum
        // var result4 = proName.getName
        var result5 = null
        var result6 = null
        var result7 = null
        var result8 = null
        // var result9 = date.Price(cat)
        // var result10 = date.dateTimeGen
        var result11 = loc.getLocation           // for country and city
        var result12 = chris1.randomWebNames
        var result13 = chris2.randomPymtTransId
        var result14 = le.Output                // for payt trns success and failure reason
        

        // var result3 = loc.getLocation
        var allStrings = ""

       
       allStrings = result3 + result5 + result6 + result7 + result8 + result11 + result12 + result13 + result14;
        

        val rdd = spark.sparkContext.parallelize(Array(("gabriel", allStrings)))
        val df = rdd.toDF("name", "output")

        df.selectExpr("CAST(name AS String) AS key", "CAST(output AS String) AS value")
            .write
            .format("kafka")
            .option("topic", "mytest")
            .option("kafka.bootstrap.servers","localhost:9092")
            .option("checkpointLocation", "/root/week11/KafkaSparkIntegration")
            .save()

     }

        spark.close()
    }
}