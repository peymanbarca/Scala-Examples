/**
  * Created by zevik on 3/24/20.
  */


import akka.actor._

class LifeCyleMethodsExample extends Actor{

  def receive = {
    case msg:String => println(msg+" "+self.path.name);  // Getting name of Actor
    var a:Int =  10/0;      // ArithmethicException occurred
  }

  override def preRestart(reason:Throwable, message: Option[Any]){    // Overriding preRestart method
    println("preRestart method is called < ----------");
    println("Reason: "+reason)
  }


  override def postRestart(reason:Throwable){    // Overriding preRestart method
    println("----- > postRestart method is called");
    println("Reason: "+reason)
  }

}

object ActorMain{
  def main(args:Array[String]){
    val actorSystem = ActorSystem("ActorSystem");
    val actor = actorSystem.actorOf(Props[LifeCyleMethodsExample],"RootActor");
    actor ! "Hello"
  }
}