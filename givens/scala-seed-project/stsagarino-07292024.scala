import Printer.{printerln => println, printer => print}

///------------------------------------------------------------------------------------------------------------------------
// Problem 1: Extension Method for Summing Elements
// Create an extension method for a sequence of numbers that calculates the sum of its elements.

// Requirements:
//   • The extension method should work for any numeric type (e.g., Int, Double).
//   • Use a given instance to provide the Numeric operations.

// Hints:
//   • You can use the Numeric type class provided by Scala.

// Example:

// extension[T](list:Seq[T])
//   def sumElements(using num:Numeric[T]):T = 
//     list.sum //Numeric has the implicits
// //test case
// @main def stsagarino = 
//   val list = List(1, 2, 3, 4)
//   println(list.sumElements) // Output: 10

///------------------------------------------------------------------------------------------------------------------------
// Problem 2: Extension Method for Finding Maximum Element
// Create an extension method for a sequence that finds the maximum element based on a given comparison function.

// Requirements:
//   • The extension method should work for any type.
//   • Use a given instance to provide the Ordering operations.

// Hints:
//   • You can use the Ordering type class provided by Scala.

// extension[A](list:List[A])
//   def maxElement(using ord:Ordering[A]):A=
//     list.max

// //test case do not change
// @main def stsagarino =
//   val list = List(1, 5, 3, 9, 2)
//   println(list.maxElement) // Output: 9

//   val stringList = List("apple", "banana", "cherry")
//   println(stringList.maxElement) // Output: cherry
///------------------------------------------------------------------------------------------------------------------------

// Problem 3: Generic Filter Method

// Create an extension method for a sequence that filters elements based on a given predicate.

// Requirements:
//   • The extension method should work for any type.
//   • The method should use a generic type parameter.

// extension[A](list:List[A])
//   def filterElements(f:A=>Boolean):List[A]=
//     list match {
//       case Nil => Nil
//       case _ => list.filter(f)
//     }

// //test case
// @main def stsagarino = 
//   val list = List(1, 2, 3, 4, 5)
//   println(list.filterElements(_ % 2 == 0)) // Output: List(2, 4)

//   val stringList = List("apple", "banana", "cherry")
//   println(stringList.filterElements(_.startsWith("b"))) // Output: List("banana

///------------------------------------------------------------------------------------------------------------------------

// Problem 4: Default Value Extension Method

// Create an extension method for an Option that returns the contained value or a default value if the option is None.

// Requirements:
//   • The extension method should work for any type.
//   • Use a given instance to provide the default value.

// Hints:
//   • You can define a type class to provide the default value.
//template:
// trait DefaultValue[T] {
//   def default: T
// }

// object DefaultValue {
//   given DefaultValue[Int] with {
//     def default: Int = 0
//   }

//   given DefaultValue[String] with {
//     def default: String = ""
//   }
// }

// Define the type class
// trait DefaultValue[T] {
//   def default: T
// }

// object DefaultValue {
//   // Given instances for different types
//   given DefaultValue[Int] with {
//     def default: Int = 0
//   }

//   given DefaultValue[String] with {
//     def default: String = ""
//   }

//   // Add more given instances for other types if needed
// }

// // Define the extension method for Option
// extension [T](opt: Option[T])(using defaultValue: DefaultValue[T]) {
//     def getOrElseDefault: T = opt.getOrElse(defaultValue.default)
// }

// // Import the extension methods


// //test case 
// @main def stsagarino = 
//   val optInt: Option[Int] = None
//   println(optInt.getOrElseDefault) // Output: 0

//   val optString: Option[String] = None
//   println(optString.getOrElseDefault) // Output: ""

///------------------------------------------------------------------------------------------------------------------------

// Problem 5: Safe Division Extension Method

// Create an extension method for Int that performs a safe division, returning None if there is a division by zero.
// Requirements:

//   • The extension method should return an Option[Int].
//   • Use a given instance to provide the zero value.

// extension (x:Int)
//   def safeDiv(y:Int):Option[Int] =
//     y match {
//       case 0 => None
//       case _ => Some(x/y)
//     }

// //test case
// @main def stsagarino = 

//   val x = 10
//   println(x.safeDiv(2)) // Output: Some(5)
//   println(x.safeDiv(0)) // Output: None
///------------------------------------------------------------------------------------------------------------------------


// Problem 6: Transform and Filter Extension Method

