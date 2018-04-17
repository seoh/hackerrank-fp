
name := "Introduction"
scalaVersion := "2.12.5"

libraryDependencies in Global ++= Seq(
  "io.monix" %% "minitest" % "2.1.1" % "test"
)
testFrameworks in Global += new TestFramework("minitest.runner.Framework")

lazy val `fp-solve-me-first` = project in file("fp-solve-me-first")
