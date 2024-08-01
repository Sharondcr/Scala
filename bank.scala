import scala.io.StdIn

object bank {
  var balance = 0

  def bankingMenu(): Unit = {
    println("welcome!")
    var continue = true
    while (continue) {
      println("1.check balance")
      println("2.Withdraw amount")
      println("3.Deposit")
      println("4.Exit")
      println(" ")
      print("Enter your choice")
      val choice = StdIn.readInt()
      if (choice == 1) {
        println(s"Your current balance is: $balance")
      } else if (choice == 2) {
        println("Enter amount to withdraw: ")
        val amount = StdIn.readInt()
        if (amount > 0) {
          if (amount <= balance) {
            balance -= amount
            println(s"Withdrawal successful. New balance: $balance")
          } else {
            println("Insufficient Balance")
          }
        } else {
          println("amount cannot be negative")
        }
      } else if (choice == 3) {
        println("Enter amount to deposit: ")
        val amount = StdIn.readInt()
        if (amount > 0) {
          balance += amount
          println(s"Deposit successful bank balance is $balance")
        } else {
          println("amount cannot be negative")
        }
      } else if (choice == 4) {
        continue = false
        println("Exiting")
      } else {
        println("Invalid choice")
      }
    }
  }
  def main(args: Array[String]): Unit = {
    bankingMenu()
  }
}
