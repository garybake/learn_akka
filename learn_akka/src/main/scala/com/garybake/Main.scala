//#full-example
package com.garybake

//http://arild.github.io/akka-workshop/#10
//https://www.reddit.com/r/scala/comments/9e2z91/pet_projects_to_exercise_akka/

import akka.actor._
import scala.concurrent.duration._
import scala.language.postfixOps

// Actual message passed as object
case class SayHello(name: String)

object DoGreeting


class GreetingActor(delay: FiniteDuration) extends Actor {

  override def preStart() = {
    scheduleNextGreeting()
  }

  def receive = {
    case doGreeting => {
      println("hello")
      scheduleNextGreeting()
    }

    case hello: SayHello => {
      println("Hello" + hello.name)
      sender ! hello.name  // Goes to dead letters if sender was main
    }
    case message: String => println("Hello " + message)
  }

  def scheduleNextGreeting(): Unit = {
    import context.dispatcher
    context.system.scheduler.scheduleOnce(delay, self, DoGreeting)
  }
}

object Main extends App {
  println("Starting main...")

  val system = ActorSystem("GaryActorSystem")
  val greetingActor: ActorRef = system.actorOf(Props(new GreetingActor(1 second)))

  greetingActor ! "Hulk Hogan"
//  greetingActor ! SayHello("The Pope")
}

