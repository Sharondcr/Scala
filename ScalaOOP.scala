//DEFINE CLAss
class Car(val make: String,var model:String,val year:Int){
  def displayInfo():Unit={
    println(s"car info:  $year,$make,$model")
  }
}

object SimpleClass extends App{
  val car = new Car("Toyota","Corella",2019)
  car.displayInfo()

}

