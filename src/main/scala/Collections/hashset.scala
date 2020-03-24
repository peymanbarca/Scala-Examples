/**
  * Created by zevik on 3/24/20.
  */

import scala.collection.immutable.HashSet
object MainObjectHashset{
  def main(args:Array[String]){
    var hashset = HashSet(4,2,8,0,6,3,45)
    hashset.foreach((element:Int) => println(element+" "))
  }
}