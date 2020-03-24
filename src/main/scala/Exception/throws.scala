/**
  * Created by zevik on 3/24/20.
  */

class ExceptionExample4{
  @throws(classOf[NumberFormatException])
  def validate()={
    "abc".toInt
  }
}

object MainObjectEx1{
  def main(args:Array[String]){
    var e = new ExceptionExample4()
    try{
      e.validate()
    }catch{
      case ex : NumberFormatException => println("Exception handeled here")
    }
    println("Rest of the code executing...")
  }
}