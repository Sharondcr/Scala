////are special classes in scala programming that are immutable and are compared by value
////they are ideal for use in patter matching
// Special classes in Scala programming that are immutable and are compared by value
// They are ideal for use in pattern matching
case class Person(name: String, salary: Int)

object CaseClass extends App {
  val person1 = Person("Person1", 39000)
  val person2 = Person("Person2", 56780)

  println(person1)
  println(person2)

  val person3 = person1.copy(salary = 2500)
  println(person3)

  // Pattern matching
  person1 match {
    case Person(name, salary) => println(s"name: $name, salary: $salary")
  }
}