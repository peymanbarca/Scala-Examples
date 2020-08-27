package Collections.basics

/**
  * Created by zevik on 3/24/20.
  */

/*
* Scala Vector
Vector is a general-purpose, immutable data structure. It provides random access of elements. It is good for large collection of elements.

It extends an abstract class AbstractSeq and IndexedSeq trait.
* */

import scala.collection.immutable._


object MainObjectVec{
  def main(args:Array[String]){
    var vector = Vector("Hocky","Cricket","Golf")
    var vector2 = Vector("Swimming")
    print("Vector Elements: ")
    vector.foreach((element:String) => print(element+" "))
    var newVector  = vector :+ "Racing"                             // Adding a new element into vector
    print("\nVector Elements after adding: ")
    newVector.foreach((element:String) => print(element+" "))
    var mergeTwoVector = newVector ++ vector2                       // Merging two vector
    print("\nVector Elements after merging: ")
    mergeTwoVector.foreach((element:String) => print(element+" "))
    var reverse = mergeTwoVector.reverse                            // Reversing vector elements
    print("\nVector Elements after reversing: ")
    reverse.foreach((element:String) => print(element+" "))
    var sortedVector = mergeTwoVector.sorted                        // Sorting vector elements
    print("\nVector Elements after sorting: ")
    sortedVector.foreach((element:String) => print(element+" "))
  }
}