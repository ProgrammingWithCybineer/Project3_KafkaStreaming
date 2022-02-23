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
