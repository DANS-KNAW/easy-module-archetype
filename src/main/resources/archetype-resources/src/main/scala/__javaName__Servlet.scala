#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import nl.knaw.dans.lib.logging.DebugEnhancedLogging
import org.scalatra._

case class ${javaName}Servlet(app: ${javaName}App) extends ScalatraServlet with DebugEnhancedLogging {
  import app._
  import logger._

  get("/") {
    contentType = "text/plain"
    Ok("${name} Service running ...")
  }
}
