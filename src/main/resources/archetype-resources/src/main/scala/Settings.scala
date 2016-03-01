package ${package};

import java.io.PrintWriter

import scala.xml.transform.RuleTransformer

/**
  *
  */

case class Settings(args: Array[String])){

  override def toString: String =
    s"output all parameters with values"
}