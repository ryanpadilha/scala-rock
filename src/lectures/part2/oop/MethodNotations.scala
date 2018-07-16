package lectures.part2.oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String) = movie == favoriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)
    def unary_! : String = s"$name, what the heck?!"
    def unary_+ : Person = new Person(name, favoriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie"
    def apply(n: Int): String  = s"$name watched $favoriteMovie $n times"

    def learns(thing: String): String = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  // (syntatic sugar) infix notation = operator notation, only works with single-one-arg methods
  println(mary likes "Inception") // equivalent

  // "operators" in scala languages
  val tom = new Person("Tom", "Fight Club")
  println(mary hangOutWith tom)

  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1 +(2))

  // all operators are methods
  // akka actors have ! ?


  // prefix notation
  val x = -1 // equivalent to 1.unary_-
  val y = 1.unary_-
  // unary_ prefix only works with - + ~ !

  println(!mary)
  println(mary.unary_!)

  // posfix notation
  println(mary.isAlive) // more used
  println(mary isAlive) // is more readable but introduce ambigous notation to us

  // apply
  println(mary.apply())
  println(mary()) // equivalent

  /*
    1. overload the + operator
    mary + "the rockstart" => new person "Mary (the rockstar)"

    2. Add an age to the Person class
    Add a unary + operator => new Person with the age + 1
    +mary => mary with the age incrementer

    3. Add a "learns" method in the Person class => "Mary learns Scala"
    Add a learnScala method, calls learn method with "Scala"
    Use it in postfix notation.

    4. Overload the apply method
    mary.apply(2) => "Mary watched Inception 2 times"
   */

  println((mary + "the rockstar")())
  println((mary + "the rockstar").apply()) // is the same

  println((+mary).age)

  println(mary learnsScala)
  println(mary(10))

}
