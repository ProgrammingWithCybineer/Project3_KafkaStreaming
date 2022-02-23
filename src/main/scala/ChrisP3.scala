import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.UserDefinedFunction

object ChrisP3 {

  def main(args: Array[String]): Unit = {

    grabWebNames()
    grabTransId()

    def grabWebNames() {
      var grab = new EcommerceWebsiteName
      grab.randomWebNames
    }

    def grabTransId() {
      var grab = new PaymentTransId
      grab.randomPymtTransId
    }
  }
}
