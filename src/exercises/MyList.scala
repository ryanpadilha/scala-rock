package exercises

abstract class MyList {

  // Scala offers class-based inheritance
  // access modifiers: private, protected, (none=public)
  // need to pass in constructor arguments to parent class
  //
  // Derived classes can override members or methods
  // Reuse parent fields/methods with super
  // Prevent inheritance with final and sealed
  // abstract classes
  // traits
  // inheritance from a class and multiple traits


  /**
    * head - first element of the list
    * tail - remainder of the list
    * isEmpty - is this list empty
    * add(int) - new list with this element added
    * toString - a string reprensentation of the list
    */

  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(element: Int): MyList

  def printElements: String

  // polymorphic call
  override def toString: String = "[" + printElements + "]"
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException
  def tail: MyList = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add(element: Int): MyList = new Cons(element, Empty)

  def printElements: String = ""
}

class Cons(h: Int, t: MyList) extends MyList {
  def head: Int = h
  def tail: MyList = t
  def isEmpty: Boolean = false
  def add(element: Int): MyList = new Cons(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements
}

object ListTest extends App {
  val list = new Cons(1, Empty)
  println(list.head)

  val list1 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list1.tail.head)
  println(list1.add(4).head)
  println(list1.isEmpty)

  println(list1.toString)

}