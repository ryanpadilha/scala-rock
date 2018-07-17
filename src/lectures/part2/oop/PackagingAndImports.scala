package lectures.part2.oop

import playground.{Cinderela => Princess, PrinceCharming}

object PackagingAndImports extends App {

  // package object
  sayHello
  println(SPEED_OF_FLIGHT)

  val princess = new Princess
  val prince = new PrinceCharming

  // default packaging
  // java.lang - String, Object, Exception
  // scala - Int, Nothing, Function
  // scala.Predef - println, ???

}
