package com.bilby91.github_bot.models

case class SlackCommand(
  token: String,
  teamId: String,
  teamDomain: String,
  channelId: String,
  channelName: String,
  userId: String,
  userName: String,
  command: String,
  text: String,
  responseUrl: String)

