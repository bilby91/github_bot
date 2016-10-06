package com.bilby91.github_bot.services

import com.bilby91.github_bot.models.{SlackRequest, SlackResponse}
import com.bilby91.github_bot.cli._

class ChatRequestDispatcher {

  def process(slackRequest: SlackRequest) : SlackResponse = {
    val command = Parser.extract(slackRequest.commandString)

    command match {
      case Some(command) => executeAndReply(command)
      case None => SlackResponse(s"Invalid command '{$slackRequest.commandString}'")
    }
  }

  private def executeAndReply(command: Command) : SlackResponse = {
    command match {
      case _ => SlackResponse("Something is really wrong.")
    }
  }
}
