package Collections.basics

/**
  * Created by zevik on 3/24/20.
  */


/*
* Scala Stream
Stream is a lazy list. It evaluates elements only when they are required. This is a feature of scala. Scala supports lazy computation. It increases performance of your program.
* */

import scala.collection.immutable._
object MainObjectStream{
  def main(args:Array[String]){
    var stream = 100 #:: 200 #:: 85 #:: Stream.empty
    println(stream)
    var stream2 = (1 to 10).toStream
    println(stream2)
    var firstElement = stream2.head
    println(firstElement)
    println(stream2.take(10))
    println(stream.map{_*2})
  }
}