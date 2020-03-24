/**
  * Created by zevik on 3/24/20.
  */


/*
* Scala Seq
Seq is a trait which represents indexed sequences that are guaranteed immutable. You can access elements by using their indexes. It maintains insertion order of elements.

Sequences support a number of methods to find occurrences of elements or subsequences. It returns a list.
* */


import scala.collection.immutable._
object MainObjectSeq{
  def main(args:Array[String]){
    var seq:Seq[Int] = Seq(52,85,1,8,3,2,7)
    seq.foreach((element:Int) => print(element+" "))
    println("\nis Empty: "+seq.isEmpty)
    println("Ends with (2,7): "+ seq.endsWith(Seq(2,7)))
    println("contains 8: "+ seq.contains(8))
    println("last index of 3 : "+seq.lastIndexOf(3))
    println("Reverse order of sequence: "+seq.reverse)
  }
}