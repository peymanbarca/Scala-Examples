import scala.collection.mutable.ArrayBuffer

/**
  * Created by zevik on 8/27/20.
  */



object InsertionSortExample extends App {
  def insertionSort[A <% Ordered[A]](elements: ArrayBuffer[A]): ArrayBuffer[A] = {
    for(firstOutOfOrder <- (1 until elements.length)) {
      if(elements(firstOutOfOrder) < elements(firstOutOfOrder - 1)) {
        val temp = elements(firstOutOfOrder)
        var location = firstOutOfOrder
        do {
          elements(location) = elements(location - 1)
          location -= 1
        } while(location > 0 && elements(location - 1) > temp)
        elements(location) = temp
      }
    }
    elements
  }

  println(insertionSort(ArrayBuffer(4, 3, 10, 5)))
}