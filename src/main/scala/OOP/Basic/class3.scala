/**
  * Created by zevik on 3/24/20.
  */

class Student3(name:String){
  def this(name:String, age:Int){
    this(name)
    println(name+" "+age)
  }
}

object MainObjectClass4{
  def main(args:Array[String]){
    var s = new Student3("Rama",100)
  }
}