
import minitest._

object SolutionSuite extends SimpleTestSuite {
  test("should be") {
    val stdin = List(
      "2",
      "3",
      "1 1",
      "2 2",
      "3 3",
      "4",
      "1 2",
      "2 4",
      "3 6",
      "4 8"
    )

    val stdout = List(
      "YES",
      "YES"
    )
    assertEquals(Solution.run(stdin), stdout)
  }

  test("shouldnt be") {
    val stdin = List(
      "1",
      "2",
      "1 1",
      "1 2"
    )
    val stdout = List("NO")

    assertEquals(Solution.run(stdin), stdout)
  }
}

