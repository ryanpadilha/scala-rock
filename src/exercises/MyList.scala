package exercises

abstract class MyList[+A] {

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

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]

  def printElements: String

  // polymorphic call
  override def toString: String = "[" + printElements + "]"

  // // higher-order functions
  def map[B] (transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]
}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)

  def printElements: String = ""

  //
  def map[B] (transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty

  def ++[B >: Nothing](list: MyList[B]): MyList[B] = list
}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String =
    if (t.isEmpty) "" + h
    else h + " " + t.printElements

  /*
    [1,2,3].filter(n % 2 == 0) =
      [2,3].filter(n % 2 == 0) =
      = new Cons(2, [3].filter(n % 2 == 0)
      = new Cons(2, Empty.filter(n % 2 == 0)
      = new Cons(2, Empty)
   */
  override def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)

  /*
    [1,2,3].map(n * 2)
      = new Cons(2, [2,3].map(n * 2))
      = new Cons(2, new Cons(4, [3].map(n * 2))
      = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
      = new Cons(2, new Cons(4, new Cons(6, Empty))))
   */
  override def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))

  /*
    [1,2] ++ [3,4,5]
    = new Cons(1, [2] ++ [3,4,5])
    = new Cons(1, new Cons(2, Empty ++ [3,4,5]))
    = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
   */
  override def ++[B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  /*
    [1,2].flatMap(n => [n, n+1])
    = [1,2] ++ [2].flatMap(n => [n, n+1])
    = [1,2] ++ [2,3] ++ Empty.flatMap(n => [n, n+1])
    = [1,2] ++ [2,3] ++ Empty
    = [1,2,2,3]
   */
  override def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)
}

// as a function language, theses traits does not make sense
/*
trait MyPredicate[-T] {
  def test(element: T): Boolean
}

trait MyTransform[-A, B] {
  def transform(element: A): B
}
*/


object ListTest extends App {
  /*
  val list = new Cons(1, Empty)
  println(list.head)

  val list1 = new Cons(1, new Cons(2, new Cons(3, Empty)))
  println(list1.tail.head)
  println(list1.add(4).head)
  println(list1.isEmpty)
  println(list1.toString)
  */

  val listOfInterger = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val anotherlistOfInterger = new Cons(4, new Cons(5, new Cons(6, Empty)))
  val listOfStrings = new Cons("hello", new Cons("Scala", Empty))

  println(listOfInterger.toString)
  println(listOfStrings.toString)

  val listTransform = listOfInterger.map(new Function1[Int, Int] {
    override def apply(element: Int): Int = element * 2
  })

  println(listOfInterger.toString)

  val listPredicate = listOfInterger.filter(new Function1[Int, Boolean] {
    override def apply(element: Int): Boolean = element % 2 == 0
  })

  println(listPredicate.toString)
  println(listOfInterger ++ anotherlistOfInterger)

  val listFilterMap = listOfInterger.flatMap(new Function1[Int, MyList[Int]] {
    override def apply(element: Int): MyList[Int] = new Cons(element, new Cons(element + 1, Empty))
  })

  println(listFilterMap.toString)


}