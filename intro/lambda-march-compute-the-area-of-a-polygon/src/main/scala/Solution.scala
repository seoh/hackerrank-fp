object Solution {

  implicit class IntPairOps(pair: (Int, Int)) {
    def toDouble: (Double, Double) = (pair._1.toDouble, pair._2.toDouble)
  }

  def main(args: Array[String]): Unit =
    println(run(io.Source.stdin.getLines.toList).mkString("\n"))

  def run(inputs: List[String]): List[String] = {
    val n :: rawTests = inputs
    val tests = rawTests.take(n.toInt).map(_.split(' ') match {
      case Array(x, y) => (x.toInt, y.toInt)
    })

    List(solve(tests).toString)
  }

  // https://en.wikipedia.org/wiki/Shoelace_formula
  def solve(inputs: List[(Int, Int)]): Double = 
    math.abs((inputs zip (inputs.tail ++ List(inputs.head))).map({
      case ((x1, y1), (x2, y2)) => x1*y2 - y1*x2
    }).sum) * 0.5
  

  /**
   * my first try. but it was useless
   *
   * success: 0, 1, 2, 4, 5, 6, 8, 10, 12, 14, 16, 18, 20, 22
   * failure: 3, 7, 9, 11, 13, 15, 17, 19, 21, 23
   */
  def solve2(inputs: List[(Int, Int)]): Double = {
    val areaWithMid = area(inputs.head) _
    val h :: t = inputs.tail

    t.foldLeft((0.0, h))({
      case ((acc, a), b) => (acc + areaWithMid(a, b), b)
    })._1
  }

  def middle(a: (Int, Int), b: (Int, Int)): (Double, Double) =
    ((a._1 + b._1) / 2.0, (a._2 + b._2) / 2.0)

  /**
   * https://en.wikipedia.org/wiki/Distance_from_a_point_to_a_line
   *
   * a point P 
   * given points P1(x1, y1), P2(x2, y2)
   *
   * a = P1.y - P2.y
   * b = P2.x - P1.x
   * c = P1.x*P2.y - P2.x*P1.y
   * d = |a*x0 + b*y0 + c| / sqrt(a*a + b*b)
   */
  def area(p: (Int, Int))(p1: (Int, Int), p2: (Int, Int)): Double = {
    val a = p1._2 - p2._2
    val b = p2._1 - p1._1
    val c = p1._1*p2._2 - p2._1*p1._2

    val d = math.abs(a*p._1 + b*p._2 + c) / math.sqrt(a*a + b*b)

    d * distance(p1.toDouble, p2.toDouble) / 2
  }

  def distance(a: (Double, Double), b: (Double, Double)): Double =
    math.sqrt(math.pow(a._1 - b._1, 2) + math.pow(a._2 - b._2, 2))
}

