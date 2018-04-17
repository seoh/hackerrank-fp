echo "lazy val \`$1\` = project in file(\"$1\")" >> build.sbt
mkdir -p "$1"/src/{main,test}/scala
echo "
object Solution {

  def main(args: Array[String]): Unit =
    println(run(io.Source.stdin.getLines.toList))

  def run(inputs: List[String]): List[String] = ???
}
" > "$1"/src/main/scala/Solution.scala

echo "
import minitest._

object SolutionSuite extends SimpleTestSuite {
  test(\"should be\") {
    assertEquals(run(List()), List()) 
  }
}
" > "$1"/src/test/scala/SolutionTest.scala

