object ScalaDatatypes{
  def main(args:Array[String]):Unit={
    val intNum: Int = 20
    val longNum: Long = 123456789L
    val shortNum: Short = 32765
    val byteNum:Byte = 123
    val FloatingNum:Float=3.14f
    val doubleNum:Double=3.1412359873498264

    val stringVar:String = "HELLO SCALA"
    val charVar:Char='A'

    val unitValue:Unit=()
    var boolVar:Boolean=true
    var intVar:Int=1234
    println(s"Integer :$intNum")
    println(s"long number :$longNum")
    println(s"floating :$FloatingNum")
    println(s"double :$doubleNum")
    println("Boolean:"+boolVar)
    println("Integer variable:"+intVar)
    //updating item
    intVar = intVar + 1000
    println("Updated Value :"+intVar)



  }
}