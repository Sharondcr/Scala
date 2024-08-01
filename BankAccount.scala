class Account(val accountNum:String ,var balance:Double){
  def deposit(amount:Double):Unit = {
    if (amount>0){
      balance +=amount
    }
  }
  def withdraw(amount:Double):Unit = {
    if (amount > 0 && amount<=balance){
      balance -= amount
      println(s"withdraw $amount , new balance $balance")
    }else{
      println("Insufficient funds or invalid account")
    }
  }
  def getBalance:Double = balance
}

object BankApp{
  def main(Args:Array[String]):Unit={
    //create instance of account
    val account1 = new Account("UST12345",45678.0)
    val account2 = new Account("ust45674",67829.0)
    println(s"Account number: ${account1.accountNum},Initial balance: ${account1.balance}")
    account1.deposit(678.0)
    account1.withdraw(3000.0)
    println(s"Final balance : ${account1.getBalance}")
    
  }
}
