package lectures.part1.basics

object CBNvsCBV extends App {

  // call by value:
  // value is computed before called
  // same value used everywhere
  //
  // expression is evaluate once one time - equal to imperative languages

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  // called by name (reference):
  // expression is passed literally
  // expression is evaluated at every use within
  //
  // expression is evaluate every time its called
  // used in lazy streams

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  println(calledByValue(System.nanoTime()))
  println(calledByName(System.nanoTime()))

  // testing
  def infinitive(): Int = 1 + infinitive()
  def printFirst(x: Int, y: => Int) = println(x)

//  printFirst(infinitive(), 34) // this throw an exception, because evaluate a infinitive first
  printFirst(34, infinitive())

}
