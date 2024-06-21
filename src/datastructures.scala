import scala.collection.immutable.Map

object datastructures{
  def main(args : Array[String]):Unit = {
    val fruits: List[String] = List("apple", "oranges", "watermelon", "grapes", "guava")
//    println("First Element : " + fruits.head)
//    println("Last Element : " + fruits.tail)
//    println(fruits.last)

    val empty: List[Nothing] = List()
    val List2 = 10::20::30::40::Nil

    //create a list buffer of type mutable
    import scala.collection.mutable.ListBuffer
    var cities = new ListBuffer[String]()
    cities += "Thiruvananthapuram"
    cities += ("Mumbai","Delhi","Pune")
    cities -= "Mumbai"
//    println(cities)
//    cities.toList
//    println(cities.toList)


    //Array
    var arraydata = Array("apple", "oranges", "watermelon", "grapes", "guava")
//    arraydata.foreach(println)
    //print all values
//    println(arraydata.mkString(","))
//    arraydata(0) = "Mango"
//    println(arraydata.mkString(","))

    //Delare an empty array
    val arr1=new Array[String](10)
    //Decalre a 2-Dim Array
    val arr2=Array.ofDim[Int](2,2)
    arr2(0)(0)= 234
    arr2(0)(1)= 934
    arr2(1)(0)= 274
    arr2(1)(1)= 534
    //print the array
    val flattenArr : Array[Int] = arr2.flatten

//    println(flattenArr.mkString(","))

  //Set Collection:Immutable Collection
  //Hash set:Mutable Collection
  val set1:Set[String] = Set()
    val set_2 = Set("apple", "oranges", "watermelon", "grapes", "guava")
    import scala.collection.mutable.HashSet
    var mutableset = Set("apple","orange","watermelon","grapes","guava")
    mutableset +="blueberry"
    mutableset -="apple"

    //Tuple Declaration
    //in scala tuple is fixed size
    val tuple_1 = (10,20,30,40,50,60,70,80)
    // tuple_1._1 = "String"  update will provide error
//    println(tuple_1._5)individual value

    //map in scala is a key-value pair
    //each key is unique
    //it is similar to dictionary in py

//    import scala.collection.immutable.Map
    //Empty variable Declaration
//    val MapVAr:Map[String,Int]=Map()
//    var mapVAr1=Map("ust1001"-> "Sandeep","ust1002"->"Midhun","ust1003"->"vinesh","ust1004"->"Adinan")
//    println(mapVAr1.contains("ust1003"))
//    println(mapVAr1.get("ust1002"))
//    println(mapVAr1.keys)
//    println(mapVAr1.values)
    //Declare mutable map data type
//    import scala.collection.mutable.Map
//    val mapVAr1 = Map("ust1001" -> "Sandeep", "ust1002" -> "Midhun", "ust1003" -> "vinesh", "ust1004" -> "Adinan")
//    mapVAr1("UST1001")="Rohit"
//    mapVAr1+=("ust1005" -> "Siva")
    //Iterators in Scala Programming
    //Iterators in scala represent a sequence of element that allows you to a collection sequentially
    val myList = List(28,38,40,50,60,70,80,90)
    val iter = myList.iterator
    //Methods of iterator to check if there is more elements (hasNext())
    //(.hasNext(),next() - to retrieve next value
    //.remove() - to remove elements from mutable iterators
//    println(iter.next())

    //Lazy Initialization using scala
    lazy val donuts: Int = 100
//    println(donuts * 5)
    // lazy can't be used with var
    // lazy var donuts_1:Int = 20


  }
}


