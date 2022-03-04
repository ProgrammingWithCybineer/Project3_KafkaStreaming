class Location {

  def getPlace(): String = {

var locations = io.Source
            .fromFile("src/main/datasets/worldcities.csv")
            .getLines()
            .map(_.split(",").map(_.trim))
            .toArray

 var randomNum = new scala.util.Random
var randomNum1=randomNum.nextInt(10000)
        var randomLocation = locations(randomNum1)(1)+"," + locations(randomNum1)(0) + ","

return randomLocation


   /* var arr = io.Source
      .fromFile("datasets/worldcities.csv")
      .getLines()
      .map(_.split(",").map(_.trim))
      .toArray

    for (i <- 0 to arr.length - 1) {
      for (j <- 0 to 1) {
        println(arr(i)(j))
      }
    }

    return arr
*/
    

  }
}
