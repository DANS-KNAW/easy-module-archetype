#set($symbol_pound = '#')
#set($symbol_dollar = '$')
#set($symbol_escape = '\ ')
package ${package}

import nl.knaw.dans.lib.error._
import nl.knaw.dans.lib.logging.DebugEnhancedLogging
import resource._

import scala.language.reflectiveCalls
import scala.util.control.NonFatal
import scala.util.{ Failure, Try }

object Command extends App with DebugEnhancedLogging {
  type FeedBackMessage = String

  val configuration = Configuration()
  val commandLine: CommandLineOptions = new CommandLineOptions(args, configuration) {
    verify()
  }
  val app = new ${javaName}App(new ApplicationWiring(configuration))

  managed(app)
    .acquireAndGet(app => {
      for {
        _ <- app.init()
        msg <- runSubcommand(app)
      } yield msg
    })
    .doIfSuccess(msg => println(s"OK: $msg"))
    .doIfFailure { case e => logger.error(e.getMessage, e) }
    .doIfFailure { case NonFatal(e) => println(s"FAILED: ${ e.getMessage }") }

  private def runSubcommand(app: ${javaName}App): Try[FeedBackMessage] = {
    commandLine.subcommand
      .collect {
//      case subcommand1 @ subcommand.subcommand1 => // handle subcommand1
//      case None => // handle command line without subcommands
        case commandLine.runService => runAsService(app)
      }
      .getOrElse(Failure(new IllegalArgumentException(s"Unknown command: ${ commandLine.subcommand }")))
  }

  private def runAsService(app: ${javaName}App): Try[FeedBackMessage] = Try {
    val service = new ${javaName}Service(configuration.properties.getInt("daemon.http.port"), app)
    Runtime.getRuntime.addShutdownHook(new Thread("service-shutdown") {
      override def run(): Unit = {
        service.stop()
        service.destroy()
      }
    })

    service.start()
    Thread.currentThread.join()
    "Service terminated normally."
  }
}
