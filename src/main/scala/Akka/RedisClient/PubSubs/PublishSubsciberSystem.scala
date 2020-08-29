

import java.net.InetSocketAddress
import java.util.concurrent.TimeUnit

import akka.actor.{Actor, Props}
import akka.util.Timeout
import redis.RedisClient
import redis.actors.RedisSubscriberActor
import redis.api.pubsub.{Message, PMessage}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.util.{Failure, Success}

/**
  * Created by zevik on 8/28/20.
  */


object ExamplePubSub extends App {


  implicit val akkaSystem = akka.actor.ActorSystem(name = "OurAkkaSystem")

  val redis = RedisClient()



  // publish after 2 seconds every 2 or 5 seconds

  // ------------ publish periodically a msg over a channel produceStage1
  akkaSystem.scheduler.schedule(2 seconds, 2 seconds)(redis.publish(channel =  "produceStage1", value =  "Current Time is :" + System.currentTimeMillis()))

  // ------------ publish periodically a msg over a channel pattern.match
  //akkaSystem.scheduler.schedule(2 seconds, 8 seconds)(redis.publish("pattern.match", "pattern value msg"))


  // shutdown Akka in 30 seconds
  akkaSystem.scheduler.scheduleOnce(30 seconds)(akkaSystem.shutdown())

  val channels = Seq("produceStage1","produceStage2")
  val patterns = Seq("pattern.*")



  // create SubscribeActor instance
  val subscriberActorRef1 = akkaSystem.actorOf(Props(classOf[SubscribeActor], channels, patterns).withDispatcher("rediscala.rediscala-client-worker-dispatcher"),name = "subscriber_actor")
  val subscriberActorRef2 = akkaSystem./("subscriber_actor")


  // -------------- create stage3 actor ----------
  akkaSystem.actorOf(Props[StageThreeActor],name = "StageThreeActor")

  // --------------------- print akka system tree -------------
  val res = new PrivateMethodExposer(akkaSystem)('printTree)()
  println(res)

  // to view continuous tree of akka system
  //akkaSystem.scheduler.schedule(2 seconds, 5 seconds)(println(res))

}

class SubscribeActor(channels: Seq[String] = Nil, patterns: Seq[String] = Nil)
  extends  RedisSubscriberActor (
    new InetSocketAddress("localhost", 6379),
    channels,
    patterns,
    onConnectStatus = connected => { println(s"connected: $connected")}
  ) {


  def onMessage(message: Message) {

    println("\n\n\n -----------------------------------")
    val data = message.data.utf8String
    println(s"new message received : $data")

    implicit val timeout = Timeout(FiniteDuration(1, TimeUnit.SECONDS))
    context.actorSelection("akka://OurAkkaSystem/user/" + "subscriber_actor").resolveOne().onComplete {
      case Success(actorRef) => context.actorOf(Props[StageTwoActor]).tell(data,actorRef)
      case Failure(ex) => println("akka://OurAkkaSystem/user/" + "subscriber_actor" + " does not exist")
    }



  }

  def onPMessage(pmessage: PMessage) {

    println("\n\n\n -----------------------------------")
    val data = pmessage.data.utf8String
    println(s"new pattern message received : $data")
  }

}

class StageTwoActor extends Actor{


  def receive ={
    case message:String => {
      println("Message received in StageTwoActor from "+sender().path.name+" : "+message);
      implicit val timeout = Timeout(FiniteDuration(1, TimeUnit.SECONDS))
      context.actorSelection("akka://OurAkkaSystem/user/" + "StageThreeActor").resolveOne().onComplete {
        case Success(actorRef) => println(" forwarding for StageThreeActor"); actorRef.forward(message)
        case Failure(ex) => println("akka://OurAkkaSystem/user/" + "StageThreeActor" + " does not exist")
      }
    }
    case _ => println("Unknown message");
  }

  override def postStop(): Unit = {println("StageTwoActor omitted!")}

}


class StageThreeActor extends Actor{


  def receive ={
    case message:String => {
      println("Message received in StageThreeActor from "+sender().path+" : "+message);
    }
    case _ => println("Unknown message");
  }

  override def postStop(): Unit = {println("StageThreeActor omitted!")}

}