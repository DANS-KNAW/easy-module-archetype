#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import java.io.{File, PrintWriter}
import java.net.URL

import nl.knaw.dans.easy.license.CommandLineOptions._
import nl.knaw.dans.easy.license.Parameters
import org.apache.commons.configuration.PropertiesConfiguration
import org.rogach.scallop.ScallopConf
import org.slf4j.LoggerFactory

class CommandLineOptions(args: Array[String]) extends ScallopConf(args) {

  import CommandLineOptions.log

  printedName = "${artifactId}"
  val _________ = " " * printedName.length

  version(s"${symbol_dollar}printedName v${symbol_dollar}{Version()}")
  banner(s"""
           |<Replace with one sentence describing the main task of this module>
           |
           |Usage:
           |
           |${symbol_dollar}printedName <synopsis of command line parameters>
           |${symbol_dollar}{_________} <...possibly continued here>
           |
           |Options:
           |""".stripMargin)
  //val url = opt[String]("someOption", noshort = true, descr = "Description of the option", default = Some("Default value"))
  footer("")
}

object CommandLineOptions {

  val log = LoggerFactory.getLogger(getClass)

  def parse(args: Array[String]): Parameters = {
    val opts = new CommandLineOptions(args)
    log.debug("Loading application properties ...")
    val props = {
      val homeDir = new File(System.getProperty("app.home"))
      new PropertiesConfiguration(new File(homeDir, "cfg/application.properties"))
    }
    log.debug("Parsing command line ...")

    // Fill Parameters with values from command line
    val params = Parameters()

    log.debug(s"Using the following settings: ${symbol_dollar}params")

    params
  }
}
