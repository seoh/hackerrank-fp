
object Solution {

  def main(args: Array[String]): Unit =
  //  println(run(io.Source.stdin.getLines.toList).mkString("\n"))
    println(run(List("1")).mkString("\n"))

  def run(inputs: List[String]): List[String] = {
    val n = inputs.head.toInt

    val matrix = new Array[Array[Char]](32).zipWithIndex map {
      case (_, row) => 
        val space = "_" * (31 - row) 
        val marked = "1" * (row * 2 + 1)
        (space + marked + space).toArray
    }

    puncture(n-1, matrix, 0, 64, 0, 33)

    println(matrix.map(_.mkString).mkString("\n"))

    matrix.map(_.mkString).toList
  }

  /**
   * x-axis from start x until end x,
   * y-axis from start y until end y
   */
  def puncture(n: Int, matrix: Array[Array[Char]],
    sx: Int, ex: Int,
    sy: Int, ey: Int): Unit = {

    if(n == 0) return

    val midx = (sx + ex) / 2
    val midy = (sy + ey) / 2

    if(sx == 0 && ex == 64 && midx != 31) throw new Exception
    if(sy == 0 && ey == 33 && midy != 16) throw new Exception

    /**
     * triangle is separated to sector 1 to 4.
     * sector 1, 2, 4 will be quarter triangle and sector 3 will be
     * inverted triangle and replaced to '_'
     */

    val half = midx/2
    puncture(n-1, matrix, sx + half, ex - half, sy, sy + midy) // sect 1.
    puncture(n-1, matrix, sx, midx - 1, midy, ey)              // sect 3.
    puncture(n-1, matrix, midx, ex, midy, ey)                  // sect 4.

    for {
      x <- (sx + half) to (ex - half)
      y <- miny to ey
    } {
      // replace '1' to '_'
    }
  }
}

