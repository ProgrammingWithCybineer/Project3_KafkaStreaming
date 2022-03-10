class leif {

var pSuccess=""
var reason="a"
var counter=0

   
   def Output() : String = {
 
        
    if (counter%5==1||counter%5==2||counter%5==3||counter%5==4)
                {pSuccess="Y"}
            if (counter%5==0)
                {pSuccess="N"}
            if (pSuccess=="Y")
                {reason= "null"}
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

        return outputString

  }
}