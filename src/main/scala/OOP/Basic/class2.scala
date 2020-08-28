/**
  * Created by zevik on 3/24/20.
  */


// Scala Secondary Constructor Example

class Student2(id:Int, name:String){
  var age:Int = 0
  def showDetails(){
    println(id+" "+name+" "+age)
  }
  def this(id:Int, name:String,age:Int){
    this(id,name)       // Calling primary constructor, and it is first line
    this.age = age
  }
}

object MainObjectClass3{
  def main(args:Array[String]){
    var s = new Student2(101,"Rama",20);
    s.showDetails()
  }
}
