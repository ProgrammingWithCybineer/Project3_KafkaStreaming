import java.util.Scanner
import java.sql.Connection
import java.sql.DriverManager
import java.io.FileWriter
import org.apache.spark.sql.SparkSession
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.sql.SQLContext


class Product {
 // **** globals variables and connections to SQL adjust -- uncomment line 14 through 21 *****
      /*  val driver = "com.mysql.jdbc.Driver"
        val url = "jdbc:mysql://localhost:3306/Products"
        val username = "root"
        val password = "Greenairplane.87"
        var connection: Connection = null
        Class.forName(driver)
        connection = DriverManager.getConnection(url, username, password)
        var statement = connection.createStatement()
        var statement1 = connection.createStatement() 
        */
        System.setProperty("hadoop.home.dir", "C:\\hadoop\\")  //for windows
        val spark=SparkSession
            .builder
            .appName("sparkSQL")
            .master("local[*]")
            .getOrCreate()
            spark.sparkContext.setLogLevel("WARN")

     /*   
  // gets item
    def productName(c: Int): String = {
         val userRes = statement.executeQuery("Select item from ProductItem where itemID = "+c+";")
         var itemA = ""
         while (userRes.next()){
         itemA = userRes.getString(1)
         itemA = itemA.toString()
         }
         return itemA
    }
    //gets category
    def productCategory(x: String): String = {
        //x = itemA
         var userRes1= statement1.executeQuery("Select category from ProductItem where item = \""+x+"\";")
         var categoryA =""
        while (userRes1.next()){
         categoryA =userRes1.getString(1)
         categoryA = categoryA.toString()
        }
         return categoryA
    }
    // used to create input file. Can add new items to database using sql in (inputs) and re-run this method for updated list. Adjust file path and loop number.
    def productFile(): Unit = {
        var c = 1
        var file = new FileWriter("C:\\Users\\amina\\Training\\Final Project\\Inputs\\ProductInfo.csv")
        for (i<- 0 to 113) {
            var itemB = productName(c)
            var categoryB = productCategory(itemB)
            var categoryID=""
            var itemID = ""
            var productID=""
            var xc=""
            var userRes2 =statement.executeQuery("Select categoryID from ProductC where category = \""+categoryB+"\"" )
            while (userRes2.next()) {
                categoryID = userRes2.getString(1)
                categoryID.toString()
            }
            var userRes3 =statement1.executeQuery("Select itemID from ProductItem where item = \""+itemB+"\"" )
            while (userRes3.next()){
                itemID = userRes3.getString(1)
                var itemID1 =itemID.toInt
                xc= f"$itemID1%03d".toString()
            }
            productID = categoryID + xc
            var productTup = (productID,itemB,categoryB).toString() +"\n"
            c+=1
            file.write(productTup) 
        }
        file.close()
        connection.close()
     } 
     */
     // pulls random item from list as ID, item, category string
     def productInfo(): String =  {
        val csvFile = spark.read.format("csv")
            .option("mode", "FAILFAST")
            .option("inferSchema", "true")
            .option("header", "true")
            .load("C:\\Users\\amina\\Training\\Final Project\\Inputs\\ProductInfo.csv")
            csvFile.createOrReplaceTempView("products_temp")
        
        var result2 = spark.sql("SELECT * FROM products_temp ORDER BY RAND() LIMIT 1").collect.mkString(",")
        var finalproduct = result2.filterNot(x => x == '(' || x == ')' || x == '[' || x == ']')
        return finalproduct
     }
}
