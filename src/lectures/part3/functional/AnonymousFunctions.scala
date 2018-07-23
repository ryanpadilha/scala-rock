package lectures.part3.functional

object AnonymousFunctions extends App {

  // anonymous function (lambda)
  val doubler: Int => Int = (x: Int) => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // return a function like an objet
  println(justDoSomething()) // in lamdda functions we have to put the (), in a different way of no-args methods

  // curly braces with lambda
  var StringToInt = { (str: String) =>
    str.toInt
  }

  // MOAR syntatic sugar
  val niceIncrementer: Int => Int = _ + 1 // equivalant to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalant to (a,b) => a + b

  /*
    ** Exercises **
    1. MyList: replace all functionX calls with lambdas
    2. Rewrite the "special" adder as an anonymous function
   */

  val superAdder = (x: Int) => (y: Int) => x + y
  println(superAdder(3)(4))

}
