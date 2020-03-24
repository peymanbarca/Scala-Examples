/**
  * Created by zevik on 3/24/20.
  */


object MainObjectPM {
  def main(args: Array[String]) {
    var result = search ("Hello")
    print(result)
  }
  def search (a:Any):Any = a match{
    case 1  => println("One")
    case "Two" => println("Two")
    case "Hello" => println("Hello")
    case _ => println("No")

  }
}
