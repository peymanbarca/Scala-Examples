/**
  * Created by zevik on 3/24/20.
  */

trait Printable2{
  def print()
}

trait Showable2{
  def show()
}

class A6 extends Printable2 with Showable2{
  def print(){
    println("This is printable")
  }
  def show(){
    println("This is showable");
  }
}

object MainObjectT2{
  def main(args:Array[String]){
    var a = new A6()
    a.print()
    a.show()
  }
}