package Collections.basics

/**
  * Created by zevik on 3/24/20.
  */

import scala.collection.immutable._


object MainObjectHashmap{
  def main(args:Array[String]){
    var hashMap = HashMap("A"->"Apple","B"->"Ball","C"->"Cat")
    hashMap.foreach {
      case (key, value) => println (key + " -> " + value)       // Iterating elements
    }
    println(hashMap("B"))               // Accessing value by using key
    var newHashMap = hashMap+("D"->"Doll")
    newHashMap.foreach {
      case (key, value) => println (key + " -> " + value)
    }

  }
}