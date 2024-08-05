package example
import Printer.{pln as println, p as print}

// import scala.concurrent.Future
// import scala.concurrent.ExecutionContext.Implicits.global
// import scala.util.{Failure, Success}

// def longRunningAlgorithm() =
//   Thread.sleep(10_000)
//   42
// @main def stsagarino =
//   val eventualInt = Future(longRunningAlgorithm())

//   Future(longRunningAlgorithm()).onComplete {
//     case Success(value) => println(s"Got the callback, value = $value")
//     case Failure(e) => e.printStackTrace
//   }

// import scala.concurrent.Future
// import scala.concurrent.ExecutionContext.Implicits.global
// import scala.util.{Failure, Success}

// val startTime = System.currentTimeMillis()
// def delta() = System.currentTimeMillis() - startTime
// def sleep(millis: Long) = Thread.sleep(millis)

// def delayedTime = Thread.sleep(10000)
// @main def multipleFutures1 =
//   val futureTest = Future{delayedTime; 1}

//------------------------------------------------------------------------------------------------------------------------------------//
  // println(s"creating the futures:   ${delta()}")

  // // (1) start the computations that return futures
  // val f1 = Future { sleep(800); 1 }   // eventually returns 1
  // val f2 = Future { sleep(200); 2 }   // eventually returns 2
  // val f3 = Future { sleep(400); 3 }   // eventually returns 3

  // // (2) join the futures in a `for` expression
  // val result =
  //   for
  //     r1 <- f1
  //     r2 <- f2
  //     r3 <- f3
  //   yield
  //     println(s"in the 'yield': ${delta()}")
  //     r1 + r2 + r3

  // // (3) process the result
  // result.onComplete {
  //   case Success(x) =>
  //     println(s"in the Success case: ${delta()}")
  //     println(s"result = $x")
  //   case Failure(e) =>
  //     e.printStackTrace
  // }

  // println(s"before the 'sleep(3000)': ${delta()}")


  // // important for a little parallel demo: keep the jvm alive
  // sleep(3000)


/* 
Instructions:
  - Fulfill the requirements below.
  - Create Test specs first and submit them on or before the given time.
  - Then, create your solutions and modify the test specs as you please.

Submission:
  - Create a scala sbt project and name it as `<yourid>-08052024`
    - for the first version (test spec only), name your project as `<yourid>-08052024-test`
  - Once your finished, clean your project by running `sbt clean` or you may remove the `/target` directory.
  - Make sure the project you're about to submit is compilable.

  Cosidering the code below, in the main method, write the methods to implement the following:

  #1 A method that returns the result of f1 + f2

  #2 A method that returns the result of f1 + f2 + f3

  #3 A method that gets the sum total of f4

  #4 A method that gets the sum total of f4 and f5

  #5 A method that gets the transforms f4 to `Future[Seq[Int], Seq[Int]]` as `Future((Range 1 to 5, Range 6 to 10))`
*/

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

def f1: Future[Int] = Future.successful(1)
def f2: Future[Option[Int]] = Future.successful(Some(10))
def f3: Future[Option[Int]] = Future.successful(None)
def f4: Future[Seq[Int]] = Future.successful(1 to 10)
def f5: Future[Seq[Int]] = Future.successful(Nil)
def f6: Future[Option[Seq[Int]]] = Future.successful(Some(1 to 10))
def f7: Future[Option[Seq[Int]]] = Future.successful(None)
def f8: Future[Seq[Option[Int]]] = Future.successful(Seq(Some(100), Some(1000), None))
def f9: Future[Option[Future[Int]]] = Future.successful(Some(Future.successful(1)))
def f10: Future[Seq[Future[Int]]] = Future.successful((1 to 10).map(Future.successful))


@main def test =
  // #1 Get the result of f1 + f2
  def res1 =
    for 
      i <- f1
      i2 <- f2
    yield 1+i2.get

  
  // #2: Get the result of f1 + f2 + f3
  def re2 = 
    for 
      i <- f1
      i2 <- f2
      i3 <- f3
    yield 1+i2.get+i3.getOrElse(0)
  // #3: Get sum total of f4
  def res3=
    for
      i <- f4
    yield i.sum
  // #4: Get sum total of f4 and f5
  def res4 = 
    def isEmpty(seq:Seq[Int])=
      if (seq.isEmpty) 0 else seq.sum
    for
      i <- f4
      i2 <- f5
    yield i.sum + isEmpty(i2)

  // // #5 Transform f4 to `Future[Seq[Int], Seq[Int]]` as `Future((Range 1 to 5, Range 6 to 10))`
  // def func5=
  //   for
  //     i <- f4
  //   yield Future{i.group(2).toRange}

