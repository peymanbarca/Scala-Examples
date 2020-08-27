/**
  * Created by zevik on 8/27/20.
  */

object PureFunctionalProgram {
  def main(args: Array[String]): Unit = singleExpression(args.toList)

  def singleExpression: List[String] => (List[Int], List[Int]) = { a =>
    a map (_.toInt) partition (_ < 30)
  }
}