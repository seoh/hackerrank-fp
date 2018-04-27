
name := "Recursion"
scalaVersion := "2.12.5"

libraryDependencies in Global ++= Seq(
  "io.monix" %% "minitest" % "2.1.1" % "test"
)
testFrameworks in Global += new TestFramework("minitest.runner.Framework")

lazy val `functional-programming-warmups-in-recursion---gcd` = project in file("functional-programming-warmups-in-recursion---gcd")
lazy val `pascals-triangle` = project in file("pascals-triangle")
