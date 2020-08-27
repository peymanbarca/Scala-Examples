package Trait.basics

/**
  * Created by zevik on 8/27/20.
  */
object MainObjectT3{
  def main(args:Array[String]){
    var a = new A66() with Print             // You can also extend trait during object creation
    a.print()
    a.printA4()
  }
}
