import scala.collection.mutable.ArrayBuffer
object DataStructureMethods {
  def main(args: Array[String]): Unit = {
    val list_1 = List("Apple", "Mango", "Orange", "Grapes")
    //    val list_2 = List()
    //Basic operations
    val first = list_1.head
    val last = list_1.last
    val rest = list_1.tail
    val second = list_1(1)
    //to check if collection is empty
    //    println(list_2.isEmpty)
    //size of collection
    val len = list_1.length
    //println(len)
    //adding and removing or dropping values from list
    val list_2 = List(1, 2, 3, 4)
    val newList = 0 :: list_2
    val appendList = list_2 :+ 9
    //println(appendList)
    // concatenation of list
    val concat = list_2 ::: List(9, 10, 11, 12)
    val concatenated = list_2 ++ List(13, 29, 30, 8)
    //println(concat)
    //println(concatenated)
    //removing first 3 values from list concatenated
    //println(concatenated.drop(3))
    //remove by value
    val updatedList = concat.filter(_ != 10)
    //println(updatedList)
    //removes said value or difference from list
    val up1 = concat.diff(List(9, 1, 12))
    //println(up1)

    //Transforming Lists
    list_2.map(_ * 2)
    val filt = list_2.filter(_ % 2 == 0)
    //print(filt)
    val nestedList = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9))
    //when you pass identity to flatMap, it's like saying:
    //"Take each element of the list (which is a list itself), and return it as is."
    val flatList = nestedList.flatMap(identity)
    //println(flatList)
    //to do aggregation in list
    // this takes two two numbers and reduces to single sum
    val sum = flatList.reduce(_ + _)
    val mul = flatList.reduce(_ * _)
    //println(sum)
    //println(mul)
    //slicing and subset
    //println("take 3 elements from list")
    //println(list_1.take(3))
    //println(list_1.takeRight(3))
    //dropping last two values
    //println(flatList.dropRight(2))
    //slicing
    //println("slicing")
    //println(flatList)
    //println(flatList.slice(1,4))

    //converting list to other datatypes using to method
    //converting list to map
    val listOfTuples = List(("UST1001", "Bhagya"), ("UST1002", "Sankar"),
      ("ust1003", "Moteswer"))
    val map = listOfTuples.toMap
    //println(map)
    //zip in scala
    //println("zipping list")
    val list_3 = list_1.zip(list_2)
    //println(list_3)
    //unzip
    //println("unzip")
    val (fruits, numbers) = list_3.unzip
    //println(fruits)
    //println(numbers)

    //sets
    //    println("                      SETS AND SETS METHOD            ")
    val set1 = Set(1, 2, 3, 4, 5, 6, 7)
    val set2 = Set("Apple", "Mango", "Grapes", "Banana", "Watermelon", "Guava", "Orange")
    println(set1.contains(3))
    set1 + 9
    set1 - 7
    val setA = Set(10, 20, 30, 40)
    val setB = Set(50, 60, 70, 30, 40)
    val union = setA union setB
    val intersect = setA intersect setB
    val diff = setA diff setB
    //    println(setA)
    //    println(setB)
    //    println(union)
    //    println(intersect)
    //    println(diff)

    //SUBSET CHECK
    setA.subsetOf(setB)
    //
    //    println("filter,map,reduce,display all elements on set,foreach")
    //
    //    val filter = setA.filter(_%10==0)
    //    println(filter)
    //    val mapset = setA.map(_*10)
    //    println(mapset)
    //    val reduceset = setB.reduce(_ + _)
    //    println(reduceset)
    //    println(setA.mkString(","))
    //    println(setA.foreach(println))
    println("      ARRAYS   ")
    val array1 = Array("Kochi", "Trivandrum", "Varkala", "Thrissur")
    val array2 = Array(1, 2, 3, 4, 5, 6, 7, 8)
    val emptyArray = Array[Int]()
    array2(0) = 17
    array1.length
    array1.isEmpty
    //arrays are by default fixed size this addition cannot be done
    //array2 += 9
    //so we use arraybuffer
    val arrayBuffer = ArrayBuffer(1, 2, 3, 4, 5, 6, 7)
    arrayBuffer += 8
    arrayBuffer -= 4
    arrayBuffer.map(_ * 4)
    val newArray = arrayBuffer.toArray
    //Nested array
    val nestedArray = Array(Array(1, 2, 3), Array(4, 5, 6), Array(7, 8))
    val flat1 = nestedArray.flatten
    println("flattened array")
    flat1.foreach(print)
    println(flat1.slice(0, 4).mkString("Array(", ", ", ")"))
    //to do slicing .take,.drop etc can be implemented here as well
    println(array2.sorted.mkString("Array(", ", ", ")"))
    val rev = array2.reverse
    rev.foreach(println)
    // group by in scala
    println("*" * 60)
    var city = Array("Kochi", "Trivandrum", "Varkala", "Thrissur", "Wayanad")
    val groupbyLen = city.groupBy(_.length)
    val groupbyFirstChar = city.groupBy(_.charAt(0))
    val groupbyOddEven = flat1.groupBy(num => if (num % 2 == 0) "even" else "odd")
    groupbyFirstChar.foreach { case (char, cities) =>
      println(s"Cities starting with $char: ${cities.mkString(", ")}")
    }
    groupbyOddEven.foreach {
      case (key, value) => println(s"$key:${value.mkString(", ")}")
    }
    //MAP
    val immutablemap = Map("a"->1,"b"->2,"c"->3,"d"->4,"e"->5)
    import scala.collection.mutable
    val mutablemap = mutable.Map("a"->1,"b"->2,"c"->3,"d"->4,"e"->5)
    immutablemap.contains("a")
    println(immutablemap("a"))
    val mapA=Map("a"->1,"b"->2,"c"->3)
    val mapB=Map("a"->4,"e"->5,"f"->6,"g"->7)
    val mergedMap = mapA ++ mapB
    println(mergedMap)

    //transform keys and values
    val incrementValue = immutablemap.mapValues(_+1)
    val transform = immutablemap.map{case(k,v)=>(k.toUpperCase,v)}
    incrementValue.foreach{
      case(key,value)=>println((s"$key->$value"))
    }
  }
}