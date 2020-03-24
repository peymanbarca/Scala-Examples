/**
  * Created by zevik on 3/24/20.
  */

/*
* Scala Thread join() Method Example
The join() method waits for a thread to die. In other words, The join() method is used to hold the execution of currently running thread until the specified thread finished it's execution.
* */

class ThreadExample4 extends Thread{
  override def run(){
    for(i<- 0 to 5){
      println(i)
      Thread.sleep(500)
    }
  }

}
object MainObjectTh4{
  def main(args:Array[String]){
    var t1 = new ThreadExample4()
    var t2 = new ThreadExample4()
    var t3 = new ThreadExample4()
    t1.start()
    t1.join()
    t2.start()
    t3.start()
  }
}