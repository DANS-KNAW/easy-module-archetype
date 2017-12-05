#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}

import scala.util.{ Success, Try }

class ${javaName}App(wiring: ApplicationWiring) extends AutoCloseable {


  // The application's API here. This is what is used by driver or entry-point objects.

  def init(): Try[Unit] = {
    // Do any initialization of the application here. Typical examples are opening
    // databases or connecting to other services.
    Success(())
  }

  override def close(): Unit = {

  }
}
