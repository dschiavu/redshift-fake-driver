import Deps._
import Helpers._

val scala210 = "2.10.7"

scalaVersion := scala210

crossScalaVersions := Seq(scala210, "2.11.12", "2.12.8")

name := "redshift-fake-driver"

licenses += "Apache 2" -> url("https://raw.githubusercontent.com/opt-tech/redshift-fake-driver/master/LICENSE")

organization := "jp.ne.opt"

version := "1.0.15-SNAPSHOT"

scalacOptions ++= Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature"
)

libraryDependencies ++= (compileScope(jawn, jsqlparser, scalaCsv, commonsCompress) ++
  (if (scalaVersion.value.startsWith("2.10")) Nil else compileScope(parser)) ++
  testScope(postgres, h2, s3, sts, scalatest, s3Proxy) ++
  providedScope(postgres, h2, s3, sts))

publishMavenStyle := true