// Create an extension method for a sequence that transforms elements using a given function and then filters them using another predicate.

// Requirements:

//   • The extension method should work for any type.
//   • The method should use generic type parameters.

// extension[A](list:List[A])
//   def transformAndFilter[B](t:A=>B,p:B=>Boolean)=
//     list.map(t).filter(p)


// // test case

// @main def stsagarino= 
//   val list = List(1, 2, 3, 4, 5)
//   println(list.transformAndFilter(_ * 2, _ > 5)) // Output: List(6, 8, 10)

//   val stringList = List("apple", "banana", "cherry")
//   println(stringList.transformAndFilter(_.toUpperCase, _.startsWith("A"))) // Output: List("APPLE")

// These problems should help you practice using extension methods, givens, and generic types in Scala.
///------------------------------------------------------------------------------------------------------------------------

// Sure, here’s a comprehensive problem that combines extension methods, givens, and generic types in Scala:

// Problem: Advanced Collection Operations

// Create a suite of extension methods for a custom collection class, MyCollection[T], that performs various advanced operations. The methods should include:

//   1.  Sum of Elements: Sum the elements of the collection if they are numeric.
//   2.  Find Maximum Element: Find the maximum element based on a given ordering.
//   3.  Transform and Filter: Transform the elements using a given function and filter them based on another predicate.
//   4.  Safe Division: Perform a safe division operation on each element by a given divisor, returning None if division by zero occurs.

// Requirements:

//   • Use extension methods to add these functionalities.
//   • Use given instances to provide the necessary numeric and ordering operations.
//   • Implement the methods in a generic manner to work with different types.

// Hints:

//   • Use the Numeric type class for summing elements.
//   • Use the Ordering type class for finding the maximum element.
//   • Define a type class to provide a default value for safe division.


// Define the custom collection class
case class MyCollection[T](elements: Seq[T])

// Define the type class for providing a default value
trait DefaultValue[T] {
  def default: T
}

object DefaultValue {
  given DefaultValue[Int] with {
    def default: Int = 0
  }

  given DefaultValue[String] with {
    def default: String = ""
  }
}

// Extension methods for MyCollection
extension [T](col: MyCollection[T]) {
  def sumElements(using num: Numeric[T]): T = {
    col.elements.sum
  }

  def maxElement(using ord: Ordering[T]): Option[T] = {
    if (col.elements.isEmpty) None
    else Some(col.elements.max)
  }

  def transformAndFilter[B](transform: T => B, predicate: B => Boolean): MyCollection[B] = {
    MyCollection(col.elements.map(transform).filter(predicate))
  }

  def safeDiv(divisor: T)(using num: Numeric[T], default: DefaultValue[Option[T]]): MyCollection[Option[T]] = {
    import num._
    if (divisor == zero) MyCollection(col.elements.map(_ => None))
    else MyCollection(col.elements.map(e => Some(e / divisor)))
  }
}

// Main method to test the functionality
@main def testMyCollection = {
  val intCollection = MyCollection(List(1, 2, 3, 4, 5))
  val stringCollection = MyCollection(List("apple", "banana", "cherry"))

  println(intCollection.sumElements) // Output: 15
  println(intCollection.maxElement) // Output: Some(5)
  println(intCollection.transformAndFilter(_ * 2, _ > 5)) // Output: MyCollection(List(6, 8, 10))
  println(intCollection.safeDiv(2)) // Output: MyCollection(List(Some(0), Some(1), Some(1), Some(2), Some(2)))
//   println(intCollection.safeDiv(0)) // Output: MyCollection(List(None, None, None, None, None))

//   println(stringCollection.transformAndFilter(_.toUpperCase, _.startsWith("A"))) // Output: MyCollection(List("APPLE"))
//
}

// Explanation:

//   1.  Custom Collection Class: MyCollection[T] wraps a sequence of elements.
//   2.  Type Class for Default Value: DefaultValue[T] provides a default value for safe division.
//   3.  Extension Methods: The extension methods add functionalities to MyCollection[T]:
//   • sumElements sums the elements if they are numeric.
//   • maxElement finds the maximum element based on a given ordering.
//   • transformAndFilter transforms and filters elements based on given functions.
//   • safeDiv performs safe division on elements, returning None if division by zero occurs.
//   4.  Main Method: Tests the functionalities with examples.

// This problem should give you a comprehensive practice on using extension methods, givens, and generic types in Scala.