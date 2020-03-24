/**
  * Created by zevik on 3/24/20.
  */

class A{
  var salary1 = 10000
}

class B extends A{
  var salary2 = 20000
}

class C extends B{
  def show(){
    println("salary1 = "+salary1)
    println("salary2 = "+salary2)
  }
}

object MainObjectClass5 {
  def main(args: Array[String]) {
    {
      var c = new C()
      c.show()

    }
  }
}