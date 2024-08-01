import scala.io.Source

object assign2 {
  def main(args: Array[String]): Unit = {
    val filePath = "C:\\Users\\Administrator\\Desktop\\StatewiseGDP.csv"
    val source = Source.fromFile(filePath).getLines().drop(1).map(_.split(",").map(_.trim)).toArray

    // Task 1: Find state with highest GDP contribution
    val maxGdp = source.map(_(1).toInt).max
    val maxGdpState = source.find(_(1).toInt == maxGdp).get
    println(s"State with highest GDP contribution: ${maxGdpState(0)} " +
      s"with GDP: ${maxGdpState(1)}")

    // Task 2: Find average GDP per capita
    val averageGdpPerCapita = source.map(_(2).toDouble).sum / source.length
    println(s"Average GDP per capita: ${averageGdpPerCapita}")

    // Task 3: Total GDP
    val totalGdp = source.map(_(1).toDouble).sum
    println(s"Total GDP: ${totalGdp}")
  }
}
