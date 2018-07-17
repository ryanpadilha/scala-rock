package lectures.part3.functional

object WhatsAFunction extends App {

  /*
    RESUME
    We want to work with functions:
      - pass functions as parameters
      - use functions as values

    Problem: Scala works on top of the JVM
      - designed for Java
      - first-class elements: objects(instance of classes)

    Solution: ALL Scala functions are objects!
      - function traits, up to 22 params

   */

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(4))

  // function types = Functional1[A, B]
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // functions types Function2[A, B, R] === (A,B) => R
  // ALL Scala functions are objects

  /*
    1. a function which takes 2 strings and concatenates them
    2. transform the MyPredicate and MyTransformer into function types
    3. define a function which takes an int and returns another which takes an int and returns an int
      - whats the type of this function
      - how to do it
   */

  def concatenator: (String, String) => String = new Function2[String, String, String] {
    override def apply(a: String, b: String): String = a + b
  }

  println(concatenator("hello ", "scala"))

  // 3.
  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Int => Int = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val adder3 = superAdder(3)
  println(adder3(4))
  println(superAdder(3)(8)) // curried functions


}

trait MyFunction[A, B] {
  def apply(element: A): B
}
