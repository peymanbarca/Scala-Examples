/**
  * Created by zevik on 3/24/20.
  */

/*
* An actor is an entity which communicates to other actor by message passing. Actor has it's own state and behavior. As in object-oriented programming everything is an object same like everything is an actor in actor-based system.

In other words, we can say that an actor is an object that encapsulates state and behavior.
* */


import akka.actor.Actor;          // Importing actor trait
import akka.actor.ActorSystem;
import akka.actor.Props;

class HelloAkka extends Actor{    // Extending actor trait
  def receive = {                 //  Receiving message
    case msg:String => println(msg)
    case _ =>println("Unknown message")      // Default case
  }
}

object MainActor1{
  def main(args:Array[String]){
    var actorSystem = ActorSystem("ActorSystem");                       // Creating ActorSystem
    var actor = actorSystem.actorOf(Props[HelloAkka],"HelloAkka")        //Creating actor
    actor ! "Hello Akka"                                                // Sending messages by using !
    actor ! 100.52
  }
}