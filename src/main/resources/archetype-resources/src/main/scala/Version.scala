package ${package}

object Version {
  def apply(): String = {
    val props = new java.util.Properties()
    props.load(Version.getClass.getResourceAsStream("/Version.properties"))
    props.getProperty("application.version")
  }
}