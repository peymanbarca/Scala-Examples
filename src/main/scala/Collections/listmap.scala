/**
  * Created by zevik on 3/24/20.
  */


/*
* Scala ListMap
This class implements immutable maps by using a list-based data structure. It maintains insertion order and returns ListMap. This collection is suitable for small elements.
* */

import scala.collection.immutable._
object MainObjectListMap{
  def main(args:Array[String]){
    var listMap = ListMap("Rice"->"100","Wheat"->"50","Gram"->"500")    // Creating listmap with elements
    listMap.foreach{
      case(key,value)=>println(key+"->"+value)
    }
    println(listMap("Gram"))
    var newListMap = listMap+("Pulses"->"550")
    newListMap.foreach {
      case (key, value) => println (key + " -> " + value)
    }
  }
}