import scala.io.Source

class FileAnalyzer(filePath: String) {
  private val fileContent: String = {
    val source = Source.fromFile(filePath)
    val content = source.getLines().mkString("\n")
    source.close()
    content
  }

  def loadFile(): String = fileContent

  def wordCount(): Int = {
    if (fileContent.trim.isEmpty) 0
    else fileContent.split("\\s+").length
  }

  def lineCount(): Int = {
    if (fileContent.trim.isEmpty) 0
    else fileContent.linesIterator.size
  }

  def characterCount(): Int = {
    if (fileContent.trim.isEmpty) 0
    else fileContent.length
  }

  def averageWordLength(): Double = {
    val words = fileContent.split("\\s+").filter(_.nonEmpty)
    if (words.isEmpty) 0.0
    else words.map(_.length).sum.toDouble / words.length
  }

  def mostCommonStartingLetter(): Option[Char] = {
    val words = fileContent.split("\\s+").filter(_.nonEmpty)
    if (words.isEmpty) None
    else {
      val startingLetters = words.map(_.toLowerCase.head)
      val letterCounts = startingLetters.groupBy(identity).mapValues(_.length)
      Some(letterCounts.maxBy(_._2)._1)
    }
  }

  def wordOccurrences(word: String): Int = {
    val pattern = s"\\b${java.util.regex.Pattern.quote(word)}\\b"
    pattern.r.findAllIn(fileContent.toLowerCase).length
  }
}

object FileAnalyzerApp extends App {
  val filePath = "C:\\Users\\Administrator\\IdeaProjects\\ScalaBasics\\src\\main\\scala\\scala.txt"
  val analyzer = new FileAnalyzer(filePath)


  println(s"File loaded:\n${analyzer.loadFile()}\n")
  println(s"Word Count: ${analyzer.wordCount()}")
  println(s"Line Count: ${analyzer.lineCount()}")
  println(s"Character Count: ${analyzer.characterCount()}")
  println(f"Average Word Length: ${analyzer.averageWordLength()}%.2f")
  println(s"Most Common Starting Letter: ${analyzer.mostCommonStartingLetter().getOrElse("No words found")}")
  val wordToSearch = "scala"
  println(s"Occurrences of '$wordToSearch': ${analyzer.wordOccurrences(wordToSearch)}")
}
