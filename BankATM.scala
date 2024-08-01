object BankATM {
  def atmCombin(X: Int, Y: Int, Z: Int, XX: Int, YY: Int, ZZ: Int, XYZ: Int, Amount: Int): List[List[(Int, Int)]] = {
    val notes = List(2000, 500, 100, 50, 20, 10, 5)
    val count = List(X, Y, Z, XX, YY, ZZ, XYZ)

    def findComb(remaining: Int, noteIndex: Int, currentComb: List[(Int, Int)]): List[List[(Int, Int)]] = {
      if (remaining == 0) List(currentComb)
      else if (noteIndex >= notes.length) List()
      else {
        val maxNotes = math.min(remaining / notes(noteIndex), count(noteIndex))
        (0 to maxNotes).flatMap { i =>
          findComb(
            remaining - i * notes(noteIndex),
            noteIndex + 1,
            currentComb :+ (notes(noteIndex), i)
          )
        }.toList
      }
    }

    findComb(Amount, 0, List())
  }

  def main(args: Array[String]): Unit = {
    println("Enter the number of 2000 INR notes: ")
    val X = scala.io.StdIn.readInt()
    println("Enter the number of 500 INR notes: ")
    val Y = scala.io.StdIn.readInt()
    println("Enter the number of 100 INR notes: ")
    val Z = scala.io.StdIn.readInt()
    println("Enter the number of 50 INR notes: ")
    val XX = scala.io.StdIn.readInt()
    println("Enter the number of 20 INR notes: ")
    val YY = scala.io.StdIn.readInt()
    println("Enter the number of 10 INR notes: ")
    val ZZ = scala.io.StdIn.readInt()
    println("Enter the number of 5 INR notes: ")
    val XYZ = scala.io.StdIn.readInt()
    println("Enter the amount to withdraw: ")
    val amount = scala.io.StdIn.readInt()

    val combinations = atmCombin(X, Y, Z, XX, YY, ZZ, XYZ, amount)
    if (combinations.isEmpty) {
      println("No combination of notes can tender the requested amount.")
    } else {
      combinations.foreach { combination =>
        println(combination.map { case (note, count) => s"$note -> $count" }.mkString(", "))
      }
    }
  }
}