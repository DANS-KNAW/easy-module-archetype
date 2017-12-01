#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import org.apache.commons.daemon.{Daemon, DaemonContext}
import org.slf4j.{Logger, LoggerFactory}

import nl.knaw.dans.lib.logging.DebugEnhancedLogging

class ServiceStarter extends Daemon with DebugEnhancedLogging {
  var app: ${javaName}App = _
  var service: ${javaName}Service = _

  override def init(context: DaemonContext): Unit = {
    logger.info("Initializing service...")
    val configuration = Configuration()
    app = new ${javaName}App(new ApplicationWiring(configuration))
    service = new ${javaName}Service(configuration.properties.getInt("daemon.http.port"), app)
    logger.info("Service initialized.")
  }

  override def start(): Unit = {
    logger.info("Starting service...")
    app.init()
      .flatMap(_ => service.start())
      .unsafeGetOrThrow
    logger.info("Service started.")
  }

  override def stop(): Unit = {
    logger.info("Stopping service...")
    service.stop().unsafeGetOrThrow
  }

  override def destroy(): Unit = {
    service.destroy().unsafeGetOrThrow
    logger.info("Service stopped.")
  }
}
