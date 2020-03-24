/**
  * Created by zevik on 3/24/20.
  */

class Vehicle{
  def run(){
    println("vehicle is running")
  }
}

class Bike2 extends Vehicle{
  override def run(){
    println("Bike is running")
  }
}

object MainObjectClass6{
  def main(args:Array[String]){
    var b = new Bike2()
    b.run()
  }
}