#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import java.nio.file.{ Files, Paths }

import org.apache.commons.configuration.PropertiesConfiguration

import scala.io.Source

trait ${javaName}App {
  // extends ...
  // with ...
  // Mix in the traits that provided the application's functionality
  private val home = Paths.get(System.getProperty("app.home"))
  private val cfg = Seq(
    Paths.get(s"/etc/opt/dans.knaw.nl/${artifactId}/"),
    home.resolve("cfg")).find(Files.exists(_)).getOrElse { throw new IllegalStateException("No configuration directory found")}

  val version: String = resource.managed(scala.io.Source.fromFile(home.resolve("bin/version").toFile)).acquireAndGet {
    _.mkString
  }
  val properties = new PropertiesConfiguration(cfg.resolve("application.properties").toFile)

  // Fill the fields required by the traits mixed in above
  // val settingForTraitX = properties.getString("setting.x")

  def validateSettings(): Unit = {
    // Validate the settings read in above. This methods should cause the application to halt if settings are found to be invalid.
  }
}