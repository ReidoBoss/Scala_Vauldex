// import Printer.{printerln as println,printer as print}
// // Problem 1: Enhanced Collection Operations

// // Objective: Create a suite of extension methods for a custom collection class, MyCollection[T], that performs various advanced operations.
// // Requirements:

// // 	1.	Sum of Elements: Create an extension method to sum the elements of the collection if they are numeric.
// // 	2.	Find Maximum Element: Create an extension method to find the maximum element based on a given ordering.
// // 	3.	Transform and Filter: Create an extension method to transform the elements using a given function and then filter them based on another predicate.
// // 	4.	Default Value: Create an extension method for Option[T] to return the contained value or a default value if the option is None.


// class MyCollection[T](val list:List[T])


// extension[A](collection:MyCollection[A])(using Numeric[A])
// 	def sumElements:A =
// 		collection.list.sum

// extension[A](collection:MyCollection[A])(using Ordering[A])
// 	def maxElement:Option[A] =
// 		collection.list.length > 0 match {
// 			case true => Some(collection.list.max) 
// 			case false => None
// 		}

// extension[A](collection:MyCollection[A])
// 	def transformAndFilter[B](trans:A=>B,predicate:B=>Boolean)=
// 		collection.list.map(trans).filter(predicate)

// trait DefaultValue[T]:
// 	def default:T

// object DefaultValue:
// 	given DefaultValue[Int] with 
// 		def default:Int = 0

// extension[T](opt:Option[T])
// 	def getOrElseDefault(using default:DefaultValue[T]):T=
// 		opt match {
// 		  case None => default.default
// 		  case Some(a) => a
// 		}



// @main def stsagarino = {
//   val intCollection = MyCollection(List(1, 2, 3, 4, 5))
//   val stringCollection = MyCollection(List("apple", "banana", "cherry"))

//   // // Test sumElements
//   assert(intCollection.sumElements == 15)

//   // // Test maxElement
//   assert(intCollection.maxElement == Some(5))

//   // // Test transformAndFilter
//   val transformed = intCollection.transformAndFilter(_ * 2, _ > 5)
//   assert(transformed == List(6, 8, 10))

//   // // Test getOrElseDefault
//   val someOpt: Option[Int] = Some(5)
//   val noneOpt: Option[Int] = None
//   assert(someOpt.getOrElseDefault == 5)
//   assert(noneOpt.getOrElseDefault == 0)
// }

// // Problem 2: Custom Sorting Function
// // Objective: Implement a custom sorting function using an extension method and a given instance of Ordering.

// // Requirements:

// // 	1.	Custom Sorting: Create an extension method to sort a sequence based on a given ordering.
// // 	2.	Type Class for Ordering: Implement a custom Ordering for a case class.

// case class Person(name: String, age: Int)

// object Person:
// //Used as a given for the extension below because class person has an object that has a given ageOrdering
// 	given ageOrdering: Ordering[Person] with
// 		def compare(x: Person, y: Person): Int = 
// 			println(x.age.compareTo(y.age)) 
// 			x.age.compareTo(y.age)


// // used above in the object person

// extension [T](seq: Seq[T])
// 	def customSort(using ord: Ordering[T]): Seq[T] = seq.sorted



// @main def stsagarino = 
// 	val people = List(Person("Alice", 30), Person("Bob", 25), Person("Charlie", 35))
// 	// Test customSort with default ordering by age
// 	val sortedByAge = people.customSort
// 	assert(sortedByAge == List(Person("Bob", 25), Person("Alice", 30), Person("Charlie", 35)))




// import Printer.{printerln as println,printer as print}


// // Problem 3: Safe Division with Default Values

// // Objective: Create an extension method for performing safe division on numeric types, returning a default value in case of division by zero.
// // Requirements:
// // 	1.	Safe Division: Implement an extension method for safe division.
// // 	2.	Type Class for Default Values: Define a type class to provide default values for different numeric types.

// // Test Cases:

// // trait DefaultValue[T]:
// // 	val default:T

// // object DefaultValue:
// // 	given DefaultValue[Int] with
// // 		val default:Int = 0
// // 	given DefaultValue[Double] with
// // 		val default:Double = 0.0		

// // extension [T](num: T)(using n: Fractional[T])
// //   def safeDiv(div: T)(using defaulter: DefaultValue[T]): T = 
// //     if (n.equiv(div, n.zero)) defaulter.default
// //     else n.div(num, div)


// trait DefaultValue[T]:
// 	val default:T

