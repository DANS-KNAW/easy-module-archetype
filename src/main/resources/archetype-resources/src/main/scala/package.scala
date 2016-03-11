package ${groupId}

package object ${moduleSubpackage} {
  case class Parameters(/* Insert parameters */){
    override def toString: String =
      s"<Replace with nicely formatted string with name-value style output of parameters>"
  }

  object Version {
    def apply(): String = {
      val props = new java.util.Properties()
      props.load(Version.getClass.getResourceAsStream("/Version.properties"))
      props.getProperty("application.version")
    }
  }


}
