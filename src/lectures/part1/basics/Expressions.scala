package lectures.part1.basics

object Expressions extends App {

  val x = 1 + 2 // expression
  println(x)

  println(2 + 3 * 4)
  println(1 == x)

  var aVariable = 2
  aVariable += 3
  println(aVariable)

  // Instructions (DO -- imperative languages) vs Expressions (VALUE -- compute a expression-value)
  // if-expression
  val aConditional = true
  val aConditionalValue = if (aConditional) 5 else 3

  println(aConditionalValue)

  // loops is used more in imperative languages
  // never write this again
  var i = 0
  while(i < 10) {
    println(i)
    i += 1
  }

  // everything in scala is an Expression!
  val aWeirdValue = (aVariable = 3) // Unit == void - is a special type in Scala
  println(aWeirdValue)

  // side effects - println(), whiles, reassigning

  // code blocks
  val aCodeBlock = {
    val y = 2
    val z = y +1
    if (z > 2) "hello" else "goog bye"
  }

  // 1. difference between "hello" - String vs println("hello") - Unit


}
