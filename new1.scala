object ATMCombinations {
  def atmCombinations(X: Int, Y: Int, Z: Int, XX: Int, YY: Int, ZZ: Int, amount: Int): List[List[(Int, Int)]] = {
    val notes = List(2000, 500, 100, 50, 20, 10)
    val counts = List(X, Y, Z, XX, YY, ZZ)

    def findCombinations(remainingAmount: Int, noteIndex: Int, currentCombination: List[(Int, Int)]): List[List[(Int, Int)]] = {
      if (remainingAmount == 0) List(currentCombination)
      else if (noteIndex >= notes.length) List()
      else {
        val maxNotes = math.min(remainingAmount / notes(noteIndex), counts(noteIndex))
        (0 to maxNotes).flatMap { i =>
          findCombinations(
            remainingAmount - i * notes(noteIndex),
            noteIndex + 1,
            currentCombination :+ (notes(noteIndex), i)
          )
        }.toList
      }
    }

    findCombinations(amount, 0, List())
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
    println("Enter the amount to withdraw: ")
    val amount = scala.io.StdIn.readInt()

    val combinations = atmCombinations(X, Y, Z, XX, YY, ZZ, amount)

    if (combinations.isEmpty) {
      println("No combination of notes can tender the requested amount.")
    } else {
      combinations.foreach { combination =>
        println(combination.map { case (note, count) => s"$note INR notes -> $count" }.mkString(", "))
      }
    }
  }
}
