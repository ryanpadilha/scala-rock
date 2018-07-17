package lectures.part2.oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("animal")
  }

  /*
    equivalent with

    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("animal")
    }

    val funnyAnimal: Animal = new AnonymousClasses$$anon$1
   */

  println(funnyAnimal.getClass) // class lectures.part2.oop.AnonymousClasses$$anon$1

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I help?")
  }

  println(jim.sayHi)

  // RESUME
  // anonymous class works with abstract and non-abstract classes
  //
  // we can instantiate types and override fields or methods on the spot
  //
  // Rules:
  // - pass in required constructor arguments if needed
  // - implement all abstract fields/methods
  //
  // works for traits and classes (abstract or not)

  /*
    * Exercises *

    1. Generic trait MyPredicate[-T] with a little method test(T) => boolean
    2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
    3. MyList:
      - map(transformer) => MyList
      - filter(predicate) => MyList
      - flatMap(transformer from A to MyList[B]) => MyList[B]

      class EvenPredicate extends MyPredicate[Int]
      class StringToIntTransformer extends MyTransformer[String, Int]

      [1,2,3].map(n * 2) => [2,4,6]
      [1,2,3,4].filter(n % 2) = [2,4]
      [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]

   */


}
