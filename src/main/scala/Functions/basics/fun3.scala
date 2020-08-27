package Functions.basics

/**
  * Created by zevik on 3/24/20.
  */


//Scala Example: Function Composition

object MainObjectFun3 {
  def main(args: Array[String]) = {
    var result = multiplyBy2(add2(10))      // Function composition
    println(result)
  }
  def add2(a:Int):Int = {
    a+2
  }

  def multiplyBy2(a:Int):Int = {
    a*2
  }
}
