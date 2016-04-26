#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import java.io.{File, PrintWriter}
import java.net.URL

import org.rogach.scallop.ScallopConf

class CommandLineOptions(args: Array[String]) extends ScallopConf(args) {
  printedName = "${artifactId}";
  val _________ = " " * printedName.size

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

  def parse(args: Array[String]): Parameters = {
    val opts = new CommandLineOptions(args)
    // Fill Parameters with values from command line
    Parameters()
  }
}
