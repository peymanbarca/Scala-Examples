package Collections.basics

/**
  * Created by zevik on 3/24/20.
  */

/*
* Scala Set
It is used to store unique elements in the set. It does not maintain any order for storing elements. You can apply various operations on them.
 It is defined in the Scala.collection.immutable package.
* */
import scala.collection.immutable._
object MainObjectSet{
  def main(args:Array[String]){
    val set1 = Set()                            // An empty set
    var games = Set("Cricket","Football","Hocky","Golf","Golf")    // Creating a set with elements
    println(set1)
    println(games)

    games += "Racing"               // Adding new element
    println(games)
    games += "Cricket"              // Adding new element, it does not allow duplicacy.
    println(games)
    games -= "Golf"             // Removing element
    println(games)


    games.foreach((element:String)=> println(element))
  }
}
