#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import nl.knaw.dans.lib.logging.DebugEnhancedLogging
import org.scalatra._

class ${javaName}Servlet(app: ${javaName}App,
                         version: String) extends ScalatraServlet with DebugEnhancedLogging {

  get("/") {
    contentType = "text/plain"
    Ok(s"${name} Service running (${symbol_dollar}version)")
  }
}
