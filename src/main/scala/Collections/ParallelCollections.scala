/**
  * Created by zevik on 8/27/20.
  */


import scala.collection.parallel.immutable._

object ParallelCollectionsExample extends App{

  def parallelFilter = {
    Vector.range(1, 1000000).par.filter(_ % 2 == 0).seq
  }

  def conversion = {


    timedOperation {
      val xs = List.iterate(1, 500000)(x => x + 1)
      xs.par
    }
  }

  def timedOperation[T](f: => T) = {
    val startTime = System.currentTimeMillis
    f
    println("Time taken = " + (System.currentTimeMillis - startTime) + " ms!")
  }

  def doWork[T](mode:String,input:Vector[Int]) = {
    val startTime = System.currentTimeMillis
    mode match {
      case "PARALLEL" => {println("Parallel"); input.par.filter(_ % 3 == 0).seq}
      case "SEQ" => {println("Seq"); input.filter(_ % 3 == 0).seq}
      case _ => println("RIDID")

    }
    println("Time taken = " + (System.currentTimeMillis - startTime) + " ms!")
  }

  timedOperation(parallelFilter)

  println("------------")


  // ----------- parallel
  println("Parallel Filtering : ")
  doWork("PARALLEL",Vector.range(1, 10000000))

  // ----------- regular
  println("Sequential Filtering : ")
  doWork("SEQ",Vector.range(1, 10000000))


  println("------------")
  conversion
}