// object DefaultValue:
// 	given DefaultValue[Int] with
// 		val default:Int = 0
// 	given DefaultValue[Double] with
// 		val default:Double = 0.0		
// extension[T](num:T)(using numer:Numeric[T])
// 	def safeDiv(divi:T)(using defaulter:DefaultValue[T],integ:Integral[T]):T =
// 		divi match {
// 			case 0 => defaulter.default
// 			case _ => integ.quot(num,divi)
// 		}
// 	// def isNan(divi:T):Boolean =
// 	// 	divi match {
// 	// 		case 0.0 => true
// 	// 		case _ => false 
// 	// 	}




// @main def stsagarino = 
// 	val x = 10
// 	// // Test safeDiv with non-zero divisor
// 	assert(x.safeDiv(2) == 5)

// 	// // // Test safeDiv with zero divisor
// 	assert(x.safeDiv(0) == 0) // default value for Int

// 	val y = 10.0

// 	// // Test safeDiv with non-zero divisor
// 	// assert(y.safeDiv(2.0) == 5.0)

// 	// Test safeDiv with zero divisor
// 	// assert(y.safeDiv(0.0).isNaN) // default value for Double




// // Problem 4: Custom Collection Operations

// // Objective: Create a custom collection class CustomList[T] and implement extension methods for common operations (map, filter, reduce) using generic types and givens.

// // Requirements:

// // 	1.	Custom Collection Class: Define a custom collection class CustomList[T].
// // 	2.	Extension Methods: Implement map, filter, and reduce as extension methods.
// // 	3.	Using and Givens: Utilize the using clause and given instances where necessary.

// case class CustomList[T](val elements:List[T])

// extension[T](custom:CustomList[T])(using ord:Ordering[T])
// 	def map[B](f:T=>B):CustomList[B]=
// 		CustomList(custom.elements.map(f))
// 	def filter(p:T=>Boolean):CustomList[T]=
// 		CustomList(custom.elements.filter(p))
// 	def reduce(p:(T,T)=>T)=
// 		custom.elements.reduce(p)


// @main def stsagarino = 
//   val list = CustomList(List(1, 2, 3, 4, 5))

// //   // Test map
//   val mappedList = list.map(_ * 2)
//   assert(mappedList.elements == List(2, 4, 6, 8, 10))

//   // Test filter
//   val filteredList = list.filter(_ % 2 == 0)
//   assert(filteredList.elements == List(2, 4))


// Problem 4: Extension Method for Sorting with Givens

// Objective:

// Create an extension method that sorts a sequence of elements based on a custom ordering defined by a given instance.

// Requirements:

// 	1.	Define a type class Sortable with a method compare that returns an Int indicating the order of two elements.
// 	2.	Create given instances for Int and String.
// 	3.	Implement an extension method sortElements that sorts the elements of a sequence using the Sortable type class.

// Test Cases:

// // Define a type class Sortable
// trait Sortable[T] {
//   def compare(x: T, y: T): Int
// }

// object Sortable {
//   given Sortable[Int] with {
//   }

//   given Sortable[String] with {
//   }
// }

// // Implement the extension method
// extension[T](list: Seq[T])

// @main def stsagarino = {
//   val intList = List(4, 2, 3, 1)
//   val stringList = List("banana", "apple", "cherry")

//   assert(intList.sortElements == List(1, 2, 3, 4))
//   assert(stringList.sortElements == List("apple", "banana", "cherry"))
// }

// Problem 5: Extension Method for Filtering Unique Elements

// Objective:

// Create an extension method that filters unique elements in a sequence using a type class to define the uniqueness criteria.

// Requirements:

// 	1.	Define a type class Unique with a method uniqueBy that returns a value used to determine uniqueness.
// 	2.	Create given instances for Int and String.
// 	3.	Implement an extension method filterUnique that filters unique elements from a sequence based on the Unique type class.

// Test Cases:

// // Define a type class Unique
// trait Unique[T] {
//   def uniqueBy(x: T): Any
// }

// // Define given instances for Unique
// object Unique {
//   given Unique[Int] with {
//   }

//   given Unique[String] with {
//   }
// }

// // Implement the extension method
// extension[T](list: Seq[T])

// @main def stsagarino = {
//   val intList = List(1, 2, 2, 3, 4, 4, 5)
//   val stringList = List("apple", "banana", "cherry", "apricot")

//   assert(intList.filterUnique == List(1, 2, 3, 4, 5))
//   assert(stringList.filterUnique == List("apple", "banana", "cherry"))
// }

// Problem 6: Extension Method for Mapping with a Custom Function

// Objective:

// Create an extension method that maps over a sequence of elements using a custom function defined by a given instance.

// Requirements:

// 	1.	Define a type class Mapper with a method mapFunc that takes an element and returns a mapped value.
// 	2.	Create given instances for Int and String.
// 	3.	Implement an extension method customMap that maps over the elements of a sequence using the Mapper type class.

