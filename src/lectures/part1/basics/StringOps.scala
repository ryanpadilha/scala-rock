package lectures.part1.basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala language"

  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length)

  // number operations with string
  val aNumberString = "2"
  val aNumber = aNumberString.toInt

  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // scala-specific: String Interpolations

  // S-interpolators
  val name = "Ryan"
  val age = 22
  val greeting = s"Hi my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${ age + 1 } years old"

  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2F
  val myth = f"$name can eat $speed%2.2f burgers per minute"

  println(myth)

  // raw interpolator
  println(raw"This is a \n new line")
  val escaped = "This is a \n new line"
  println(raw"$escaped")

}
