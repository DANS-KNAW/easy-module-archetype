#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import java.nio.file.Paths

import org.apache.commons.configuration.PropertiesConfiguration

trait ${javaName}App
  // extends ...
  // with ...
  // Mix in the traits that provided the application's functionality
  {
  val properties = new PropertiesConfiguration(Paths.get(System.getProperty("app.home"), "cfg/application.properties").toFile)


  // Fill the fields required by the traits mixed in above
  // val settingForTraitX = properties.getString("setting.x")

  def validateSettings(): Unit = {
    // Validate the settings read in above. This methods should cause the application to halt if settings are found to be invalid.
  }
}