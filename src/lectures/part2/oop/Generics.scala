package lectures.part2.oop

import com.sun.corba.se.impl.orbutil.concurrent.CondVar

object Generics extends App {

  // trait can have a generic type

  class MyList[A] {
    // use the type A
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
  val animalList: Convariant[Animal] = new CovariantList[Cat]
  // animalList.add(new Dog) - HARD QUESTION

  // 2. no - INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // 3. HELL, no! Contravariance
  class Trainer[-A]
  val trainer: Trainer[Cat] = Trainer[Animal] // makes sense

  // bounded types
  


}
