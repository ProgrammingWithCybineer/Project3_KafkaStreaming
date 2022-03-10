import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.SparkConf
import java.sql.DriverManager
import java.sql.Connection
import scala.io.Source
import scala.collection.mutable._

object KafkaSparkIntegration {

    var arr = new ArrayBuffer [Array[String]]()

    def main(args:Array[String]): Unit = {
        
         var catArray = Array("Electronics", "Office Supplies", "Books", "Home Goods", "Appliances", "Beauty and Health Goods")
        System.setProperty("hadoop.home.dir", "C:\\hadoop\\")

        val spark = SparkSession
            .builder
            .appName("KafkaSparkIntegration")
            .master("local[*]")
            .getOrCreate()

        spark.sparkContext.setLogLevel("ERROR")
        
        import spark.implicits._

        // create a variable to use in while loop
       var a = true
      // Create object
       var le = new leif
       var ana = new QuntityTypeOr
       var loc = new Location()
       var chris1 = new EcommerceWebsiteName
       var chris2 = new PaymentTransId
       var id = new ID
       var proc = new Product
       var proName = new RandomName                           


      // create while loop 
        while (a == true) 
        {

        Thread.sleep(200)

        var dt = DateTimeGen.dateTimeGen()
            Thread.sleep(500)
            var r = scala.util.Random
            var cat = catArray(r.nextInt(5))
          
           
            var myStr = s"${DateTimeGen.Price(cat)}, $dt"

        

        
        
        // call the method by variable
        var result1 = id.idGen()                              // Taiy
        var result3 = proName.getNum                         // Nick
        var result4 = proName.randomName                    // Nick
        var result5 = proc.newProduct                       // Amina
        var result7 = ana.payTy()                           // Anass
        var result8 = ana.quantityOrder()                   // Anass
        var result9 = myStr                                 // Abdoul
        var result11 = loc.getPlace                          // Selena
        var result12 = chris1.webNames                        // Chris
        var result13 = chris2.randomPymtTransId                // Chris
        var result14 = le.Output                                // Leif
        

        // create variable to concatenate all the result in string
        var allStrings = ""

       
        allStrings = result1 + result3 + "," + result4 + "," + result5 + "," + result7 + "," + result8 + "," + result9 + "," + result11 + "," + result12 + "," + result13 + "," + result14;
        

        val rdd = spark.sparkContext.parallelize(Array(("gabriel", allStrings)))
        val df = rdd.toDF("name", "output")

        df.selectExpr("CAST(name AS String) AS key", "CAST(output AS String) AS value")
            .write
            .format("kafka")
            .option("topic", "mytest")
            .option("kafka.bootstrap.servers","localhost:9092")
            .option("checkpointLocation", "/root/week11/KafkaSparkIntegration")     // change at your location
            .save()

     }
     
     

        spark.close()
    }
}