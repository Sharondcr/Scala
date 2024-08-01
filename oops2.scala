//class with companion object using scala
//companion objects used to provide factory method and utility functions
// related to a class 
//companion object will have same name as of class name  and same scope.It resides 
// in the same file
//access to private members of the class or trait
//this can be accessed directly using class without any instance of class

class Circle(val radius: Double) {
  def area: Double = Math.PI * radius * radius
  def circumference: Double = 2 * Math.PI * radius
}
object Circle {
  def apply(radius: Double): Circle = new Circle(radius)
}
object CompanionObj extends App{
  //create instance using companion object 
  var circle = Circle(0.6)
  println(circle.area)
  println(circle.circumference)
}