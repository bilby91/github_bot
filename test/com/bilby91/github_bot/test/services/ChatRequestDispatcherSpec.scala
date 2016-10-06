package com.bilby91.github_bot.test.services

import org.scalatest._
import org.scalamock.scalatest.MockFactory
import com.bilby91.github_bot.models.{SlackRequest, SlackResponse}
import com.bilby91.github_bot.services.{ChatRequestDispatcher}
import org.scalatestplus.play.OneAppPerSuite

class ChatRequestDispatcherSpec
  extends FunSpec with OneAppPerSuite with Inside with BeforeAndAfter with Matchers with MockFactory {


  def buildSlackRequest(token: String = "", teamId: String = "", teamDomain: String = "", channelId: String = "",
                        channelName: String = "", userId: String = "", userName: String = "", commandString: String = "",
                        text: String = "", responseUrl: String = "") : SlackRequest = {
    SlackRequest(token, teamId, teamDomain, channelId, channelName, userId, userName, commandString, text, responseUrl)
  }

  describe(".process") {

    val subject = (request: SlackRequest) => new ChatRequestDispatcher().process(request)

    describe("when the command is invalid") {

      val request = buildSlackRequest(commandString = "invalid command")

      it("does reply with an error message") {
         inside(subject(request)) { case SlackResponse(message) =>
            message should startWith("Invalid command")
        }
      }

    }

  }
}

