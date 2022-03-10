import scala.util.Random


class QuntityTypeOr {

    def payTy(): String={
        val paymentTyp = Set("card", "Internet Banking", "UPI", "Wallet")
        var rand = new Random()
        var pyT = paymentTyp.toList(rand.nextInt(paymentTyp.size))
        return pyT 
        
    }

    def quantityOrder (): Int={
        var rand = new Random()
            var quanty = rand.nextInt(100)
            return quanty 
    }
  
}