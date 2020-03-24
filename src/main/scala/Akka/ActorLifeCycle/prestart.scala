/**
  * Created by zevik on 3/24/20.
  */

import akka.actor._
import akka.actor.TypedActor.PreStart

class LifeCyleMethodsExample2 extends Actor{
  def receive = {
    case msg:String => println(msg+" "+self.path.name);  // Getting name of Actor
  }
  override def preStart(){    // overriding preStart method
    println("preStart method is called");
  }
  override def postStop(){    // Overriding postStop method
    println("postStop method is called");
  }
}

object ActorMain2{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[LifeCyleMethodsExample2],"RootActor");
    actor ! "Hello"


    println("stopping Actor");
    actorSystem.stop(actor);      // Stopping Actor by passing actor reference.
  }
}