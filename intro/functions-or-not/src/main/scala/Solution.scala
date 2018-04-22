
object Solution {

  def main(args: Array[String]): Unit =
    println(run(io.Source.stdin.getLines.toList).mkString("\n"))

  def run(inputs: List[String]): List[String] = {
    val nOfTest :: rawTests = inputs
    val tests: List[List[(Int, Int)]] =
      extractTest(rawTests).map(_.map(line => {
        val Array(x, y) = line.split(' ')
        (x.toInt, y.toInt)
      }))

    tests.map(solve)
  }

  def extractTest(raw: List[String]): List[List[String]] = raw match {
     case n :: rest => rest.take(n.toInt) :: extractTest(rest.drop(n.toInt))
     case _ => Nil
  }

  def solve(input: List[(Int, Int)]): String =
    if(input.groupBy(_._1).values.forall(_.length == 1)) "YES"
    else "NO"
}

