
import java.util.Scanner
import java.sql.Connection
import java.sql.DriverManager
import java.io.FileWriter
import scala.util._
import scala.io.Source

class Product {
var randomNum = new scala.util.Random


 def newProduct(): String = {
   var arr1 = scala.io.Source
      // .fromFile("src/main/input/ProductInfo.csv")
      .fromFile("/home/ec2-user/G2Folder/input/ProductInfo.csv")
      .getLines()
      // .map(_.split(",").map(_.trim))
      .toArray
    var oneProduct=""  
      oneProduct = arr1(randomNum.nextInt(114))

        var firstProd = oneProduct.split(",")

        var col1 = firstProd(0)

        var col2 = firstProd(1)
        var col3 = firstProd(2)
        var finished = col1 + "," + col2 + "," + col3 
         finished = finished.filterNot(x => x == '(' || x == ')' || x == '[' || x == ']')
    return finished
  }

}