package com.bilby91.github_bot.services

import com.bilby91.github_bot.models.GitHubLabel
import com.google.inject.Inject
import org.json4s._
import org.json4s.native.Serialization
import org.json4s.native.Serialization.read

class GitHubBuhtigService @Inject() (configuration: play.api.Configuration) extends GitHubService {

  import net.caoticode.buhtig.{Buhtig}
  import net.caoticode.buhtig.Converters._

  implicit val formats = Serialization.formats(NoTypeHints)
  val client = new Buhtig(configuration.underlying.getString("github.token")).syncClient

  override def getLabels(user: String, project: String) : List[GitHubLabel] = {
    val labels = client.repos(user)(project).labels.get[JSON]

    read[List[GitHubLabel]](labels)
  }
}
