package Akka.Basics.Communication.tell

/**
  * Created by zevik on 3/24/20.
  */


import akka.actor.{Actor, ActorSystem, Props};

class ActorExample2 extends Actor{
  def receive = {
    case message:String => println("Message received: "+message+ " from - "+ self.path.name);
      println("Sender: "+sender())
      var child = context.actorOf(Props[Actor2], "ChildActor");  // create a child actor
      child ! "Hello"


  }
}

class Actor2 extends Actor{
  def receive = {
    case message:String => println("Message received: "+message+ " from - "+ self.path.name);
      println("Sender: "+sender());
  }
}

object ActorExample2{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[ActorExample2], "RootActor");
    actor ! "Hello"
  }
}