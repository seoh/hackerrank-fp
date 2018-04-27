
import minitest._

object SolutionSuite extends SimpleTestSuite {
  test("should be") {
    assertEquals(Solution.gcd(1, 5), 1) 
    assertEquals(Solution.gcd(10, 15), 5) 
  }
}

