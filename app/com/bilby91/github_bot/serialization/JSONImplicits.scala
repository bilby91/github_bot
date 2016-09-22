package com.bilby91.github_bot.serialization

import com.bilby91.github_bot.models._
import play.api.libs.json._
import play.api.libs.functional.syntax._

object JSONImplicits {

  implicit val slackCommandsReads: Reads[SlackCommand] = (
    (JsPath \ "token" ).read[String] ~
      (JsPath \ "team_id").read[String] ~
      (JsPath \ "team_domain").read[String] ~
      (JsPath \ "channel_id").read[String] ~
      (JsPath \ "channel_name").read[String] ~
      (JsPath \ "user_id").read[String] ~
      (JsPath \ "user_name").read[String] ~
      (JsPath \ "command").read[String] ~
      (JsPath \ "text").read[String] ~
      (JsPath \ "response_url").read[String]
    )(SlackCommand)

  implicit val slackCommandsWrites: Writes[SlackCommand] = (
    (JsPath \ "token" ).write[String] ~
      (JsPath \ "team_id").write[String] ~
      (JsPath \ "team_domain").write[String] ~
      (JsPath \ "channel_id").write[String] ~
      (JsPath \ "channel_name").write[String] ~
      (JsPath \ "user_id").write[String] ~
      (JsPath \ "user_name").write[String] ~
      (JsPath \ "command").write[String] ~
      (JsPath \ "text").write[String] ~
      (JsPath \ "response_url").write[String]
    )((unlift(SlackCommand.unapply)))

}

