package com.bilby91.github_bot.test.support

import com.bilby91.github_bot.models.GitHubLabel
import com.bilby91.github_bot.services.GitHubService

class GitHubServiceMock extends GitHubService {

  override def getLabels(user: String, project: String): List[GitHubLabel] = {
    List(
      GitHubLabel("foo", "http://gb.com/labels/foo", "2ddd"),
      GitHubLabel("bar", "http://gb.com/labels/bar", "2fff")
    )
  }
}
