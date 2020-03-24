/**
  * Created by zevik on 3/24/20.
  */

import akka.actor.{Actor,ActorSystem, Props};

class ActorReplyExample extends Actor{
  def receive = {
    case message:String => println("Message recieved from "+sender.path.name+" massage: "+message);
      val child = context.actorOf(Props[ActorChildReplyExample],"ActorChild3");
      child ! "Hello Child"
  }
}


class ActorChildReplyExample extends Actor{
  def receive ={
    case message:String => println("Message recieved from "+sender.path.name+" massage: "+message);
      println("Replying to "+sender().path.name);
      sender()! "I got your message";
  }
}

object ActorReplyExample{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[ActorReplyExample], "RootActor3");
    actor ! "Hello";
  }
}