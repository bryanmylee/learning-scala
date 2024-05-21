// Import multiple classes per package
import java.time.format.{DateTimeFormatter, FormatStyle}
import java.time.LocalDate
// Wildcard import
import java.util.Locale._

// It is also possible to inherit Java classes and implement Java interfaces in Scala.

// Java third-party libraries can be installed with `sbt` as dependencies using `build.sbt`.
// Refer to https://docs.scala-lang.org/getting-started/sbt-track/getting-started-with-scala-and-sbt-on-the-command-line.html#adding-a-dependency

object UsingJavaLibraries extends App {
  val now = LocalDate.now
  val df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(FRANCE)
  println(df.format(now))
}
