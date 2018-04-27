
object Solution {

  def main(args: Array[String]): Unit =
    println(run(io.Source.stdin.getLines.toList).mkString("\n"))

  def run(inputs: List[String]): List[String] = {
    val n = inputs.head.toInt
    val facts = (2 to n).scan(1)(_ * _).toList
    (0 until n).toList map (i => combination(i, facts).mkString(" "))
  }

  /**
   * Combination is representated by `nCr`. It means for given n, r is
   * between 1 and n then result will be n! / r!*(n-r)!. 1! to n! are given 
   * param named factorial.
   */
  def combination(n: Int, factorials: List[Int]): List[Int] = {
    def f(n: Int) = factorials.drop(n-1).head // n!
    val nf = f(n)
    (0 to n).toList map (r => nf/f(r)/f(n-r))
  }
}

