import scala.io.Source

object WordFrequencer {

  def main(args: Array[String]): Unit = {
    val filePath = "C:\\Users\\Administrator\\IdeaProjects\\ScalaBasics\\src\\main\\scala\\scala.txt"
    val topN = 10

    val topWords = getTopWords(filePath, topN)
    println(s"Top $topN most frequent words:")
    topWords.foreach { case (word, count) =>
      println(s"$word -> $count")
    }
  }

  def getTopWords(filePath: String, topN: Int): List[(String, Int)] = {
    val fileContent = Source.fromFile(filePath).getLines().mkString(" ")

    val wordCountMap = fileContent
      .toLowerCase()
      .split("\\W+")
      .groupBy(identity)
      .mapValues(_.length)

    wordCountMap.toList.sortBy(-_._2).take(topN)
  }
}
