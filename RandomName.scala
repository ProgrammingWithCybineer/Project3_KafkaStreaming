import org.apache.hadoop.shaded.org.eclipse.jetty.websocket.common.frames.DataFrame // Windows users must comment this line out
import org.apache.spark.sql.SparkSession

class RandomName {

    def getName(): String = {
        val spark = SparkSession.builder().appName("RandomName").config("spark.master", "local").config("spark.eventLog.enabled", "false").getOrCreate()
        spark.sparkContext.setLogLevel("WARN")

        val df1 = spark
            .read
            .options(Map("inferSchema" -> "true", "header" -> "true"))
            .csv("resources/firstnames.csv")
            .withColumnRenamed("John", "first_names")
            .createOrReplaceTempView("names")

        var randomName = spark.sql("SELECT first_names FROM names ORDER BY RAND() LIMIT 1").collect.mkString(",")

        var formattedName = randomName.filterNot(x => x == '[' || x == ']')

        val df2 = spark
            .read
            .options(Map("inferSchema" -> "true", "header" -> "true"))
            .csv("resources/surnames.csv")
            .createOrReplaceTempView("surnames")

        var randomSurname = spark.sql("SELECT name FROM surnames ORDER BY RAND() LIMIT 1").collect.mkString(",")

        spark.stop()

        var surnameNoBrackets = randomSurname.filterNot(x => x == '[' || x == ']')

        var formattedSurname = surnameNoBrackets.charAt(0) + surnameNoBrackets.substring(1, surnameNoBrackets.length - 1).toLowerCase()

        var nameCombo = (s"$formattedName $formattedSurname")

        return nameCombo

    }

}

