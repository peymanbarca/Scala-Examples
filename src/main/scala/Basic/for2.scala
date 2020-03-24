/**
  * Created by zevik on 3/24/20.
  */

object MainObjectf2 {
  def main(args: Array[String]) {
    var list = List(1,2,3,4,5,6,7,8,9)          // Creating a list
    for( i <- list){                         // Iterating the list
      println(i)
    }

    list.foreach((element:Int)=>print(element+" "))      // Explicitly mentioning type of elements

  }
}