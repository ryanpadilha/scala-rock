package lectures.part1.basics

object ValuesVariablesTypes extends App {

  // vals are immutable
  val x: Int = 42
  println(x)

  // compile can infer types
  val aString: String = "value"
  val aBoolean: Boolean = true
  val aChar: Char = 'c'

  val aInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 52245454212121L

  val aFloat: Float = 2.0F
  val aDouble: Double = 4.0

  // variables have side effects
  var aVariable: Int = 4
  aVariable = 5



}
