package ${package}

import java.io.File

import org.scalatest.matchers.{ MatchResult, Matcher }

import scala.io.Source

/** Does not dump the full file but just the searched content if it is not found.
 *
 * See also <a href="http://www.scalatest.org/user_guide/using_matchers#usingCustomMatchers">CustomMatchers</a> */
trait CustomMatchers {
  class ContentMatcher(content: String) extends Matcher[File] {
    def apply(left: File): MatchResult = {
      def trimLines(s: String): String = s.split("\n").map(_.trim).mkString("\n")

      MatchResult(
        trimLines(Source.fromFile(left).mkString).contains(trimLines(content)),
        s"$left did not contain: $content",
        s"$left contains $content"
      )
    }
  }
  def containTrimmed(content: String) = new ContentMatcher(content)
}
