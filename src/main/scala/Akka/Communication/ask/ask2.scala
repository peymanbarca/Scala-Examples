/**
  * Created by zevik on 3/24/20.
  */

import akka.actor.{Actor,ActorSystem, Props, ActorRef};
import akka.util.Timeout;
import scala.concurrent.Await
import akka.pattern.ask
import scala.concurrent.duration._

class ActorExample4 extends Actor{
  def receive = {
    case message:String => println("Message received: "+message+" from outside actor instance");
      println("Replying");
      val senderName = sender();
      senderName ! "Hello, I got your message.";      // Replying message
  }
}

object ActorExample4{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[ActorExample4], "RootActor");

    implicit val timeout = Timeout(10 seconds);

    val future = actor ? "Hello";
    val result = Await.result(future, timeout.duration);
    println("Message received: "+result);
  }
}