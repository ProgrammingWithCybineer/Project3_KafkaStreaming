object DateTimeGen {
   

    var catArray = Array("Electronics", "Office Supplies", "Books", "Home Goods", "Appliances", "Beauty and Health Goods")
    
     def Price(cat:String): String = {
       var r = scala.util.Random
       var p = 0
       if (cat == "Electronics") {
           p = 50 + r.nextInt(250)
       } else if (cat == "Home Goods" || cat == "Office Supplies") {
           p = 20 + r.nextInt(150)
       } else if (cat == "Appliances" || cat == "Furniture") {
           p = 200 + r.nextInt(500)
       }else {        
           p = 20 + r.nextInt(100)
       }
        return s"$p"
   }

   def dateTimeGen(): String = {
        var r = scala.util.Random
        var arLeap = List(2004, 2008, 2012, 2016, 2020, 2024)
        var ar31 = List(1, 3, 5, 7, 8, 10, 12)
        var ar30 = List(4, 6, 9, 11)
        var d = 0

        var y = 2000 + r.nextInt(23)
        var m = 1 + r.nextInt(12)
        if (m == 2 && arLeap.contains(y)) {
            d = 1 + r.nextInt(29)
        }else if (m == 2) {
            d = 1 + r.nextInt(28)
        } else if (ar31.contains(m)) {
            d = 1 + r.nextInt(31)
        } else {
            d = 1 + r.nextInt(30)
        }

        var h = r.nextInt(24)
        var mm = r.nextInt(60)
        var _date = f"$y-$m%02d-$d%02d $h%02d:$mm%02d"
        return _date
   }
  
}