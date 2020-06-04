package ${package}

import better.files.File
import org.apache.commons.configuration.PropertiesConfiguration
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.JavaConverters._

class DebugConfigSpec extends AnyFlatSpec with Matchers {

  val configDir: File = File("src/main/assembly/dist/cfg")
  val debugConfigDir: File = File("src/test/resources/debug-config")

  "debug-config" should "contain the same files as src/main/assembly/dist/cfg" in {
    val filesInDebugConfig = debugConfigDir.list.toSet
    val filesInDistCfg = configDir.list.toSet

    filesInDebugConfig.map(_.name) shouldBe filesInDistCfg.map(_.name)
  }

  it should "contain an application.properties with the same keys as the one in src/main/assembly/dist/cfg" in {
    val propsInDebugConfig = new PropertiesConfiguration((debugConfigDir / "application.properties").toJava)
    val propsInDistCfg = new PropertiesConfiguration((configDir / "application.properties").toJava)

    propsInDebugConfig.getKeys.asScala.toSet shouldBe propsInDistCfg.getKeys.asScala.toSet
  }
}
