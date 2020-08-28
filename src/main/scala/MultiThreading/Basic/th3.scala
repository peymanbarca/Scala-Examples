/**
  * Created by zevik on 3/24/20.
  */

class ThreadExample3 extends Thread{
  override def run(){
    for(i<- 0 to 5){
      println(i)
      Thread.sleep(500)
    }
  }

}

object MainObjectTh3{
  def main(args:Array[String]){
    var t1 = new ThreadExample3()
    var t2 = new ThreadExample3()
    t1.start()
    t2.start()
  }
}