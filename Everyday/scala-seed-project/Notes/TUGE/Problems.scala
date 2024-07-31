import Printer.{printerln as println,printer as print}
// Problem 1: Enhanced Collection Operations

// Objective: Create a suite of extension methods for a custom collection class, MyCollection[T], that performs various advanced operations.
// Requirements:

// 	1.	Sum of Elements: Create an extension method to sum the elements of the collection if they are numeric.
// 	2.	Find Maximum Element: Create an extension method to find the maximum element based on a given ordering.
// 	3.	Transform and Filter: Create an extension method to transform the elements using a given function and then filter them based on another predicate.
// 	4.	Default Value: Create an extension method for Option[T] to return the contained value or a default value if the option is None.


class MyCollection[T](val list:List[T])


extension[A](collection:MyCollection[A])(using Numeric[A])
	def sumElements:A =
		collection.list.sum

extension[A](collection:MyCollection[A])(using Ordering[A])
	def maxElement:Option[A] =
		collection.list.length > 0 match {
			case true => Some(collection.list.max) 
			case false => None
		}

extension[A](collection:MyCollection[A])
	def transformAndFilter[B](trans:A=>B,predicate:B=>Boolean)=
		collection.list.map(trans).filter(predicate)

trait DefaultValue[T]:
	def default:T

object DefaultValue:
	given DefaultValue[Int] with 
		def default:Int = 0

extension[T](opt:Option[T])
	def getOrElseDefault(using default:DefaultValue[T]):T=
		opt match {
		  case None => default.default
		  case Some(a) => a
		}



@main def stsagarino = {
  val intCollection = MyCollection(List(1, 2, 3, 4, 5))
  val stringCollection = MyCollection(List("apple", "banana", "cherry"))

  // // Test sumElements
  assert(intCollection.sumElements == 15)

  // // Test maxElement
  assert(intCollection.maxElement == Some(5))

  // // Test transformAndFilter
  val transformed = intCollection.transformAndFilter(_ * 2, _ > 5)
  assert(transformed == List(6, 8, 10))

  // // Test getOrElseDefault
  val someOpt: Option[Int] = Some(5)
  val noneOpt: Option[Int] = None
  assert(someOpt.getOrElseDefault == 5)
  assert(noneOpt.getOrElseDefault == 0)
}

// Problem 2: Custom Sorting Function
// Objective: Implement a custom sorting function using an extension method and a given instance of Ordering.

// Requirements:

// 	1.	Custom Sorting: Create an extension method to sort a sequence based on a given ordering.
// 	2.	Type Class for Ordering: Implement a custom Ordering for a case class.

case class Person(name: String, age: Int)

object Person:
//Used as a given for the extension below because class person has an object that has a given ageOrdering
	given ageOrdering: Ordering[Person] with
		def compare(x: Person, y: Person): Int = 
			println(x.age.compareTo(y.age)) 
			x.age.compareTo(y.age)


// used above in the object person

extension [T](seq: Seq[T])
	def customSort(using ord: Ordering[T]): Seq[T] = seq.sorted



@main def stsagarino = 
	val people = List(Person("Alice", 30), Person("Bob", 25), Person("Charlie", 35))
	// Test customSort with default ordering by age
	val sortedByAge = people.customSort
	assert(sortedByAge == List(Person("Bob", 25), Person("Alice", 30), Person("Charlie", 35)))




import Printer.{printerln as println,printer as print}


// Problem 3: Safe Division with Default Values

// Objective: Create an extension method for performing safe division on numeric types, returning a default value in case of division by zero.
// Requirements:
// 	1.	Safe Division: Implement an extension method for safe division.
// 	2.	Type Class for Default Values: Define a type class to provide default values for different numeric types.

// Test Cases:

// trait DefaultValue[T]:
// 	val default:T

// object DefaultValue:
// 	given DefaultValue[Int] with
// 		val default:Int = 0
// 	given DefaultValue[Double] with
// 		val default:Double = 0.0		

// extension [T](num: T)(using n: Fractional[T])
//   def safeDiv(div: T)(using defaulter: DefaultValue[T]): T = 
//     if (n.equiv(div, n.zero)) defaulter.default
//     else n.div(num, div)


trait DefaultValue[T]:
	val default:T

object DefaultValue:
	given DefaultValue[Int] with
		val default:Int = 0
	given DefaultValue[Double] with
		val default:Double = 0.0		
extension[T](num:T)(using numer:Numeric[T])
	def safeDiv(divi:T)(using defaulter:DefaultValue[T],integ:Integral[T]):T =
		divi match {
			case 0 => defaulter.default
			case _ => integ.quot(num,divi)
		}
	// def isNan(divi:T):Boolean =
	// 	divi match {
	// 		case 0.0 => true
	// 		case _ => false 
	// 	}




@main def stsagarino = 
	val x = 10
	// // Test safeDiv with non-zero divisor
	assert(x.safeDiv(2) == 5)

	// // // Test safeDiv with zero divisor
	assert(x.safeDiv(0) == 0) // default value for Int

	val y = 10.0

	// // Test safeDiv with non-zero divisor
	// assert(y.safeDiv(2.0) == 5.0)

	// Test safeDiv with zero divisor
	// assert(y.safeDiv(0.0).isNaN) // default value for Double




// Problem 4: Custom Collection Operations

// Objective: Create a custom collection class CustomList[T] and implement extension methods for common operations (map, filter, reduce) using generic types and givens.

// Requirements:

// 	1.	Custom Collection Class: Define a custom collection class CustomList[T].
// 	2.	Extension Methods: Implement map, filter, and reduce as extension methods.
// 	3.	Using and Givens: Utilize the using clause and given instances where necessary.

case class CustomList[T](val elements:List[T])

extension[T](custom:CustomList[T])(using ord:Ordering[T])
	def map[B](f:T=>B):CustomList[B]=
		CustomList(custom.elements.map(f))
	def filter(p:T=>Boolean):CustomList[T]=
		CustomList(custom.elements.filter(p))
	def reduce(p:(T,T)=>T)=
		custom.elements.reduce(p)


@main def stsagarino = 
  val list = CustomList(List(1, 2, 3, 4, 5))

//   // Test map
  val mappedList = list.map(_ * 2)
  assert(mappedList.elements == List(2, 4, 6, 8, 10))

  // Test filter
  val filteredList = list.filter(_ % 2 == 0)
  assert(filteredList.elements == List(2, 4))

//   // Test reduce
  val reducedValue = list.reduce(_ + _)
  println(reducedValue)
  assert(reducedValue =