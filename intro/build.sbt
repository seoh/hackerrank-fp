
name := "Introduction"
scalaVersion := "2.12.5"

libraryDependencies in Global ++= Seq(
  "io.monix" %% "minitest" % "2.1.1" % "test"
)
testFrameworks in Global += new TestFramework("minitest.runner.Framework")

lazy val `fp-solve-me-first` = project in file("fp-solve-me-first")
lazy val `eval-ex` = project in file("eval-ex")
lazy val `functions-or-not` = project in file("functions-or-not")
lazy val `lambda-march-compute-the-perimeter-of-a-polygon` = project in file("lambda-march-compute-the-perimeter-of-a-polygon")
lazy val `lambda-march-compute-the-area-of-a-polygon` = project in file("lambda-march-compute-the-area-of-a-polygon")
