#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import java.nio.file.{ Files, Paths }

import nl.knaw.dans.lib.logging.DebugEnhancedLogging
import org.apache.commons.configuration.PropertiesConfiguration

import scala.io.Source

class ${javaName}App extends DebugEnhancedLogging {
  import logger._
  private val home = Paths.get(System.getProperty("app.home"))
  debug(s"app.home = ${symbol_dollar}home")
  val version: String = resource.managed(scala.io.Source.fromFile(home.resolve("bin/version").toFile)).acquireAndGet {
    _.mkString
  }
  debug(s"version = ${symbol_dollar}version")
  private val cfg = Seq(
    Paths.get(s"/etc/opt/dans.knaw.nl/${artifactId}/"),
    home.resolve("cfg")).find(Files.exists(_)).getOrElse { throw new IllegalStateException("No configuration directory found")}
  debug(s"Found configuration directory at $cfg")

  private val properties = new PropertiesConfiguration(cfg.resolve("application.properties").toFile)
  info(s"Reading configuration from ${symbol_dollar}{properties.getFile}")

  val httpPort: Int = properties.getInt("daemon.http.port")

  // Wiring and initialization here.
}