import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession

class PaymentTransId {
  def randomPymtTransId(): String = {
    val spark: SparkSession = SparkSession.builder
      .appName("SparkVSCode")
      .config("spark.master", "local")
      .getOrCreate()

    spark.sparkContext.setLogLevel("ERROR")
    import spark.implicits._

    val df = spark.read
      .format("com.databricks.spark.csv")
      .option("header", false)
      .load("input/payment_txn_id.csv")

    df.createOrReplaceTempView("df")
    val result =
      spark.sql("SELECT * FROM df ORDER BY RAND() LIMIT 1").collect.mkString

    var pymt_txn_id = result.drop(1).dropRight(1)

    return pymt_txn_id

  }

}
