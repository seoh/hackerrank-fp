
import minitest._

object SolutionSuite extends SimpleTestSuite {
  test("should be") {
    val stdin: List[String] = List(
      "4"
    )
    val stdout: List[String] = List(
      "1",
      "1 1",
      "1 2 1",
      "1 3 3 1"
    )

    assertEquals(Solution.run(stdin), stdout) 
  }
}

