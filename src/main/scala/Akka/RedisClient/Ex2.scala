

import java.net.InetSocketAddress

import akka.actor.Props
import redis.RedisClient
import redis.actors.RedisSubscriberActor
import redis.api.pubsub.{Message, PMessage}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

/**
  * Created by zevik on 8/28/20.
  */


object ExamplePubSub extends App {


  implicit val akkaSystem = akka.actor.ActorSystem()

  val redis = RedisClient()


  // publish after 2 seconds every 2 or 5 seconds
  akkaSystem.scheduler.schedule(2 seconds, 2 seconds)(redis.publish("produceStage1", "Current Time is :" + System.currentTimeMillis()))
  akkaSystem.scheduler.schedule(2 seconds, 8 seconds)(redis.publish("pattern.match", "pattern value msg"))

  // shutdown Akka in 30 seconds
  akkaSystem.scheduler.scheduleOnce(30 seconds)(akkaSystem.shutdown())

  val channels = Seq("produceStage1","produceStage2")
  val patterns = Seq("pattern.*")



  // create SubscribeActor instance
  val subscriberActor = akkaSystem.actorOf(Props(classOf[SubscribeActor], channels, patterns).withDispatcher("rediscala.rediscala-client-worker-dispatcher"),name = "subscriber_actor")


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

    //redis.publish("produceStage2"," This value Received and stage 2 ready to begin on that " + data)
  }

  def onPMessage(pmessage: PMessage) {

    println("\n\n\n -----------------------------------")
    val data = pmessage.data.utf8String
    println(s"new pattern message received : $data")
  }
}
