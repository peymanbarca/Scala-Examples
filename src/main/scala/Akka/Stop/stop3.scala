/**
  * Created by zevik on 3/24/20.
  */

/*
* Akka Stopping ActorSystem Example
You can stop actor system by calling it's terminate method. This method will stop the guardian actor, which in turn will recursively stop all its child actors.
* */

import akka.actor.{Actor,ActorSystem, Props};

class ActorExample8 extends Actor{
  def receive = {
    case message:String => println("Message received by "+self.path.name+": "+message);
      val childactor = context.actorOf(Props[ChildActor8], "ChildActor");
      childactor ! "Hello child Actor"

    case _ => println("Unknown message");
  }

  override def postStop(){
    println("Top Level Actor stoped");
  }
}


class ChildActor8 extends Actor{
  def receive = {
    case message:String => println("Message received by "+self.path.name+": "+message);
    case _ => println("Unknown message");
  }

  override def postStop(){
    println("Child Actor stoped");
  }
}


object ActorExample8{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[ActorExample8], "RootActor");
    actor ! "Hello"
    actorSystem.shutdown();
  }
}