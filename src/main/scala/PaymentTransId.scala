import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession

class PaymentTransId {
  def randomPymtTransId(): String = {
    var arr3 = scala.io.Source
      // .fromFile("src/main/input/payment_txn_id.csv")                    // user can use path with EC2 
      .fromFile("/home/ec2-user/G2Folder/input/payment_txn_id.csv")     // you change this path into your EC2 path 
      .getLines()
      // .map(_.split(",").map(_.trim))
      .toArray


    var onePaymentId=""
    var randomNum = new scala.util.Random
    var randomRow = arr3(randomNum.nextInt(1000))

        var paymentId = randomRow.split(",")

        var onePayment = paymentId(0)
  
    return onePayment

  }

}