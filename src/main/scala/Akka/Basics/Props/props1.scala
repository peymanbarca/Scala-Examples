/**
  * Created by zevik on 3/24/20.
  */


/*
* Akka Props
Props is a configuration class which is used to specify options while creating an actor. It is immutable, so it is thread-safe and shareable.
* */

import akka.actor.Actor;
import akka.actor.ActorSystem;
import akka.actor.Props;

class PropsExample extends Actor {
  def receive= {
    case msg:String => println(msg+" "+self.path.name)
  }
}
object PropsMain{
  def main(args:Array[String]){
    var actorSystem = ActorSystem("ActorSystem");
    var actor = actorSystem.actorOf(Props[PropsExample],"PropExample");
    actor ! "Hello from"
  }
}