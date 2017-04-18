package ${package}

import java.nio.file.{Files, Paths}

import org.apache.commons.configuration.PropertiesConfiguration
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.JavaConverters._

class DebugConfigSpec extends FlatSpec with Matchers {

  "debug-config" should "contain the same files as src/main/assembly/dist/cfg" in {
    val filesInDebugConfig = resource.managed(Files.list(Paths.get("src/test/resources/debug-config"))).acquireAndGet(_.iterator().asScala.toSet)
    val filesInDistCfg = resource.managed(Files.list(Paths.get("src/main/assembly/dist/cfg"))).acquireAndGet(_.iterator().asScala.toSet)

    filesInDebugConfig.map(_.getFileName) shouldBe filesInDistCfg.map(_.getFileName)
  }

  it should "contain an application.properties with the same keys as the one in src/main/assembly/dist/cfg" in {
    val propsInDebugConfig = new PropertiesConfiguration(Paths.get("src/test/resources/debug-config/application.properties").toFile)
    val propsInDistCfg = new PropertiesConfiguration(Paths.get("src/main/assembly/dist/cfg/application.properties").toFile)

    propsInDebugConfig.getKeys.asScala.toSet shouldBe propsInDistCfg.getKeys.asScala.toSet
  }
}