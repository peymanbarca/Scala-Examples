/**
  * Created by zevik on 3/24/20.
  */

/*
* Scala BitSet
Bitsets are sets of non-negative integers which are represented as variable-size arrays of bits packed into 64-bit words.
 The memory footprint of a bitset is determined by the largest number stored in it. It extends Set trait.
* */

import scala.collection.immutable._
object MainObjectBiset{
  def main(args:Array[String]){
    var numbers = BitSet(1,5,8,6,9,0)
    numbers.foreach((element:Int) => print(element+" "))
    numbers += 20               // Adding an element
    print("\nAfter adding 20: ")
    numbers.foreach((element:Int) => print(element+" "))
    numbers-=0              // Deleting an element
    print("\nAfter deleting 0: ")
    numbers.foreach((element:Int) => print(element+" "))
  }
}