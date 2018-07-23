package lectures.part3.functional

object MapFlatMapFilterFor extends App {

  val list = List(1,2,3)
  println(list.head) // head of the list
  println(list.tail) // tail of the list

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatmap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  // print all combinations of two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colors = List("black", "white")
  // List("a1", "a2".... "d4")

  val combinations = numbers.flatMap(n => chars.flatMap(c => colors.map(color => "" + c + n + "-" + color) ))
  println(combinations)

  // foreach
  list.foreach(println)

  // for-comprehensions
  // this code below its the same combinations flatMap, but its more readable for beginners
  val forCombinations = for {
    n <- numbers if n % 2 == 0 // filter class for numbers
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  // syntax overload
  list.map {
    x => x * 2
  }

  /*
    1. MyList suport for comprehensions?
    2. A small collections of the most one element - Maybe[+T]
      - map, flatMap, filter
   */

}
