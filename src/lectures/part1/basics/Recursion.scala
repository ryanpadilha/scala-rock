package lectures.part1.basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else {
      println("computing factorial of " + n +" - I first need factorial of "+ (n-1))
      val result = n * factorial(n-1)
      println("computed factorial of " + n)

      result
    }

  }

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factorialHelper(x: Int, accumulator: BigInt): BigInt = {
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator) // tail recursion = use recursive call as the LAST expression
    }

    factorialHelper(n, 1)
  }

  println(factorial(10))
//  println(factorial(50000))

  // anotherFactorial(10) = factorialHelper(n, 1)
  // = factorialHelper(9, 10 * 1)

  println(anotherFactorial(50000))

  // when you need loops use tail recursion
  

}
