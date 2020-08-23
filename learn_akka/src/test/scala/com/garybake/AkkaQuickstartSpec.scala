//#full-example
package com.garybake

import akka.actor.testkit.typed.scaladsl.ScalaTestWithActorTestKit
//import com.garybake.Greeter.Greet
//import com.garybake.Greeter.Greeted
import org.scalatest.wordspec.AnyWordSpecLike

//#definition
class AkkaQuickstartSpec extends ScalaTestWithActorTestKit with AnyWordSpecLike {
//#definition

//  "A Greeter" must {
//    //#test
//    "reply to greeted" in {
//      val replyProbe = createTestProbe[Greeted]()
//      val underTest = spawn(Greeter())
//      underTest ! Greet("Santa", replyProbe.ref)
//      replyProbe.expectMessage(Greeted("Santa", underTest.ref))
//    }
//    //#test
//  }

}
//#full-example
