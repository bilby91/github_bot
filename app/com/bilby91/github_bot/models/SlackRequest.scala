package com.bilby91.github_bot.models

case class SlackRequest(
  token: String,
  teamId: String,
  teamDomain: String,
  channelId: String,
  channelName: String,
  userId: String,
  userName: String,
  commandString: String,
  text: String,
  responseUrl: String)

