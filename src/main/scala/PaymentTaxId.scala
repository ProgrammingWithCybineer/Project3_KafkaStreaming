import scala.io.Source
import scala.util._

class PaymentTaxId {

  var r = new scala.util.Random
  var randomIndex = r.nextInt(10000)

  /*
   * This following methods pull random eCommerce website names
   * and payment tax IDs from CSV files respectively
   */

  def randomWebsiteName(): String = {

    // Store CSV file in an array
    var nameArr = io.Source
      .fromFile("src/main/input/ecommerce_website_names.csv")
      .getLines()
      .map(_.split(",").map(_.trim))
      .toArray

    // Generate random array index/website name
    var randomWebsite = (nameArr(randomIndex)(0))

    return randomWebsite

  }

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
