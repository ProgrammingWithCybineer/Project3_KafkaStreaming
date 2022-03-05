class ProductID {
    private var id = 0

    def getNum(): Int = {
        var randomNum = scala.util.Random
        id = randomNum.nextInt(15000)
        return id
    }

// if product = "a", then product starts with 1
// if product = "b", then product starts with 2
// how many place holders? 100 items, 25 categories?
// 

}
// © 2022 GitHub, Inc.
// Terms
// Priv