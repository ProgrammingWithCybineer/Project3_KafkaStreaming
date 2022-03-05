import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession

class EcommerceWebsiteName {
  def randomWebNames(): String = {
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
    val result =
      spark.sql("SELECT * FROM df ORDER BY RAND() LIMIT 1").collect.mkString

    var random_website_name = result.drop(1).dropRight(1)

    return random_website_name

  }

}