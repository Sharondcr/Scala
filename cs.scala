import scala.io.StdIn

object cs {
  def main(args: Array[String]): Unit = {
    //example of if else
    //    println("enter a number")
    //    val x1 = StdIn.readLine().toInt
    //    if (x1 > 0){
    //      print("value is positive")
    //    }
    //    else if (x1<0){
    //        print("value is negative")
    //    }
    //    else{
    //      println("value is zero")
    //    }
    //using if else as a expression
    //    val x2 = StdIn.readLine().toInt
    //    val output = if(x2%2 == 0) "even" else "odd"
    //    println(output)

    //example 3 while loop
    //    var i = 1
    //    while(i <= 5){
    //      println(s"value of i is: $i")
    //      i += 1
    //    }
    //example 4 for loop
    //    val List_1 = List("Kerala","UST281750",22,"CSE",78.997)
    //    for(value <- List_1){
    //      print(value)
    //    }
    //example 5 generate a collection of even numbers
    //val numbers = (2 to 100).toList
    //    val even = for {
    //      num <- numbers
    //      if num % 2 == 0
    //    } yield num
    //    //yield in scala is used to generate an new collection from an existing one
    //    println(even)
    //    val primes = for{
    //      num <- 2 to 100
    //      if (2 until (num/2)).forall(x => num % x!=0)
    //    }yield num
    //    println(primes.mkString(", "))

    //task 1 processing and filtering data
    //sample record = (product name,unit price,discount,quantity)
    //1. filter out products that have price > $50
    //2. calculate total cost of each product
    //3.print name of product that has exceeded total cost > $ 300
    val ListProd = List(
      ("Shampoo", 55, 0.4, 2),
      ("soap", 40, 0.05, 3),
      ("comb", 60, 0.15, 1),
      ("powder", 35, 0.01, 2)
    )
    //1. filter out products that have price > $50
    val expensiveProd = for {
      item <- ListProd
      if item(1) > 50
    } yield item
    println(expensiveProd)

    //2. calculate total cost of each product
    //3.print name of product that has exceeded total cost > $ 300
    for ((name, price, discount, quantity) <- ListProd) {
      val totalCost = (price * quantity) - (discount * price)
      println(s"the total cost of $name is $totalCost")
    }

    for ((name, price, discount, quantity) <- ListProd) {
      val totalCost = (price * quantity) - (discount * price)
      if (totalCost > 100) {
        println(s"the total cost of $name has exceeded 100")
      }
    }
  }
}
