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

//  println(anotherFactorial(50000))

  // when you need loops use tail recursion

  //
  // 1. concatenate a string n times
  @tailrec
  def concatenateTailRec(aString: String, n: Int, accumulator: String): String = {
    if (n <= 0) accumulator
    else concatenateTailRec(aString, n-1, aString + accumulator)
  }

  println(concatenateTailRec("hello ", 3, ""))

  // 2. IsPrime function tail recursive

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeTailRec(t: Int, isStillPrime: Boolean): Boolean = {
      if (!isStillPrime) false
      else if (t <= 1) true
      else isPrimeTailRec(t - 1, n % t != 0 && isStillPrime)
    }

    isPrimeTailRec(n / 2, true)
  }

  println(isPrime(2003))
  println(isPrime(629))

  // 3. fibonacci function, tail recursive

  def fibonacci(n: Int): Int = {
    def fibonacciTailRec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fibonacciTailRec(i + 1, last + nextToLast, last)
    }

    if (n <= 2) 1
    else fibonacciTailRec(2, 1, 1)
  }

  println(fibonacci(8))
  

}
