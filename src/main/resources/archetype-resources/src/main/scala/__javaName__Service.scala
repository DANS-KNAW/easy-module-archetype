#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import javax.servlet.ServletContext
import nl.knaw.dans.lib.logging.DebugEnhancedLogging
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletContextHandler
import org.scalatra._
import org.scalatra.servlet.ScalatraListener

import scala.util.Try

class ${javaName}Service(serverPort: Int,
                         servlets: Map[String, ScalatraServlet]) extends DebugEnhancedLogging {

  private val server = new Server(serverPort) {
    setHandler(
      new ServletContextHandler(ServletContextHandler.NO_SESSIONS) {
        addEventListener(
          new ScalatraListener() {
            override def probeForCycleClass(classLoader: ClassLoader): (String, LifeCycle) = {
              ("anonymous", new LifeCycle {
                override def init(context: ServletContext): Unit = {
                  for ((path, servlet) <- servlets)
                    context.mount(servlet, path)
                }
              })
            }
          }
        )
      }
    )
  }
  logger.info(s"HTTP port is ${symbol_dollar}serverPort")

  def start(): Try[Unit] = Try {
    logger.info("Starting service...")
    server.start()
  }

  def stop(): Try[Unit] = Try {
    logger.info("Stopping service...")
    server.stop()
  }

  def destroy(): Try[Unit] = Try {
    server.destroy()
    logger.info("Destroyed service.")
  }
}
