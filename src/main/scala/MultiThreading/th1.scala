/**
  * Created by zevik on 3/24/20.
  */

class ThreadExample extends Thread{
  override def run(){
    println("Thread is running...");
  }
}
object MainObjectTh1{
  def main(args:Array[String]){
    var t = new ThreadExample()
    t.start()
  }
}