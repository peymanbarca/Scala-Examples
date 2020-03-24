/**
  * Created by zevik on 3/24/20.
  */


// Akka Stopping Child Actor Example

import akka.actor.{Actor,ActorSystem, Props};

class ActorExample7 extends Actor{
  def receive = {
    case message:String => println("Message received by "+self.path.name+": "+message);
      val childactor = context.actorOf(Props[ChildActor7], "ChildActor");
      childactor ! "Hello child Actor"
      context.stop(childactor);

    case _ => println("Unknown message");
  }
}


class ChildActor7 extends Actor{
  def receive = {
    case message:String => println("Message received by "+self.path.name+": "+message);
    case _ => println("Unknown message");
  }

  override def postStop(){
    println("Child Actor stoped");
  }
}


object ActorExample7{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[ActorExample7], "RootActor");
    actor ! "Hello"

  }
}
