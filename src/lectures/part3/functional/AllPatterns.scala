package lectures.part3.functional

import exercises.{Cons, Empty, MyList}

object AllPatterns extends App {

  // 1. constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "A number"
    case "Scala" => "The Scala"
    case true => "The thruth"
    case AllPatterns => "A singleton object"
  }

  // 2. match anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ =>
  }

  // 2.2 variable
  val matchAVariable = x match {
    case something => s"Ive found $something"
  }

  // 3. tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1,1) =>
    case (something, 2) => s"Ive found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchNestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }

  // PMs can be nested!

  // 4. case classes - constructor patterns
  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
  val matchAList = aList match {
    case Empty =>
    case Cons(head, tail) =>
  }

  // 5. list patterns
  val aStandartList = List(1,2,3,42)
  val aStandartMathing = aStandartList match {
    case List(1, _, _, _) => // extractor - advanced
    case List(1, _*) => // list of arbitrary length - avanced
    case 1 :: List(_) => // infix pattern
    case List(1,2,3) :+ 42 => // infix pattern
  }

  // 6. type specifiers
  val unknown: Any = 2
  val unknownMath = unknown match {
    case list: List[Int] => // explicit type specifier
    case _ =>
  }

  // 7. naming binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => // name binding -  use the name later(here)
    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested patterns
  }

  // 8. multi-patterns
  val multiPattern = aList match {
    case Empty | Cons(0, _) => // compound pattern (multi-pattern)
  }

  // 9. if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
  }

  //

}
