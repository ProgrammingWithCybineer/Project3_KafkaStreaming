class ID{

    def idGen(): String = {
        val rand = new scala.util.Random
        var idOne = ""
        var idTwo = ""

        for(i <- 0 to 5){
           idOne += 1 + rand.nextInt(( 9 - 1) + 1)
           idTwo += 1 + rand.nextInt(( 9 - 1) + 1)
            
        }

        return s"$idOne,$idTwo"
    }
    def idGen(digits: Int): String = {
        val rand = new scala.util.Random
        var num = ""

        for(i <- 0 to digits-1){
           num += 1 + rand.nextInt(( 9 - 1) + 1)            
        }
        return num
    }
    //Takes in Category as a string [1st 2 digits]
    def idGen(cats: String): String = {
        var pt1 = ""
        var pt2 = ""

        val rand = new scala.util.Random
        for(i <- 0 to 1){
           pt1 += 1 + rand.nextInt(( 9 - 1) + 1)
            
        }
        for(i <- 0 to 1){ 
           pt2 += 1 + rand.nextInt(( 9 - 1) + 1)
            
        }
        return cats + pt1 + pt2
    }

}