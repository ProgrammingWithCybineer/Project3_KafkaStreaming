import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.udf
import org.apache.spark.sql.functions._
import org.apache.spark.sql.expressions.UserDefinedFunction

class EcommerceInfo {
  def webNames(): Unit = {
    val spark: SparkSession = SparkSession.builder
      .appName("SparkVSCode")
      .config("spark.master", "local")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")
    import spark.implicits._

    val df = spark.read
      .format("com.databricks.spark.csv")
      .option("header", false)
      .load("input/ecommerce_website_names.csv")

    df.createOrReplaceTempView("df")
    val result = spark.sql("SELECT * FROM df ORDER BY RAND() LIMIT 1")
    result.show()

  }

}
