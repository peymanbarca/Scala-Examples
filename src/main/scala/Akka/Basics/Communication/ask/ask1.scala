/**
  * Created by zevik on 3/24/20.
  */

/*
* 2) Akka Actor ask Method
In akka, ask is a pattern and involves Actors as well as Futures. Ask is used to sends a message asynchronously and it returns a Future which represents a possible reply.
 If the actor does not reply and complete the future, it will expire after the timeout period. After timeout period, it throws an TimeoutException. You can use either ? (question mark) or ask() to send message.

You should always prefer tell method for performance and ask method, if you want response.
* */


import akka.actor.{Actor,ActorSystem, Props};
import akka.util.Timeout;
import scala.concurrent.Await
import akka.pattern.ask
import scala.concurrent.duration._

class ActorExample3 extends Actor{
  def receive = {
    case message:String => println("Message recieved: "+message);
  }
}

object ActorExample3{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[ActorExample3], "RootActor");

    implicit val timeout = Timeout(2 seconds);

    val future = actor ? "Hello";
    val result = Await.result(future, timeout.duration);
    println(result);
  }
}