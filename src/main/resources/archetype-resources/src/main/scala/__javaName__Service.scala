#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import java.net.{URI, URLConnection}
import java.nio.file.{Files, Paths}
import java.util.UUID

import nl.knaw.dans.lib.logging.DebugEnhancedLogging
import org.eclipse.jetty.ajp.Ajp13SocketConnector
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
import org.scalatra._
import org.scalatra.servlet.ScalatraListener

import scala.util.Try

class ${javaName}Service extends ${javaName}App with DebugEnhancedLogging {
  import logger._
  validateSettings()

  private val port = properties.getInt("daemon.http.port")
  private val server = new Server(port)
  private val context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS)
  context.setAttribute(CONTEXT_ATTRIBUTE_APPLICATION, this)
  context.addEventListener(new ScalatraListener())
  server.setHandler(context)
  info(s"HTTP port is $port")

  if (properties.containsKey("daemon.ajp.port")) {
    val ajp = new Ajp13SocketConnector()
    val ajpPort = properties.getInt("daemon.ajp.port")
    ajp.setPort(ajpPort)
    server.addConnector(ajp)
    info(s"AJP port is $ajpPort")
  }

  def start(): Try[Unit] = Try {
    info("Starting HTTP service ...")
    server.start()
  }

  def stop(): Try[Unit] = Try {
    info("Stopping HTTP service ...")
    server.stop()
  }

  def destroy(): Try[Unit] = Try {
    server.destroy()
  }
}

case class ${javaName}Servlet(app: ${javaName}App) extends ScalatraServlet with DebugEnhancedLogging {
  import app._
  import logger._

  get("/") {
    contentType = "text/plain"
    Ok("")
  }
}