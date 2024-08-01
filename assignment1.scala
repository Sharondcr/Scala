import scala.util.Random

object PasswordCreator {
  def createSecureCode(desiredLength: Int): String = {
    if (desiredLength < 5) {
      "Password length must be at least 5 characters"
    } else {
      val allPossibleChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=[]{}|;:,.<>?"
      val randomizer = new Random()

      var password = ""

      // Ensure password has at least one of each type of character
      password += ('a' to 'z')(randomizer.nextInt(26)).toString
      password += ('A' to 'Z')(randomizer.nextInt(26)).toString
      password += ('0' to '9')(randomizer.nextInt(10)).toString
      password += "!@#$%^&*()_+-=[]{}|;:,.<>?".charAt(randomizer.nextInt(32))

      // Fill the rest of the password with random characters
      for (_ <- 1 to desiredLength - 4) {
        password += allPossibleChars(randomizer.nextInt(allPossibleChars.length))
      }

      // Shuffle the password
      val passwordArray = password.toArray
      randomizer.shuffle(passwordArray)
      passwordArray.mkString("")
    }
  }

  def main(args: Array[String]): Unit = {
    val codeLength = 3
    val generatedSecureCode = createSecureCode(codeLength)
    println(s"Generated Secure Code: $generatedSecureCode")
  }
}