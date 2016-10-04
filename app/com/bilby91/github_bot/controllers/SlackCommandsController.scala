package com.bilby91.github_bot.controllers

import play.api.mvc.{Action, Controller, Request}
import com.bilby91.github_bot.serialization._
import com.bilby91.github_bot.models.{SlackRequest, SlackResponse}
import com.bilby91.github_bot.services.ChatRequestDispatcher
import com.google.inject.Inject
import org.json4s._
import com.github.tototoshi.play2.json4s.Json4s

class SlackCommandsController @Inject() (json4s: Json4s, dispatcher: ChatRequestDispatcher) extends Controller {

  import json4s._
  implicit val formats = DefaultFormats + CommandSerializer

  def create = Action(json) { implicit request =>
    val reply = dispatcher.process(parsedCommand)

    Ok(reply.message)
  }

  private def parsedCommand(implicit request: Request[org.json4s.JsonAST.JValue]) : SlackRequest = {
    request.body.camelizeKeys.extract[SlackRequest]
  }

}
