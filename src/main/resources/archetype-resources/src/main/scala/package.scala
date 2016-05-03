package ${groupId}

import java.util.Properties

package object ${moduleSubpackage} {

  val homeDir = new File(System.getProperty("app.home"))

  case class Parameters(/* Insert parameters */) {
    override def toString: String =
      s"<Replace with nicely formatted string with name-value style output of parameters>"
  }

  object Version {
    def apply(): String = {
      val props = new Properties()
      props.load(getClass.getResourceAsStream("/Version.properties"))
      props.getProperty("application.version")
    }
  }


}
