package ${package}

import java.io.{ByteArrayOutputStream, File}

import ${package}.CustomMatchers._

import org.scalamock.scalatest.MockFactory
import org.scalatest._

class ReadmeSpec extends FlatSpec with Matchers {
  val helpInfo = {
    val props = new PropertiesConfiguration()
    props.setProperty("FILL-IN-PROPERTY-NAME", "FILL-IN-VALUE-TO-APPEAR-AS-DEFAULT-IN-README")
    // Repeat previous line for all configuration properties accessed in CommanlineOptions
    val mockedStdOut = new ByteArrayOutputStream()
    Console.withOut(mockedStdOut) {
      new CommandLineOptions(Array(), props).printHelp()
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