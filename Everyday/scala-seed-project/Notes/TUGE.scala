///--------GIVENS, TYPECLASS, DEFAULTS--------///
// Problem 3: Default Value with Givens
// Task: Define a type class DefaultValue that provides a default value for different types. Implement a given instance for Double and Boolean. Create an extension method that uses the given instance to provide a default value for Option.
// Hints:
//   • Define a type class DefaultValue with a default method.
//   • Implement given instances for Double and Boolean.
//   • Create an extension method for Option that uses the DefaultValue type class.


trait DefaultValue[T] {
  def default: T
}

object DefaultValue{
  given DefaultValue[Int] with 
    def default:Int = 0
  given DefaultValue[Boolean] with 
    def default:Boolean = false
  given DefaultValue[Double] with
    def default:Double = 0.0
}

extension[T](opt:Option[T])
  def getOrElseDefault(using default:DefaultValue[T]):T=
    opt match {
      case None => default.default
      case Some(a) => a
    }

// // Import the extension methods


@main def stsagarino =

  val optDouble: Option[Double] = None
  val optBoolean: Option[Boolean] = None
  val optDoubleWithValue: Option[Double] = Some(3.14)
  val optBooleanWithValue: Option[Boolean] = Some(true)

  // Test cases
  assert(optDouble.getOrElseDefault == 0.0) // Default value for Double
  assert(optBoolean.getOrElseDefault == false) // Default value for Boolean
  assert(optDoubleWithValue.getOrElseDefault == 3.14) // Provided value
  assert(optBooleanWithValue.getOrElseDefault == true) // Provided value

  println("All tests passed!")


//------------------------------ORDERING--------------------------------------
// Problem 2: Extension Method for Finding Maximum Element
// Create an extension method for a sequence that finds the maximum element based on a given comparison function.

// Requirements:
//   • The extension method should work for any type.
//   • Use a given instance to provide the Ordering operations.

// Hints:
//   • You can use the Ordering type class provided by Scala.

extension[A](list:List[A])
  def maxElement(using ord:Ordering[A]):A=
    list.max

//test case do not change
@main def stsagarino =
  val list = List(1, 5, 3, 9, 2)
  println(list.maxElement) // Output: 9

  val stringList = List("apple", "banana", "cherry")
  println(stringList.maxElement) // Output: cherry

  //-----------------------------------------------NUMERIC--------------------------------------------------------------
// Problem 1: Extension Method for Summing Elements
// Create an extension method for a sequence of numbers that calculates the sum of its elements.

// Requirements:
//   • The extension method should work for any numeric type (e.g., Int, Double).
//   • Use a given instance to provide the Numeric operations.

// Hints:
//   • You can use the Numeric type class provided by Scala.

// Example:

extension[T](list:Seq[T])
  def sumElements(using num:Numeric[T]):T = 
    list.sum //Numeric has the implicits
//test case
@main def stsagarino = 
  val list = List(1, 2, 3, 4)
  println(list.sumElements) // Output: 10



import Printer.{printerln as println, printer as print}

// Functor is with a map method that applies a given function to a value it contains, resulting in a new Functor of the same type class.

// Implement a type class named Functor that includes a map method that applies a given function to a value it contains, resulting in a new Functor of the same type class, and instances of the type class for option and list.

trait Functor[T[_]]:
  def map[A,B](value:T[A])(f:A=>B):T[B]

object Functor:
  given Functor[Option] with
    def map[A,B](value:Option[A])(f:A=>B):Option[B]=
      value match {
        case None => None
        case Some(a) => Some(f(a)) 
      }
  given Functor[List] with
    def map[A,B](value:List[A])(f:A=>B):List[B]=
      value match {
        case Nil => Nil
        case list:List[A] => list.map(f) 
      }
// extension[T](opt:Option[T])(using func:Functor[Option])
//  def functorForOption[B](f:T=>B):Option[B]= 
//    func.map(opt)(f)


import Printer.{printerln as println, printer as print}


trait Show[A] {
  def show(a: A): String
}
@main def stsagarino =
  given Show[Int] = new Show[Int] {
    def show(a: Int): String = a.toString
  }

  implicit val stringShow: Show[String] = new Show[String] {
    def show(a: String): String = a
  }

  def printer[A](a: A)(implicit s: Show[A]): Unit = {
    println(s.show(a))
  }

  printer(123) // Output: 123
  printer("abc") // Output: abc
