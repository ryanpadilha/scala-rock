package lectures.part3.functional

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  /*
    RESUME
    Use Try to handle exceptions gracefully:
    - avoid runtime crashes due to uncaught exceptions
    - avoid endless amount of try-catches

    A functional way of dealing with features
    - map, flatMap, filter
    - orElse
    - others: fold, collect, toList, convertion to Options

    if you design a method to return a (some type) but may throw an
    exception, return Try[that type] instead.

   */

  // create a success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("super failure"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("not string for you")

  // Try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // syntax sugar
  val anotherPotentialFailure = Try {
    // code that might noew
  }

  // utilities
  println(potentialFailure.isSuccess)

  // orElse
  def backupMethod(): String = "A valid backup"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

  // if you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A valid result")
  val betterFallBack = betterUnsafeMethod() orElse betterBackupMethod()

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))
  // for-comprehensions

  /*
    Exercices
   */
  val host = "localhost"
  val port = "8080"
  def renderHtml(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean) "<html>...</html>"
      else throw new RuntimeException("the connection is interruped")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean) new Connection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSaveConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  // if get the html page from connection, print it to console. i.e. call renderHTML
  val possibleConnection = HttpService.getSaveConnection(host, port)
  val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/htme"))
  possibleHTML.foreach(renderHtml) // render html or not

  // shorthand version - chained calls
  HttpService.getSaveConnection(host, port)
      .flatMap(connection => connection.getSafe("/home"))
      .foreach(renderHtml)

  // for-comprehension
  for {
    connection <- HttpService.getSaveConnection(host, port)
    html <- connection.getSafe("/home")
  } renderHtml(html)

  /*
    Imperative language

    try {
      connection = HttpService.getConnection(host, port)
      try {
        page = connection.get("/home")
        renderHTML(page)
      } catch (some exception) {

    } catch (exception) {

    }
  */



}
