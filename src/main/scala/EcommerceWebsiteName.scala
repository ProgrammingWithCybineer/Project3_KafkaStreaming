import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession
import scala.io.Source

class EcommerceWebsiteName {
  def webNames(): String = {
   var arr = scala.io.Source
      // .fromFile("src/main/input/ecommerce_website_names.csv")
      .fromFile("/home/ec2-user/G2Folder/input/ecommerce_website_names.csv")
      .getLines()
      // .map(_.split(",").map(_.trim))
      .toArray

    var oneSite=""
    var randomNum = new scala.util.Random
    var randomRow = arr(randomNum.nextInt(1000))

        var web = randomRow.split(",")

        var webName = web(0)
   
    return webName
  }

}