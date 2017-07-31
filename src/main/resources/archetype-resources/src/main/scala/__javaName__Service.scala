#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import javax.servlet.ServletContext

import nl.knaw.dans.lib.logging.DebugEnhancedLogging
import org.eclipse.jetty.ajp.Ajp13SocketConnector
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
import org.scalatra._
import org.scalatra.servlet.ScalatraListener

import scala.util.Try

class ${javaName}Service(serverPort: Int, app: ${javaName}App) extends DebugEnhancedLogging {
  import logger._

  private val server = new Server(serverPort)
  private val context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS)
  context.addEventListener(new ScalatraListener() {
    override def probeForCycleClass(classLoader: ClassLoader): (String, LifeCycle) = {
      ("anonymous", new LifeCycle {
        override def init(context: ServletContext): Unit = {
          context.mount(new ${javaName}Servlet(app), "/")
        }
      })
    }
  })
  server.setHandler(context)
  info(s"HTTP port is ${symbol_dollar}{serverPort}")

  def start(): Try[Unit] = Try {
    info("Starting service...")
    server.start()
  }

  def stop(): Try[Unit] = Try {
    info("Stopping service...")
    server.stop()
  }

  def destroy(): Try[Unit] = Try {
    server.destroy()
    app.close()
  }
}