// Test Cases:

// // Define a type class Mapper
// trait Mapper[T, R] {
//   def mapFunc(x: T): R
// }

// // Define given instances for Mapper
// object Mapper {
//   given Mapper[Int, String] with {
//     def mapFunc(x: Int): String = (x * 2).toString
//   }

//   given Mapper[String, Int] with {
//     def mapFunc(x: String): Int = x.length
//   }
// }

// // Implement the extension method
// extension[T, R](list: Seq[T])
//   def customMap(using m: Mapper[T, R]): Seq[R] = ???

// @main def testCustomMap = {
//   val intList = List(1, 2, 3, 4)
//   val stringList = List("apple", "banana", "cherry")

//   assert(intList.customMap == List("2", "4", "6", "8"))
//   assert(stringList.customMap == List(5, 6, 6))
// }



Problem 7: Extension Method for Grouping Elements

Objective:

Create an extension method that groups elements of a sequence based on a custom criterion defined by a given instance.

Requirements:

	1.	Define a type class GroupBy with a method groupCriterion that returns a key to group by.
	2.	Create given instances for Int and String.
	3.	Implement an extension method groupElements that groups elements from a sequence based on the GroupBy type class.

Test Cases:

// Define a type class GroupBy
trait GroupBy[T, K] {
  def groupCriterion(x: T): K
}

// Define given instances for GroupBy
object GroupBy {
  given GroupBy[Int, Boolean] with {
    def groupCriterion(x: Int): Boolean = x % 2 == 0
  }

  given GroupBy[String, Char] with {
    def groupCriterion(x: String): Char = x.head
  }
}

// Implement the extension method
extension[T, K](list: Seq[T])
  def groupElements(using gb: GroupBy[T, K]): Map[K, Seq[T]] = ???

@main def testGroupElements = {
  val intList = List(1, 2, 3, 4, 5)
  val stringList = List("apple", "banana", "apricot", "cherry")

  assert(intList.groupElements == Map(false -> List(1, 3, 5), true -> List(2, 4)))
  assert(stringList.groupElements == Map('a' -> List("apple", "apricot"), 'b' -> List("banana"), 'c' -> List("cherry")))
}
// Problem 10: Extension Method for Mapping with Index
// Objective:
// Create an extension method that maps elements of a sequence to a new sequence based on a function that takes both the element and its index.
// Requirements:
// 	1.	Implement an extension method mapWithIndex that maps elements of a sequence to a new sequence based on a function (T, Int) => U.
// Test Cases:


extension[T](list:List[T])
	def mapWithIndex[B,C](f:(T , Int) => C):List[C] =
		list.zipWithIndex.map((x,y) => f(x,y))
			
		


@main def testMapWithIndex = {
  val list = List("a", "b", "c", "d")

  val result = list.mapWithIndex((elem, idx) => s"$elem$idx")
  assert(result == List("a0", "b1", "c2", "d3"))

  val numList = List(1, 2, 3, 4)
  val result2 = numList.mapWithIndex((elem, idx) => elem + idx)
  assert(result2 == List(1, 3, 5, 7))
}

val l1 = List(1,2,3)
val l2 = List('a', 'b', 'c')
// List('1a', '2b', '3c')
////--------------------------------------------------------------------------------------
Problem 11: Extension Method for Sliding Window Sum

Objective:

Create an extension method that computes the sum of elements in a sliding window of a given size.

Requirements:

	1.	Implement an extension method slidingWindowSum that takes a window size and returns a sequence of sums of elements in each window.

Test Cases:

@main def testSlidingWindowSum = {
  val list = List(1, 2, 3, 4, 5)

  val result = list.slidingWindowSum(3)
  assert(result == List(6, 9, 12))

  val shortList = List(1, 2)
  val result2 = shortList.slidingWindowSum(3)
  assert(result2 == List())
}

Problem 12: Extension Method for Distinct by Property

Objective:

Create an extension method that returns a sequence with distinct elements based on a given property.

Requirements:

	1.	Implement an extension method distinctBy that takes a function T => K and returns a sequence with distinct elements based on the property K.

Test Cases:

@main def testDistinctBy = {
  case class Person(name: String, age: Int)
  val people = List(Person("Alice", 25), Person("Bob", 30), Person("Alice", 30), Person("Charlie", 25))

  val distinctByName = people.distinctBy(_.name)
  assert(distinctByName == List(Person("Alice", 25), Person("Bob", 30), Person("Charlie", 25)))

  val distinctByAge = people.distinctBy(_.age)
  assert(distinctByAge == List(Person("Alice", 25), Person("Bob", 30)))
}