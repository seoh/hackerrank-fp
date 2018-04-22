
object Solution {

  def main(args: Array[String]): Unit =
    println(run(io.Source.stdin.getLines.toList).mkString("\n"))

  def run(inputs: List[String]): List[String] = {
    val (n :: rawTests) = inputs
    val tests = rawTests.take(n.toInt).map(_.split(' ') match {
      case Array(x, y) => (x.toInt, y.toInt)
    })

    List(solve(tests).toString)
  }

  def solve(inputs: List[(Int, Int)]): Int = 
    inputs.foldLeft((0.0, inputs.last))({
      case ((acc, a), b) => (acc + distance(a, b), b)
    })._1.toInt


  def distance(a: (Int, Int), b: (Int, Int)): Double =
    math.sqrt( math.pow(a._1 - b._1, 2) + math.pow(a._2 - b._2, 2))
}

