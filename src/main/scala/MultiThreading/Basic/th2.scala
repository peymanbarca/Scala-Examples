/**
  * Created by zevik on 3/24/20.
  */

class ThreadExample2 extends Runnable{
  override def run(){
    println("Thread is running...")
  }
}
object MainObjectTh2{
  def main(args:Array[String]){
    var e = new ThreadExample2()
    var t = new Thread(e)
    t.start()
  }
}