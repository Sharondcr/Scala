import scala.io.StdIn

object assign3{
  def main(args:Array[String]):Unit={
    println("Enter the number of employees:")
    val numEmployees = StdIn.readInt()
    val employees = (1 to numEmployees).map { _ =>
      val line = StdIn.readLine()
      val Array(name, salary) = line.split(" ")
      (name, salary.toInt)
    }

    val totalSalary = employees.map(_._2).sum
    println(s"total salary of employees is $totalSalary")

    val (highSalaryEmployees,
    lowSalaryEmployees) = employees.partition(_._2 > totalSalary * 0.1)

    println("highSalaryEmployees")
    highSalaryEmployees.foreach(println)
    println("lowSalaryEmployees")
    lowSalaryEmployees.foreach(println)

  }
}
