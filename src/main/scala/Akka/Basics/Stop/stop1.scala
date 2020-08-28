/**
  * Created by zevik on 3/24/20.
  */


/*
* Akka Stopping Actors
In Akka, you can stop Actors by invoking the stop() method of either ActorContext or ActorSystem class. ActorContext is used to stop child actor and ActorSystem is used to stop top level Actor.

The actual termination of the actor is performed asynchronously.
* */


// Akka Stopping Top Level Actor Example

import akka.actor.{Actor,ActorSystem, Props};

class ActorExample6 extends Actor{
  def receive = {
    case message:String => println("Message received: "+message);
    case _ => println("Unknown message");
  }
  override def postStop(){
    println("Actor stoped");
  }
}

object ActorExample6{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[ActorExample6], "RootActor");
    actor ! "Hello"
    actorSystem.stop(actor);
  }
}
