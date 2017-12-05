package ${package}

import java.io.{ ByteArrayOutputStream, File }
import java.nio.file.Paths

import org.scalatest._

class ReadmeSpec extends FlatSpec with Matchers with CustomMatchers {

  private val clo = new CommandLineOptions(Array[String](), Configuration(Paths.get("src/main/assembly/dist"))) {
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

  "options in help info" should "be part of README.md" in {
    val lineSeparators = s"(${ System.lineSeparator() })+"
    val options = helpInfo.split(s"${ lineSeparators }Options:$lineSeparators")(1)
    options.trim should not be empty
    new File("README.md") should containTrimmed(options)
  }

  "synopsis in help info" should "be part of README.md" in {
    new File("README.md") should containTrimmed(clo.synopsis)
  }

  "description line(s) in help info" should "be part of README.md and pom.xml" in {
    new File("README.md") should containTrimmed(clo.description)
    new File("pom.xml") should containTrimmed(clo.description)
  }
}
