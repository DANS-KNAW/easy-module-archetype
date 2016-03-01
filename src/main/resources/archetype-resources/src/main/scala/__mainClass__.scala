#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.slf4j.LoggerFactory

object ${mainClass} {
  val log = LoggerFactory.getLogger(getClass)

  def main(args: Array[String]): Unit ={
    log.info("Finished")
  }
}
