/**
  * Created by zevik on 3/24/20.
  */


import akka.actor.{Actor,ActorSystem, Props}

class RootActor2 extends Actor{
  def receive = {
    case msg => println("Message received: "+msg);
      10/0;
  }
  override def preStart(){
    super.preStart();
    println("preStart method is called");
  }
  override def postStop(){
    super.postStop();
    println(".... postStop method is called");
  }
  override def preRestart(reason:Throwable, message: Option[Any]){
    super.preRestart(reason, message);
    println("preRestart method is called <---");
    println("Reason: "+reason);
  }
  override def postRestart(reason:Throwable){
    super.postRestart(reason);
    println(" ----> postRestart is called");
    println("Reason: "+reason);
  }
}


object ActorMain3{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[RootActor2],"RootActor2");
    actor ! "Hello"
  }
}