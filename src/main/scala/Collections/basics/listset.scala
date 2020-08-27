package Collections.basics

/**
  * Created by zevik on 3/24/20.
  */

/*
* Scala ListSet
In scala, ListSet class implements immutable sets using a list-based data structure. Elements are stored internally in reversed insertion order,
which means the newest element is at the head of the list. It maintains insertion order.
* */

import scala.collection.immutable._
object MainObjectListSet{
  def main(args:Array[String]){
    var listset:ListSet[String] = new ListSet()                 // Creating empty ListSet by using constructor
    var listset2:ListSet[String] = ListSet.empty                // Creating an empty listset
    println("listset: "+listset)
    println("listset2: "+listset2)
    println("After adding new elements:")
    listset+="India"            // Adding new element
    listset2+="Russia"          // Adding new element
    println("listset: "+listset)
    println("listset2: "+listset2)
  }
}