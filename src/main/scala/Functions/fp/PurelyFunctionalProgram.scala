/**
  * Created by zevik on 8/27/20.
  */

object PureFunctionalProgram {
  def main(args: Array[String]): Unit = println(singleExpression(List("10","20","30","40","50")))

  def singleExpression: List[String] => (List[Int], List[Int]) = { a =>
    a map (_.toInt) partition (_ < 30)
  }
}