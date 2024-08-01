import scala.collection.mutable.ListBuffer

object DataStructures {
  def main(args: Array[String]): Unit = {
    val fruits: List[String] = List("apple", "orange", "banana", "mango")
    println("first element: " + fruits.head)
    println("value excluding element 1: " + fruits.tail)
    println("last element: " + fruits.last)

    val List1 = List("Hadoop", "Spar", "Flume", "Pyspark", 100, true, 3.82783)
    println(List1)
    println(fruits.getClass)
    println(List1.getClass)

    val emptyList: List[Nothing] = List()
    //list declaration
    val List2 = 10 :: 20 :: 30 :: 40 :: Nil

    //create a list buffer of type mutable
    var cities = new ListBuffer[String]()
    cities += "Trivandrum"
    cities += "Kochi"
    cities += "Wayanad"
    cities += ("Mumbai", "Delhi", "Pune")
    cities -= "Mumbai"
    println(cities)
    cities.toList //typecasting in scala is done by to and datatype function

    //arrays are mutable fixed size collection of data structure
    //array is homogenous
    val arrayData = Array("apple", "orange", "mango", "grapes", "guava", "banana")
    //    arrayData.foreach(println)
    println(arrayData.mkString(", "))
    //though the value is immutable array written as val but as an
    // array is mutable hence we can change
    arrayData(0) = "lychee"
    println(arrayData.mkString(", "))

    //declare an empty array
    //1D
    val array_1 = new Array[String](10)
    //2D
    val arr_2 = Array.ofDim[Int](2, 2)
    arr_2(0)(0) = 235
    arr_2(0)(1) = 345
    arr_2(1)(0) = 999
    arr_2(1)(1) = 222
    //print the array
    val flattenArray: Array[Int] = arr_2.flatten
    println(flattenArray.mkString(", "))
    //set collection:immutable collection
    //HashSet - mutable
    val set_1: Set[String] = Set()
    val set_2 = Set("apple", "mango", "grapes", "guava", "orange")
    import scala.collection.mutable.Set
    val mutableSet = Set("apple", "mango", "orange")
    mutableSet += "blueberry"
    mutableSet -= "apple"

    //tuples - immutable
    //in scala tuple is fixed size ,can store multiple datatypes together
    val tuple_1 = (10, 20, 30, 40, 50, 60, 70, 80, 90)
    println(tuple_1._1)

    //mapping
    //collection of key value pair

    //immutable map
    //    import scala.collection.immutable.Map
    //    var MapVar: Map[String,Int] = Map()
    //    var MapVar1 = Map("UST281750" -> "Bhagya","UST281756" -> "Motesh",
    //      "UST281759"->"Sankar","UST281755"->"Monalisa")
    //    println(MapVar1.contains("UST281755"))
    //    println(MapVar1.get("UST281756"))
    //    println(MapVar1.keys)
    //    println(MapVar1.values)
    //mutable maps
    import scala.collection.mutable.Map
    val mutableVar = Map("UST281750" -> "Bhagya", "UST281756" -> "Motesh",
      "UST281759" -> "Sankar", "UST281755" -> "Monalisa")
    mutableVar("UST281755") = "Alok"

    mutableVar += ("UST281758" -> "Alok")

    //iterators in scala
    //An iterator in scala represent a sequence of element that allows u to
    // traverse through a collection sequentially
    val myList = List(20, 30, 40, 50, 60, 70, 80, 90)
    val iter = myList.iterator
    //methods of iterator to check if there is more element (hasNext)
    //(.hasNext(),.next() to retrieve value
    // .remove() to remove elements from mutable iterators
    println(iter.next())
    //lazy initialization of variable cant be used with var
    lazy val donuts: Int = 100
    println(donuts * 5)


  }
}
