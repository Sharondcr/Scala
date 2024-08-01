// Inheritance - Example demonstrates inheritance where a
//subclass (child class) extends a superclass(Parent class)
class Animal(val name:String){
  def makeSound():Unit={
    println(s"$name makes sound")

  }
}
class Dog(name:String) extends Animal(name){
  override def makeSound():Unit = {
    println(s"$name says woof")
  }
}

object InheritObj extends App{
  val animal = new Animal("Generic Name")
  animal.makeSound()
  val dog = new Dog("Charlie")
  dog.makeSound()
}