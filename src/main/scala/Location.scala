
import java.util.Scanner
import scala.io.Source
import java.io.File
import java.io.PrintWriter
import java.io.Console;

class Location {

  def getPlace(): String = {

  var locations = scala.io.Source
      // .fromFile("src/main/datasets/worldcities.csv")
      .fromFile("/home/ec2-user/G2Folder/input/worldcities.csv")

      .getLines()
      // .map(_.split(",").map(_.trim))
      .toArray

  var randomNum = new scala.util.Random
  var randomRow = locations(randomNum.nextInt(30000))

        var oneLocation = randomRow.split(",")

        var city = oneLocation(0)
        var country = oneLocation(1)
        var allLocation = country + "," + city

    return allLocation  

  }
}