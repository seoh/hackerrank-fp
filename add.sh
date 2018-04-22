echo "lazy val \`$1\` = project in file(\"$1\")" >> build.sbt
mkdir -p "$1"/src/{main,test}/scala
echo "
object Solution {

  def main(args: Array[String]): Unit =
    println(run(io.Source.stdin.getLines.toList).mkString(\"\n\")

  def run(inputs: List[String]): List[String] = ???
}
" > "$1"/src/main/scala/Solution.scala

echo "
import minitest._

object SolutionSuite extends SimpleTestSuite {
  test(\"should be\") {
    val stdin: List[String] = List(
    )
    val stdout: List[String] = List(
    )

    assertEquals(Solution.run(stdin), stdout) 
  }
}
" > "$1"/src/test/scala/SolutionTest.scala

