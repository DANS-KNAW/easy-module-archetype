package nl.knaw.dans.easy.task

import java.io.PrintWriter

import scala.xml.transform.RuleTransformer

/**
  *
  */

case class Settings(args){

  override def toString: String =
    s"output all parameters with values"
}