import scala.io.Source
import scala.util._

class EcommerceWebsiteName {

  /*
   * This method pulls random eCommerce website
   * names from payment_txn_id.csv
   */

  def randomTaxId(): String = {

    // Store CSV file in an array
    var nameArr = io.Source
      .fromFile("src/main/input/payment_txn_id.csv")
      .getLines()
      .map(_.split(",").map(_.trim))
      .toArray

    // Generate random array index/website name
    var randomTaxId = (nameArr(randomIndex)(0))

    return randomTaxId

  }
}
