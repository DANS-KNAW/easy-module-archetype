#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import better.files.File
import better.files.File.root
import nl.knaw.dans.lib.logging.DebugEnhancedLogging
import org.apache.commons.configuration.PropertiesConfiguration

case class Configuration(version: String,
                         serverPort: Int,
                         // other configuration properties defined in application.properties
                        )

object Configuration extends DebugEnhancedLogging {

  def apply(home: File): Configuration = {
    val cfgPath = Seq(
      root / "etc" / "opt" / "dans.knaw.nl" / "${artifactId}",
      home / "cfg")
      .find(_.exists)
      .getOrElse { throw new IllegalStateException("No configuration directory found") }
    val properties = new PropertiesConfiguration() {
      setDelimiterParsingDisabled(true)
      load((cfgPath / "application.properties").toJava)
    }
    val version = (home / "bin" / "version").contentAsString.stripLineEnd
    val agent = properties.getString("http.agent",s"${artifactId}/${symbol_dollar}version")
    logger.info(s"setting http.agent to $agent")
    System.setProperty("http.agent", agent)

    new Configuration(
      version,
      serverPort = properties.getInt("daemon.http.port"),
      // read other properties defined in application.properties
    )
  }
}
