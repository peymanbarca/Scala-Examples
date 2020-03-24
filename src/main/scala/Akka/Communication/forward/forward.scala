package Akka.Communication.forward

/**
  * Created by zevik on 3/24/20.
  */

/*
* Akka Actor Forward Message
You can forward a message from one actor to another. In this case, address/reference of an Actor is maintained even though the message is going through a 'mediator'.

It is helpful when writing actors that work as routers, load-balancers, replicators etc.
* */


import akka.actor.{Actor, ActorSystem, Props};

class ActorExample5 extends Actor{
  def receive = {
    case message:String => println("Message received from "+sender().path.name+" : "+message);
      val child = context.actorOf(Props[Actor5],"ChildActor");
      println("message forwarded to child Actor");
      child ! message ;    // Message forwarded to child actor

    case _ => println("Unknown message");
  }
}

class Actor5 extends Actor{
  def receive ={
    case message:String => println("Message received from "+sender().path.name+" : "+message);
    case _ => println("Unknown message");
  }
}


object ActorExample5{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[ActorExample5], "RootActor");
    actor ! "Diego Milito Comming ! "
    actor ! 123
  }
}