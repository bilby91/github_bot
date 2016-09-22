package com.bilby91.github_bot.controllers

import play.api.mvc.{Controller, Action}
import play.api.libs.json._
import com.bilby91.github_bot.models.{SlackCommand}
import com.bilby91.github_bot.serialization.JSONImplicits.{slackCommandsReads, slackCommandsWrites}

class SlackCommandsController extends Controller {

  def create = Action(parse.json[SlackCommand]) { request =>
    Ok(Json.toJson(request.body))
  }

}
