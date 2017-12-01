package ${groupId}

import scala.util.{ Failure, Success, Try }

package object ${moduleSubpackage} {

  implicit class TryExtensions2[T](val t: Try[T]) extends AnyVal {
    // TODO candidate for dans-scala-lib
    def unsafeGetOrThrow: T = {
      t match {
        case Success(value) => value
        case Failure(throwable) => throw throwable
      }
    }
  }
}
