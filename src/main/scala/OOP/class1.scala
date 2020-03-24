/**
  * Created by zevik on 3/24/20.
  */

class Student1(id:Int, name:String){     // Primary constructor
  def show(){
    println(id+" "+name)
  }
}

class Arithmetic{
  def add(a:Int, b:Int){
    var add = a+b;
    println("sum = "+add);
  }
}

object MainObjectClass1{
  def main(args:Array[String]){
    var s = new Student1(100,"Martin")   // Passing values to constructor
    s.show()                // Calling a function by using an object
    new Arithmetic().add(10,10);
  }
}