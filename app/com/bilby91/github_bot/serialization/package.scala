package com.bilby91.github_bot

import org.json4s.FieldSerializer
import org.json4s.FieldSerializer._
import com.bilby91.github_bot.models._

package object serialization {

  implicit val CommandSerializer: FieldSerializer[SlackRequest] =
    FieldSerializer[SlackRequest](
      Map(), renameFrom("command", "commandString")
    )
}
