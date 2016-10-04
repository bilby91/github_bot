package com.bilby91.github_bot.serialization

import org.scalatest._
import com.bilby91.github_bot.cli.{Command, Argument, Flag, Parser}

class ParserSpec
  extends FunSpec with Inside with BeforeAndAfter with Matchers {

  describe(".extract") {

    val subject = (commandString: String) => Parser.extract(commandString)

    describe("when the command does't exist") {

      it("returns None") {
        subject("invalid foo/bar") should be (None)
      }

    }

    describe("when the command does exist") {

      describe("and no flags and arguments are passed") {

        it("parses the command with no flags and no arguments") {
          inside(subject("getLabels")) { case Some(Command(name, flags, arguments)) =>
            name should be("getLabels")
            flags should be(List())
            arguments should be(List())
          }
        }

      }

      describe("and flags are provided") {

        it("parses the correct flag") {
          inside(subject("getLabels -p  test")) { case Some(Command(_, flags, arguments)) =>
            flags should be(List(Flag("p", "test")))
          }
        }

        describe("and there are multiple flags") {

          it("parses all of them") {
            inside(subject("getLabels -p  test -b xxx")) { case Some(Command(_, flags, arguments)) =>
              flags should contain theSameElementsAs List(Flag("p", "test"), Flag("b", "xxx"))
            }
          }

        }

      }

      describe("and arguments are provided") {

        it("parses the correct arguments") {
          inside(subject("getLabels foo")) { case Some(Command(_, flags, arguments)) =>
            arguments should contain theSameElementsAs List(Argument("foo"))
          }
        }

        describe("and there are multiple flags") {

          it("parses all of them") {
            inside(subject("getLabels foo bar")) { case Some(Command(_, flags, arguments)) =>
              arguments should contain theSameElementsAs List(Argument("foo"), Argument("bar"))
            }
          }

        }

      }

      describe("and arguments and flags are provided") {

        it("parses the flags and arguments") {
          inside(subject("getLabels -p project foo -t docker bar")) { case Some(Command(_, flags, arguments)) =>
            flags should be(List(Flag("p", "project"), Flag("t", "docker")))
            arguments should be(List(Argument("foo"), Argument("bar")))
          }
        }
      }

    }

  }

}
