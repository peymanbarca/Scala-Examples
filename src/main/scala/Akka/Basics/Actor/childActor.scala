/**
  * Created by zevik on 3/24/20.
  */


import akka.actor._

class RootActor extends Actor{
  def receive = {
    case msg:String => println(msg+" "+self.path.name);
      var childActor =  context.actorOf(Props[Child],"Child");  // created a child actor by using context reference.
      childActor ! "Hello"
  }
}

class Child extends Actor{
  def receive = {
    case msg:String => println(msg+" "+self.path.name);
  }
}

object ChildActorExample{
  def main(args:Array[String]){
    var actorSystem = ActorSystem();
    var actor = actorSystem.actorOf(Props[RootActor],"RootActor");
    actor ! "Hello"
  }
}