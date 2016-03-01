package ${package};

import java.io.{File, PrintWriter}
import java.net.URL

import org.rogach.scallop.ScallopConf

class CommandLineOptions (args: Array[String]) extends ScallopConf(args){

  banner("""
           Task to ...
           |
           |Options:
           |""".stripMargin)
  //val url = opt[String]("url", noshort = true, descr = "Base url for the fedora repository", default = Some("http://localhost:8080/fedora"))
  footer("")
}

object CommandLineOptions {

  def parse(args: Array[String]): Settings = {
    val opts = new CommandLineOptions(args)

   // val url: URL = new URL(opts.url())
    Settings(args)

  }

}
