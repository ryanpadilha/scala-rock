package lectures.part3.functional

import scala.util.Random

object Collections extends App {

  /*
    OVERVIEW

    Scala offers both mutable and immutable collections:
    - mutable collections can be updated in place
    - immutable collections never change

    - we are using the immutable collections by default

    package object scala {
      type List[+A] = immutable.List[A]
    }

    object Predef {
      type Map[A, +B] = immutable.Map[A, B]
      type Set[A] = immutable.Set[A]
    }

   */

  // seq
  // is actually a list
  val aSequence = Seq(1,2,3,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2)) // return from index

  println(aSequence++ Seq(7,5,6))
  println(aSequence.sorted)

  // ranges
  val aRange: Seq[Int] = 1 to 10 // collections 1..10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("hello")) // the same

  // lists
  val aList = List(1,2,3)
  val prepended = 42 +: aList :+ 89 //
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-|-")) // concatenate all elements to the string

  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)
  println(threeElements) // prints [Ljava.lang.String;@6108b2d7
  threeElements.foreach(println)

  // mutations
  numbers(2) = 0 // value index 2 update to 0 -- syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // arrays and seq
  val numbersSeq: Seq[Int] = numbers // implicit conversion
  println(numbersSeq) // prints WrappedArray(1, 2, 0, 4)

  // vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors vs list

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collections: Seq[Int]): Double = {
    val r = new Random()
    val times = for {
      it <- 1 until maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collections.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }

    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // keeps reference to tail
  // updating an element in the middle is slower
  // results - 7799376.216
  println(getWriteTime(numbersList))

  // depth of the tree is smal
  // needs to replace an entire 32-element chunk
  // results - 6072.049
  println(getWriteTime(numbersVector))


}
