
import minitest._

object SolutionSuite extends SimpleTestSuite {
  test("should be") {
    /**
     * stdin
     * ```
     * 2
     * 3
     * ```
     *
     * stdout
     * ```
     * 5
     * ```
     */
    assertEquals(Solution.run(List("2", "3")), List("5"))
  }
}

