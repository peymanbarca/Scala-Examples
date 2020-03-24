/**
  * Created by zevik on 3/24/20.
  */

object MainObjectMap{
  def main(args:Array[String]){
    var map = Map("A"->"Apple","B"->"Ball")             // Creating map
    println(map("A"))                            // Accessing value by using key
    var newMap = map+("C"->"Cat")                  // Adding a new element to map
    println(newMap)
    var removeElement = newMap - ("B")                // Removing an element from map
    println(removeElement)
    println(removeElement.get("A"))
  }
}