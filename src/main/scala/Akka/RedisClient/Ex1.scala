/**
  * Created by zevik on 8/28/20.
  */


import akka.util.ByteString
import redis.RedisClient

import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Try

object RedisEx1 extends App {
  implicit val akkaSystem = akka.actor.ActorSystem()

  val redis = RedisClient(host = "localhost")

  val futurePong = redis.ping()
  println("Ping sent!")
  futurePong.map(pong => {
    println(s" ----> Redis replied with a $pong\n\n ------------------------")
  })
  Await.result(futurePong, 5 seconds)


  /*
  * The idea behind transactions in Rediscala is to start a transaction outside of a redis connection.
   * We use the TransactionBuilder to store call to redis commands (and for each command we give back a future).
   * When exec is called, TransactionBuilder will build and send all the commands together to the server.
   * Then the futures will be completed. By doing that we can use a normal connection with pipelining,
    * and avoiding to trap a command from outside, in the transaction...
  *
  * */

  val redisTransaction = redis.transaction() // new TransactionBuilder


  // ----------- util for set ket/value pair
  def setValueToRedis(key: String, value: String) = {
    val setResult = redisTransaction.set(key, value)
    redisTransaction.exec()
  }

  // ------------- util for get value of a key -------
  def getValueFromRedis(key: String):Option[Try[Option[ByteString]]] = {
    val value = redisTransaction.get(key)
    redisTransaction.exec()
    Await.result(value, 10 seconds)
    return value.value
  }


  def extractValue(value: Option[Try[Option[ByteString]]]): String = {
    if (value.get.isSuccess){
      if (value.get.get.nonEmpty)
        return value.get.get.get.utf8String
      return null
    }
    else
      return null
  }


  setValueToRedis("1998","France")


  val value = getValueFromRedis("1998")
  val extractedValue = extractValue(value)
  println(String.format(" Cached value for key '%s' is : ","1998") +extractedValue)

  akkaSystem.shutdown()
}
