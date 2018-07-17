package lectures.part2.oop

object CaseClasses extends App {

  case class Person(name: String, age: Int)

  // RESUME
  /*
    - Quick lightweight data structures with little boilerplate
    - Companions already implemented
    - Sensible equals, hashCode, toString
    - Auto-promoted params to fields
    - Cloning
    - case objects
   */

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntatic sugar
  println(jim)

  // 3. equals and hashCode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Case Classes have handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. Case Classes have companion objects
  // the compiler create automatic companion objects
  // to instantiate an object from a case classe, don't use new keyword, use apply() method
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. Case Classes are serializable
  // Akka

  // 7. Case Classes have extractor patterns - can be used in PATTERN MATCHING

  // In this case, we dont have a companion object
  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  // Expand MyList - use case classes and case objects


}
