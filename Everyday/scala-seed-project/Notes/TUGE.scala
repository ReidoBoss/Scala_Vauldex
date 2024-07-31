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