
object Solution {

  def main(args: Array[String]): Unit = 
    println(run(io.Source.stdin.getLines.toList).mkString("\n"))

  /*
   * @arg inputs sorta stdin
   * @return sorta stdout
   */
  def run(inputs: List[String]): List[String] =
    List(inputs.map(_.toInt).sum.toString)
}

