/**
  * Created by zevik on 3/24/20.
  */

class ArrayExample1{
  var arr = Array(1,2,3,4,5)      // Creating single dimensional array
  def show(){
    for(a<-arr)                       // Traversing array elements
      println(a)
    println("Third Element  = "+ arr(2))        // Accessing elements by using index
  }
}

object MainObjectAr1{
  def main(args:Array[String]){
    var a = new ArrayExample1()
    a.show()
  }
}