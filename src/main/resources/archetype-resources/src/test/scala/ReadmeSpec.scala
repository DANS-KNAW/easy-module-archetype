package ${package}

import java.io.{ByteArrayOutputStream, File}

import ${package}.CustomMatchers._

import org.scalatest._
import org.apache.commons.configuration.PropertiesConfiguration

class ReadmeSpec extends FlatSpec with Matchers {
  private val helpInfo = {
    System.setProperty("app.home", "src/main/assembly/dist") // Use the default settings in this test
    val mockApp = new ${javaName}App() {}
    val mockedStdOut = new ByteArrayOutputStream()
    Console.withOut(mockedStdOut) {
      CommandLineOptions(Seq(), mockApp).printHelp()
    }
    mockedStdOut.toString
  }

  "arguments" should "be part of README.md" in {
    val options = helpInfo.replaceAll("\\(default[^)]+\\)","").split("Options:")(1)
    new File("README.md") should containTrimmed(options)
  }

  "synopsis in help info" should "be part of README.md" in {
    val synopsis = helpInfo.split("Options:")(0).split("Usage:")(1)
    new File("README.md") should containTrimmed(synopsis)
  }

  "first banner line" should "be part of README.md and pom.xml" in {
    val description = helpInfo.split("\n")(2)
    new File("README.md") should containTrimmed(description)
    new File("pom.xml") should containTrimmed(s"<description>$description</description>")
  }
}