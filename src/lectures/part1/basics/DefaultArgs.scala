package lectures.part1.basics

object DefaultArgs extends App {

  def trFactorial(n: Int, acc: Int = 1): Int = {
    if (n <= 1) acc
    else trFactorial(n - 1, n * acc)
  }

  val fact10 = trFactorial(10)
  val fact10_2 = trFactorial(10, 2)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")
  savePicture(width = 800)

}
