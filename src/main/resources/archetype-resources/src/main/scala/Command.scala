#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import nl.knaw.dans.lib.logging.DebugEnhancedLogging

import scala.util.{Failure, Try}

object Command extends App with ${javaName}App with DebugEnhancedLogging {
  import logger._
  import scala.language.reflectiveCalls
  type FeedBackMessage = String

  debug("Starting command line interface")
  private val opts = CommandLineOptions(args, this)
  opts.verify()

  private val result: Try[FeedBackMessage] = opts.subcommand match {
    // Translate command line into calls to application API.

    case Some(cmd @ opts.runService) => runAsService()
    case _ => Failure(new IllegalArgumentException(s"Unknown command: ${opts.subcommand}"))
  }

  private def runAsService(): Try[FeedBackMessage] = Try {
    import logger._
    val service = new ${javaName}Service()
    Runtime.getRuntime.addShutdownHook(new Thread("service-shutdown") {
      override def run(): Unit = {
        info("Stopping service ...")
        service.stop()
        info("Cleaning up ...")
        service.destroy()
        info("Service stopped.")
      }
    })
    service.start()
    info("Service started ...")
    Thread.currentThread.join()
    "Service terminated normally."
  }
}
