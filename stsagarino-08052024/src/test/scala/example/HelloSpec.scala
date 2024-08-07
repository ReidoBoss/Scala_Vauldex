package example

import collection.mutable.Stack
import org.scalatest.flatspec.AnyFlatSpec

// Write a function that takes an array of numbers (integers for the tests) and a target number. It should find two different items in the array that, when added together, give the target value. The indices of these items should then be returned in a tuple / list (depending on your language) like so: (index1, index2).

// For the purposes of this kata, some tests may have multiple answers; any valid solutions will be accepted.

// The input will always be valid (numbers will be an array of length 2 or greater, and all of the items will be numbers; target will always be the sum of two different items from that array).

// expected:
// twoSum(List(1, 2, 3), 4) // (0, 2) or (2, 0)
// twoSum(List(3, 2, 4), 6) // (1, 2) or (2, 1)
//0. zip with indexes
//1. get the current index 
// if current index is same, ignore
//2. iterate every element with a statement if curr == elem :Boolean
//3. if true get indexes
//4. if false go next index


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



def func1 =
  for 
    i <- f1
    i2 <- f2
  yield 1+i2.get


// #2: Get the result of f1 + f2 + f3
def func2 = 
  for 
    i <- f1
    i2 <- f2
    i3 <- f3
  yield 1+i2.get+i3.getOrElse(0)
// #3: Get sum total of f4
def func3=
  for
    i <- f4
  yield i.sum
// #4: Get sum total of f4 and f5
def func4 = 
  def isEmpty(seq:Seq[Int])=
    if (seq.isEmpty) 0 else seq.sum
  for
    i <- f4
    i2 <- f5
  yield i.sum + isEmpty(i2)


class Func1 extends AnyFlatSpec{
  "Func1 " should "pass basic test" in {
    val expected = 11    

    func1.onComplete{
      case Success(x) => assertResult(expected,"\nInput: $x")(x)
      case Failure(e)=> e.printStackTrace

    }
  }
}
class Func2 extends AnyFlatSpec{
  "func2 " should "pass basic test" in {
    val expected = 11    

    func2.onComplete{
      case Success(x) => assertResult(expected,"\nInput: $x")(x)
      case Failure(e)=> e.printStackTrace

    }
  }
}

class Func3 extends AnyFlatSpec{
  "func3 " should "pass basic test" in {
    val expected = 55    

    func3.onComplete{
      case Success(x) => assertResult(expected,"\nInput: $x")(x)
      case Failure(e)=> e.printStackTrace

    }
  }
}

class Func4 extends AnyFlatSpec{
  "func4 " should "pass basic test" in {
    val expected = 55    

    func4.onComplete{
      case Success(x) => assertResult(expected,"\nInput: $x")(x)
      case Failure(e)=> e.printStackTrace

    }
  }
}
