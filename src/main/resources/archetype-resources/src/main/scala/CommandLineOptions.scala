#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import org.rogach.scallop.{ScallopConf, ScallopOption, Subcommand, singleArgConverter}

class CommandLineOptions(args: Array[String], configuration: Configuration) extends ScallopConf(args) {
  appendDefaultToDescription = true
  editBuilder(_.setHelpWidth(110))
  printedName = "${artifactId}"
  private val SUBCOMMAND_SEPARATOR = "---\n"
  val description: String = s"""${description}"""
  val synopsis: String =
    s"""
       |  ${symbol_dollar}printedName (synopsis of command line parameters)
       |  ${symbol_dollar}printedName (... possibly multiple lines for subcommands)""".stripMargin

  version(s"${symbol_dollar}printedName v${symbol_dollar}{ configuration.version }")
  banner(
    s"""
       |  ${symbol_dollar}description
       |
       |Usage:
       |
       |${symbol_dollar}synopsis
       |
       |Options:
       |""".stripMargin)
  //val url = opt[String]("someOption", noshort = true, descr = "Description of the option", default = app.someProperty)

  val runService = new Subcommand("run-service") {
    descr(
      "Starts ${name} as a daemon that services HTTP requests")
    footer(SUBCOMMAND_SEPARATOR)
  }
  addSubcommand(runService)

  footer("")
}
