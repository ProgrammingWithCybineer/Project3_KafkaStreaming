import scala.io.Source
import scala.collection.mutable.ArrayBuffer
object KafkaSparkIntegration {
   
   var a=0
   var arr =new ArrayBuffer [Array[String]]()
    def main(args:Array[String]): Unit = {
 
 
 var amin=new Product
  var loc=new Location
 for (i<-0 to 5)
println(webNames + "," +amin.newProduct() + "," + amin.randomName + loc.getPlace())
 
    }





  def webNames(): String = {
   var arr = io.Source
      .fromFile("src/main/input/ecommerce_website_names.csv")
      .getLines()
      .map(_.split(",").map(_.trim))
      .toArray
var oneSite=""
   
       
        oneSite =(arr(a)(0))
    
a=a+1
    return oneSite

    

  }

/*def eachWebSite(): String = {

var oneSite=""

oneSite=arr((a),(0))

a=a+1

return oneSite
*///}

}
