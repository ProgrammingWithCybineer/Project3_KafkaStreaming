import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.UserDefinedFunction

object chrisP3 {

  def main(args: Array[String]): Unit = {
    var grab = new EcommerceInfo
    grab.webNames
  }
}
