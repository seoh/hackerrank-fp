
object Solution {

  def main(args: Array[String]): Unit =
    println(run(io.Source.stdin.getLines.toList))

  def run(inputs: List[String]): List[String] = {
    val (coefs :: pows :: range :: Nil) = inputs
    val cs = coefs.split(' ').map(_.toInt).toList
    val ps = pows.split(' ').map(_.toInt).toList
    val Array(lower, upper) = range.split(' ').map(_.toInt)

    List(
      summation(f, upper, lower, cs, ps).toString, 
      summation(area, upper, lower, cs, ps).toString
    )
  }

  def f(coefs: List[Int], pows: List[Int], x: Double): Double =
    (coefs zip pows).foldLeft(0.0) {
      case (acc, (c, p)) => acc + c * math.pow(x, p)
    }

  def area(coefs: List[Int], pows: List[Int], x: Double): Double =
    math.pow(f(coefs, pows, x), 2) * math.Pi

  def summation(
    func: (List[Int], List[Int], Double) => Double, 
    upper: Int,
    lower: Int,
    coefs: List[Int],
    powers: List[Int]
  ): Double = {
    (lower.toDouble to upper.toDouble by 0.001).map(i =>
        func(coefs, powers, i) * 0.001
    ).sum
  }
}

