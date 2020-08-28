package Akka.Basics.Communication.tell

/**
  * Created by zevik on 3/24/20.
  */

/*
* In Akka, actors communicate to each other by sending and receiving messages.
* 1) Akka Actor tell() Method
It is used to send a message asynchronously. It does not wait and block thread for a message. It works on "fire-forget" approach.
You can also use ! (bang) exclamation mark to send message. This is the preferred way of sending messages. It gives the best concurrency and scalability characteristics.
* */

import akka.actor.{Actor, ActorSystem, Props};

class ActorExample extends Actor{
  def receive = {
    case message:String => println("Message received: "+message+ " from - "+ self.path.name);
      println("sender:"+ sender());  // returns ActorRef
  }
}

object ActorExample{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[ActorExample], "RootActor");
    actor ! "Hello"             // Sending message by using !
    actor.tell("Hello",null);  // Sending message by using tell() method // Sender is not passed here.
    actor.tell("you are the most complete goddess in the world!",null);  // Sending message by using tell() method // Sender is not passed here.
  }
}