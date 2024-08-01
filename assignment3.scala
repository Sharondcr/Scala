
object Payroll {

  case class FullTimeEmp(name: String, monthly: Double)
  case class PartTimeEmp(name: String, hourly: Double, hours: Double)
  case class ContractEmp(name: String, fixed: Double)
  case class Freelancer(name: String, fee: Double, projects: Int)

  def calculateSalary(employee: Any): Double = {
    employee match {
      case FullTimeEmp(name, monthly) =>
        monthly

      case PartTimeEmp(name, hourly, hours) =>
        hourly * hours

      case ContractEmp(name, fixed) =>
        fixed

      case Freelancer(name, fee, projects) =>
        fee * projects
    }
  }

  def main(args: Array[String]): Unit = {
    val emp1 = FullTimeEmp("Sankar SD", 5000.0)
    val emp2 = PartTimeEmp("Monalisa", 20.0, 80)
    val emp3 = ContractEmp("Moteswer", 7000.0)
    val emp4 = Freelancer("Mohit", 1500.0, 3)

    println(s"${emp1.name}'s salary: ${calculateSalary(emp1)}")
    println(s"${emp2.name}'s salary: ${calculateSalary(emp2)}")
    println(s"${emp3.name}'s salary: ${calculateSalary(emp3)}")
    println(s"${emp4.name}'s salary: ${calculateSalary(emp4)}")
  }
}