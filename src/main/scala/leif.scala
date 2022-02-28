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
 
        
            if (counter%5==1||counter%5==2||counter%5==3||counter%5==4)
                {pSuccess="Y"}
            if (counter%5==0)
                {pSuccess="N"}
            if (pSuccess=="Y")
                {reason=null}
            if (pSuccess=="N" &&( counter%35==5 ||counter%35==20))
                {reason="InsuffientFunds"}
            if (pSuccess=="N" &&( counter%35==10|| counter%35==0))
                {reason="PurchaseTooLarge"}
            if (pSuccess=="N" &&( counter%35==15))
                {reason="IncorrectInformation"}
            if (pSuccess=="N" &&( counter%35==30))
                {reason="AccountClosed"}
            if (pSuccess=="N" && (counter%35==25 ))
                {reason="ExceededDailyLimit"}  
           
      
            counter=counter+1
        var outputString=pSuccess + "," + reason 
      
      /* for (i<-0 to (outputString.length-1))
       {
        if (i!=outputString.length-1)
           {outputString2+=outputString(i)}

        else {outputString2+=""}
       */ //}
    
 


        return outputString

    }
}


