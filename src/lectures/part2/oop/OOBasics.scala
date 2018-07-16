package lectures.part2.oop

object OOBasics extends App {

  val person = new Person("John", 34)
  println(person)
  println(person.age)

  println(person.x)
  person.greet("Ryan")
  person.greet()

  // 1.
  val author = new Writer("Charles", "Dickens", 1812)
  val impostor = new Writer("Charles", "Dickens", 1812)

  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(impostor))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
  counter.inc(10).print


}

// class parameters are not fields
// to create a field member declare a val prefix

// constructor
class Person(name: String, val age: Int) {
  // fields
  val x = 2

  // methods
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name!")

  // overloading
  def greet(): Unit = println(s"Hi, I am $name") // this is equal to ${this.name}

  // multiple constructors
  // the constructor must call another constructor, its a limitation
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")

}

//
// 1. Novel and Writer
//
// writer: first name, surname, year
// - method fullname
//
// novel: name, year of release, author
// - authorAge
// - isWrittenBy(author)
// - copy (new year of release) - new instance of novel

class Writer(firstName: String, surname: String, val year: Int) {
  def fullname = firstName + " " + surname
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

// 2.counter class
// - receives an int value
// - method current count
// - method to increment/decrement => new counter
// - overload inc/dec to receive an amount

class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1) // immutability
  }

  def dec = {
    println("decrementing")
    new Counter(count - 1)
  }

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }

  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n -1)
  }

  def print = println(count)

}
