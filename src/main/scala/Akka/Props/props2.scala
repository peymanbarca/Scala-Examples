/**
  * Created by zevik on 3/24/20.
  */



import akka.actor._


class CreatingActor extends Actor{
  def receive = {
    case msg:String => println(msg+" "+self.path.name)    // Receiving message and name of actor
  }
}

object CreatingActorExample{
  def main(args:Array[String]){
    var actorSystem = ActorSystem("ActorSystem");

    var props1 = Props[CreatingActor];  // creating pops here

    var actor1 = actorSystem.actorOf(props1);  // passing pops reference
    var actor2 = actorSystem.actorOf(Props[CreatingActor],"Actor2")  // Passing pops and explicitly giving name to the actor
    var actor3 = actorSystem.actorOf(Props(classOf[CreatingActor]),"Actor3")  // Passing actor class by using classOf
    var actor4 = actorSystem.actorOf(Props[CreatingActor], name = "Actor4")  // Name passing to variable
    var actor5 = actorSystem.actorOf(Props(new CreatingActor()), name = "Actor5") // This approach is not recommended

    actor1 ! "Hello"
    actor2 ! "Hello"
    actor3 ! "Hello"
    actor4 ! "Hello"
    actor5 ! "Hello"
  }
}