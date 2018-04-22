
import minitest._

object SolutionSuite extends SimpleTestSuite {

  test("should be") {
    val stdin = List(
      "1 2 3 4 5",
      "6 7 8 9 10",
      "1 4"
    )

    
    val stdout = List(
      "2435300.3",
      "26172951168940.8"
    )
    
    assertEquals(Solution.run(stdin), stdout)
  }
}

