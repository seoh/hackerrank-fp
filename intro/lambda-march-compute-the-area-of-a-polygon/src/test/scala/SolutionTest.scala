
import minitest._

object SolutionSuite extends SimpleTestSuite {
  test("should be") {
    val stdin: List[String] = List(
      "4",
      "0 0",
      "0 1",
      "1 1",
      "1 0"
    )
    val stdout: List[String] = List(
      "1"
    )

    assertEquals(Solution.run(stdin), stdout) 
  }
}

