package lectures.part2.oop

object Exceptions extends App {

  val x: String = null
  // println(x.length)
  // throw new NullPointerException

  // 1. throwing and catching exceptions
  // its returns Nothing
  // val athrowValue = throw new NullPointerException

  // throwable classes extend the Throwable class
  // Exception (application error) and Error (system error) are the major Throwable subtypes

  // 2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No integer number for you")
    else 42


  val potentialFail = try {
    getInt(true)
  } catch {
    case e: RuntimeException => 43 // println("caught a Runtime exception")
  } finally {
    // code that will get executed NO MATTER WHAT
    // optional
    // does not influence the return type of this expression
    // use finally only for side effects
    println("finally")
  }

  println(potentialFail)

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException
  // throw exception

  /*
    ** Exercises **
    1. Crash your program with an OutOfMemoryError
    2. Crash with StackOverflowError
    3. PocketCalculator
      - add(x,y)
      - subtract(x,y)
      - multiply(x,y)
      - divide(x,y)

      Throw
        - OverFlowException if add(x,y) exceeds Int.MAX_VALUE
        - UnderFlowException if subtract(x,y) exceeds Int.MIN_VALUE
        - MathCalculationException for division by 0
   */

  // java.lang.OutOfMemoryError: Requested array size exceeds VM limit
  // val array = Array.ofDim(Int.MaxValue)

  // java.lang.StackOverflowError
  def infinite: Int = 1 + infinite
  // val noLimit = infinite

  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalculationException extends RuntimeException("division by 0")

  object PocketCalculator {
    def add(x: Int, y: Int): Int = {
      val result = x + y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }

    def subtract(x: Int, y: Int): Int = {
      val result = x + y

      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Int = {
      val result = x * y

      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int): Int = {
      if (y == 0) throw new MathCalculationException
      else x / y
    }
  }

  println(PocketCalculator.add(1, 10))
  // println(PocketCalculator.add(Int.MaxValue, 10))
  // println(PocketCalculator.divide(2, 0))

}
