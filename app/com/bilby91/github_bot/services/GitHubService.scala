package com.bilby91.github_bot.services

import com.google.inject.ImplementedBy
import com.bilby91.github_bot.models.{GitHubLabel}

@ImplementedBy(classOf[GitHubBuhtigService])
trait GitHubService {

  def getLabels(user: String, project: String) : List[GitHubLabel]

}


