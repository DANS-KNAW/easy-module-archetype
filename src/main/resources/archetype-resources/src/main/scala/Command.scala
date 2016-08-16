#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import org.slf4j.LoggerFactory
import ${package}.{CommandLineOptions => cmd}

object Command {
  val log = LoggerFactory.getLogger(getClass)

  def main(args: Array[String]): Unit = {
    log.debug("Starting command line interface")
    implicit val ps = cmd.parse(args)

    // Here, pass the parameters to the main application logic (possibly to an Akka actor).
  }
}
