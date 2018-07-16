package lectures.part2.oop

object Objects extends App {

  // scala DOES NOT have class level functionality ("static")

  // OBJECT does not have constructor, because acts in a class scope
  object Person { // type + its only instance
    // static/class level functionaliry
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method -- !! widely used in practice
    def apply(mother: Person, father: Person): Person = new Person("Bob")
  }

  class Person(val name: String) {
    // instance-level functionaliry
  }

  // companions --

  println(Person.N_EYES)
  println(Person.canFly)

  // scala OBJECT = SINGLETON INSTANCE
  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john) // false, are different objects

  val person1 = Person
  val person2 = Person
  println(person1 == person2) // true, are the same object (singleton)

  val bob = Person(mary, john)

  // scala applications = scala object with
  // def main(args: Array[String]): Unit

  /*
    --- RESUME ---
    Scala Objects
    - are in their own class
    - are the only instance
    - singleton pattern in one line

    Scala Companions
    - can access each other's private members
    - Scala is more OO than Java!
    - have the same scope(context)

    object Person
    class Person

    Scala applications
    - there are two options to represent a main method

    def main(args: Array[String]): Unit = {}
    object Objects extends App {}


  */


}
