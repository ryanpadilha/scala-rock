package lectures.part3.functional

object PatternsEverywhere extends App {

  // 1.
  try {
    // code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something"
  }

  // catches are actually matches
  /*
    try {
    // code
    } catch (e) {
      e match {
        case e: RuntimeException => "runtime"
        case npe: NullPointerException => "npe"
        case _ => "something"
      }
    }
   */

  val list = List(1,2,3,4)
  val evenOnes = for {
    x <- list if x % 2 == 0 // ?!
  } yield 10 * x

  // generators are also based on PATTERN MATCHING
  val tuples = List((1,2), (3,4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  // case classes, :: operatos, ...

  // 3.
  val tuple = (1,2,3)
  val (a, b, c) = tuple
  println(b)
  // multiple value definition based on PATTERN MATCHING
  // ALL THE POWER

  val head :: tail = list
  println(head)
  println(tail)

  // 4. new
  // partial function
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  } // partial function literal

  // are equivalent
  val mappedList2 = list.map { x => x match {
      case v if v % 2 == 0 => v + " is even"
      case 1 => "the one"
      case _ => "something else"
    }
  }

  println(mappedList)


}
