package ${package}

import java.io.ByteArrayOutputStream

import better.files.File
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ReadmeSpec extends AnyFlatSpec with Matchers with CustomMatchers {

  private val configuration = Configuration(
    version = "my-version",
    serverPort = 12345,
  )
  private val clo = new CommandLineOptions(Array[String](), configuration) {
    // avoids System.exit() in case of invalid arguments or "--help"
    override def verify(): Unit = {}
  }

  private val helpInfo = {
    val mockedStdOut = new ByteArrayOutputStream()
    Console.withOut(mockedStdOut) {
      clo.printHelp()
    }
    mockedStdOut.toString
  }

  private val readMe = File("docs/index.md")
  "options in help info" should "be part of README.md" in {
    val lineSeparators = s"(${ System.lineSeparator() })+"
    val options = helpInfo.split(s"${ lineSeparators }Options:$lineSeparators")(1)
    options.trim should not be empty
    readMe should containTrimmed(options)
  }

  "synopsis in help info" should "be part of README.md" in {
    readMe should containTrimmed(clo.synopsis)
  }

  "description line(s) in help info" should "be part of README.md and pom.xml" in {
    readMe should containTrimmed(clo.description)
    File("pom.xml") should containTrimmed(clo.description)
  }
}
