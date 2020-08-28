/**
  * Created by zevik on 8/27/20.
  */


class Square(var side: Int) {
  def area = side * side
}

class PureSquare(val side: Int) {
  def newSide(s: Int): PureSquare = new PureSquare(s)
  def area = side * side
}

object FunctionalObject extends App {

  val s = new Square(10)
  println(s.area)
  s.side = 20
  println(s.area)

  val p1 = new PureSquare(10)
  println(p1.area)
  val p2 = p1.newSide(20)
  println(p2.area)
  println(p1.area)

}
