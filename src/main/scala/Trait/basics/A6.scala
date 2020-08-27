package Trait.basics

/**
  * Created by zevik on 8/27/20.
  */
class A6 extends Printable2 with Showable2{
  def print(){
    println("This is printable")
  }
  def show(){
    println("This is showable");
  }
}
