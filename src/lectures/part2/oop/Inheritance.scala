package lectures.part2.oop

object Inheritance extends App {

  // single class inheritance
  class Animal {
    val creatureType = "wild"
    protected def eat: Unit = println("nomnonmm")
  }

  class Cat extends Animal {
    def crunch() = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch()

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    // override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("eat - crunch, crunch")
    }
  }

  val dog = new Dog("domestic")
  dog.eat
  println(dog.creatureType)

  // type substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9-domestic")

  // preventing overrides
  // 1. use final on members - final def
  // 2. use final on class - final class
  // 3. seal the class - sealed class -- extend classes in this file, prevent extension in other files



}
