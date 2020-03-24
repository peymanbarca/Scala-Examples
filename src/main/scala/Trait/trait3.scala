/**
  * Created by zevik on 3/24/20.
  */

trait Print{
  def print()
}

abstract class PrintA44{
  def printA4()
}

class A66 extends PrintA44 {
  def print(){                             // Trait print
    println("print sheet")
  }
  def printA4(){                              // Abstract class printA4
    println("Print A4 Sheet")
  }
}

object MainObjectT3{
  def main(args:Array[String]){
    var a = new A66() with Print             // You can also extend trait during object creation
    a.print()
    a.printA4()
  }
}