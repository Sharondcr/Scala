object Workflow{
  def main(args:Array[String]):Unit={
    //function transforms each element of a collection using given transformation
    //1.map function

    val numbers=List(1,2,3,4,5,6,7,8,9)
    val doubleNum = numbers.map(_*2)
    val StringNumber = numbers.map(_+"Number")
    StringNumber.foreach(println)
    val words = List("APPLE","BANANA","GRAPES","ORANGE","MANGO")
    println(words.map(_.length))

    //2.flatmap
    //flattens collection into single collection
    val nestedList = List(List(1,2,3),List(4,5,6),List(7,8,9))
    val k=nestedList.flatMap(identity)
    k.foreach(println)

    val sentences = List("hello scala you are useful","scala you are confusing")
    val words1 = sentences.flatMap(_.split(" "))
    words1.foreach(println)
    //3.Filter
    //selects element from collection that satisfy a given condition
    val shortwords = words1.filter(_.length<=5)

    //4.fold
    //combines elements of collection using a binary operation
    // starting with an initial value
    println(numbers.fold(0)(_+_))
    //5.reduce
    val words2 = List("UST","is","the","best")
    val combination = words2.reduce(_+" "+_)
    combination.foreach(print)
    println(" ")

    //6.FOREACH
    //applies a given procedure to each element of a function
    words2.foreach(word=>println(word.toUpperCase))

    //7.collect applies a partial function to the elements of a collection
    // and returning a new collection
    val oddNumb = numbers.collect{case x if x % 2 != 0 => x}
    val wordsCol = List("APPLE","BANANA","GRAPES","ORANGE","MANGO","PEAR","PINEAPPLE")
    val largeWords = wordsCol.collect({case w if w.length > 5 => w})
    println(largeWords)

    //8.Partition this function will partition collection
    // into 2 parts based on predicate
    val (long,short)=wordsCol.partition(_.length>4)
    println(long)
    println(short)
    //9.groupby groups a collection based on a given function
    val num = List(11,12,13,14,15,16,17,18)
    println(num.groupBy(_%2))

    //10.scan
    // it is similar to fold but it returns a collection of
    // successive cumulative value
    val cumilsum=num.scan(0)(_+_)
    println(cumilsum)


  }
}
