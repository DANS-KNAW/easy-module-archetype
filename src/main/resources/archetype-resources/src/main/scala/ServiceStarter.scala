#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import org.apache.commons.daemon.{Daemon, DaemonContext}
import org.slf4j.{Logger, LoggerFactory}

class ServiceStarter extends Daemon {
  var log: Logger = _ // Not loading logger yet, to avoid possibility of errors before init is called
  var service: ${javaName}Service = _ // Idem

  def init(ctx: DaemonContext): Unit = {
    log = LoggerFactory.getLogger(getClass)
    log.info("Creating application object...")
    val app = new ${javaName}App
    log.info("Initializing service...")
    service = new ${javaName}Service(app)
    log.info("Service initialized.")
  }

  def start(): Unit = {
    log.info("Starting service...")
    service.start()
    log.info("Service started.")
  }

  def stop(): Unit = {
    log.info("Stopping service...")
    service.stop()
  }

  def destroy(): Unit = {
    service.destroy()
    log.info("Service stopped.")
  }
}
