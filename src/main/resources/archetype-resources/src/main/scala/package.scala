package ${groupId}

import java.nio.file.Paths

import scala.util.{Failure, Success, Try}

package object ${moduleSubpackage} {
  val CONTEXT_ATTRIBUTE_APPLICATION = "${groupId}.${moduleSubpackage}.${javaName}App"


  def getVersion(): String = {
    resource.managed(scala.io.Source.fromFile(Paths.get(System.getProperty("app.home"), "version").toFile)).acquireAndGet {
      _.mkString
    }
  }

  implicit class TryExtensions[T](val t: Try[T]) extends AnyVal {
    // TODO candidate for dans-scala-lib, see also implementation/documentation in easy-split-multi-deposit
    def onError[S >: T](handle: Throwable => S): S = {
      t match {
        case Success(value) => value
        case Failure(throwable) => handle(throwable)
      }
    }
  }
}

