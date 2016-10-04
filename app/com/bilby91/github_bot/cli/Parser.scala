package com.bilby91.github_bot.cli

import scala.collection.immutable.::

case class Command(name: String, flags: List[Flag], arguments: List[Argument])
case class Argument(value: String)
case class Flag(identifier: String, value: String)

object Parser {

  val FlagPattern                = """-([\w]+)""".r
  val ArgumentPattern            = """([\w]+)""".r

  val AvailableCommands          = List("getLabels")

  def extract(commandString: String) : Option[Command] = {
    commandString.split(" ").filterNot(_.isEmpty).toList match {
      case x :: xs if validCommand(x) => Some(buildCLICommand(x, xs))
      case _        => return None
    }
  }

  def extractArgumentsAndFlags(args: List[String]) : (List[Argument], List[Flag]) = {
    args match {
      case FlagPattern(x) :: ArgumentPattern(y) :: xs =>
        val (arguments, flags) = extractArgumentsAndFlags(xs)

        (arguments, Flag(x,y) :: flags)
      case ArgumentPattern(x) :: xs =>
        val (arguments, flags) = extractArgumentsAndFlags(xs)

        (Argument(x) :: arguments, flags)
      case x :: xs => extractArgumentsAndFlags(xs)
      case Nil => (Nil, Nil)
    }
  }

  def buildCLICommand(name: String, options: List[String]) : Command = {
    val (arguments, flags) = extractArgumentsAndFlags(options)

    Command(name, flags, arguments)
  }

  def validCommand(name: String) : Boolean = {
    AvailableCommands.contains(name)
  }

}
