/**
  * Created by zevik on 3/24/20.
  */

/*
* Scala Trait
A trait is like an interface with a partial implementation. In scala, trait is a collection of abstract and non-abstract methods.
 You can create trait that can have all abstract methods or some abstract and some non-abstract methods.
* */

trait Printable{
  def print()
}

class A4 extends Printable{
  def print(){
    println("Hello")
  }
}

object MainObjectT1{
  def main(args:Array[String]){
    var a = new A4()
    a.print()
  }
}