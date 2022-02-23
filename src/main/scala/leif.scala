import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.sql.SQLContext
import java.sql.DriverManager
import java.sql.Connection
import java.util.Scanner
import scala.collection.mutable.ArrayBuffer
import org.apache.spark.sql.functions
import org.apache.spark.sql.functions.{min, max}
import org.apache.spark.sql.Row
import org.apache.spark.sql.execution.aggregate.HashAggregateExec
import org.apache.spark.sql.execution.joins.BroadcastHashJoinExec
import org.apache.spark.sql.expressions.scalalang.typed
import org.apache.spark.sql.functions.{avg, broadcast, col, max}
//import org.apache.spark.sql.test.SharedSQLContext
import org.apache.spark.sql.types




class leif{

var pSuccess=""
var reason="a"
var counter=0

   
   def Output() : String = {
 
        
            if (counter%4==3||counter%4==1||counter%4==2)
                {pSuccess="Y"}
            if (counter%4==0)
                {pSuccess="N"}
            if (pSuccess=="Y")
                {reason="Null"}
            if (pSuccess=="N" &&( counter%20==1||counter%20==6||counter%20==11||counter%20==16||counter%20==5))
                {reason="InsuffientFunds"}
            if (pSuccess=="N" &&( counter%20==2||counter%20==7||counter%20==12||counter%20==17||counter%20==10))
                {reason="PurchaseTooLarge"}
            if (pSuccess=="N" &&( counter%20==3||counter%20==8||counter%20==13||counter%20==18||counter%20==15))
                {reason="IncorrectInformation"}
            if (pSuccess=="N" &&( counter%20==4||counter%20==9||counter%20==14||counter%20==19))
                {reason="AccountClosed"}
            if (pSuccess=="N" &&( counter%20==0))
                {reason="Null"}
        
      
            counter=counter+1
        var outputString=pSuccess + "," + reason + ","
        return outputString

    }
}


