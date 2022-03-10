import scala.collection.mutable._
class RandomName {
  private var id = 0
def randomName: String = {
     
    var dataArray = scala.io.Source
            .fromFile("src/main/resources/surnames.csv")
            .getLines()
            // .map(_.split(",").map(_.trim))
            .toArray

    var dataArray1 = scala.io.Source
            .fromFile("src/main/resources/firstnames.csv")
            .getLines()
            // .map(_.split(",").map(_.trim))
            .toArray

    var randomNum = new scala.util.Random


    var randomRow = dataArray1(randomNum.nextInt(1000))

        var firstNameArray = randomRow.split(",")

        var firstName = firstNameArray(0)


      var randomRow1 = dataArray(randomNum.nextInt(1000))

        var lastNameArray = randomRow1.split(",")

        var lastName = lastNameArray(0)

        var fullName = firstName + " " + lastName


      return fullName
    // return randomName
 }
 def getNum(): Int = {
      var randomNum = scala.util.Random
      id = randomNum.nextInt(15000)
      return id
    }
}


