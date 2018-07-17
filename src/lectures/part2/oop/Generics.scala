package lectures.part2.oop

import com.sun.corba.se.impl.orbutil.concurrent.CondVar

object Generics extends App {

  // trait can have a generic type

  class MyList[+A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
      B is a super type of A

      A = cat
      B = Animal
     */
  }

  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // generic methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  val emptyListOfIntegers = MyList.empty[Int]

  // variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. yes, List[Cat] extends List[Animal] = COVARIANCE
  class CovariantList[+A]
  val animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) - HARD QUESTION: we return a list of animals

  // 2. no - INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. HELL, no! Contravariance
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal] // makes sense

  // bounded types
  // in the definition the class only accept subclass of Animal
  class Cage[A <: Animal](animal: Animal)
  val cage = new Cage(new Dog)

  // generic type needs proper bounded type
  // class Car
  // val newCage = new Cage(new Car)

  // expand MyList to be generic

  // trait List[+A] - yes covariant
  // trait List[A] - no (invariant) - default
  // trait List[-A] - hell no! (contravariant)

  // bounded types
  // An annoying variance problem


}
