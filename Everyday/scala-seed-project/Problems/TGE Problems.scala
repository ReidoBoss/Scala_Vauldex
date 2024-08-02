import Printer.{printerln as println, printer as print}
// Problem 1: Extension Method for Merging Collections
// Objective:
// Create an extension method that merges two collections into one based on a custom merging strategy defined by a type class.
// Requirements:
//  1.  Define a type class Merger with a method merge that takes two elements and returns a merged result.
//  2.  Create given instances for Int (sum) and String (concatenation).
//  3.  Implement an extension method mergeWith that merges two collections of the same type using the Merger type class.

trait Merger[T]:
  def merge(a:T,b:T):T
object Merger:
  given Merger[String] with
    def merge(a:String,b:String):String =
      a+b
  given Merger[Int] with
    def merge(a:Int,b:Int):Int =
      a+b
extension[T](list:List[T])
  def mergeWith(list2:List[T])(using m:Merger[T])=
    list.zipWithIndex.map{(x,y)=>m.merge(x,list2(y))}


@main def testMergeWith = {
  val intList1 = List(1, 2, 3)
  val intList2 = List(4, 5, 6)
  val stringList1 = List("a", "b", "c")
  val stringList2 = List("d", "e", "f")
  assert(intList1.mergeWith(intList2) == List(5, 7, 9))
  assert(stringList1.mergeWith(stringList2) == List("ad", "be", "cf"))
}

// Problem 2: Extension Method for Flattening Nested Collections
// Objective:
// Create an extension method that flattens a collection of nested collections into a single collection using a type class to define the flattening behavior.
// Requirements:
//  1.  Define a type class Flattener with a method flatten that takes a nested collection and returns a flat collection.
//  2.  Create given instances for List and Option.
//  3.  Implement an extension method customFlatten that flattens nested collections using the Flattener type class.

trait Flattener[T[_]]:
  def flattener[A](seq:T[T[A]]):T[A]

object Flattener:
  given Flattener[List] with
    def flattener[A](seq:List[List[A]]):List[A] =
      seq.flatten
  given Flattener[Some] with
    def flattener[A](opt:Some[Some[A]]):Some[A]=
      opt match {
        case Some(a) => a
      }
extension[T[_],A](value:T[T[A]])
  def customFlatten(using flat:Flattener[T]):T[A] =
    flat.flattener(value)



@main def stsagarino = {
  val nestedList = List(List(1, 2), List(3, 4))
  val nestedOption = Some(Some(5))
  assert(nestedList.customFlatten == List(1, 2, 3, 4))
  assert(nestedOption.customFlatten == Some(5))
}

Problem 3: Extension Method for Partitioning by Predicate

Objective:

Create an extension method that partitions a collection into two collections based on a custom predicate defined by a type class.

Requirements:

	1.	Define a type class Predicate with a method test that returns a Boolean indicating if an element satisfies the predicate.
	2.	Create given instances for Int (even numbers) and String (non-empty).
	3.	Implement an extension method customPartition that partitions a collection into two collections based on the Predicate type class.

Test Cases:

@main def testCustomPartition = {
  val intList = List(1, 2, 3, 4, 5, 6)
  val stringList = List("", "a", "", "b", "c")

  assert(intList.customPartition == (List(2, 4, 6), List(1, 3, 5)))
  assert(stringList.customPartition == (List("a", "b", "c"), List("", "")))
}

// Problem 4: Extension Method for Zipping with Index
// Objective:
// Create an extension method that zips a collection with its indices and applies a custom function to each pair using a type class.
// Requirements:

//  1.  Define a type class ZipWithIndex with a method zipFunc that takes an element and its index and returns a result.
//  2.  Create given instances for Int and String.
//  3.  Implement an extension method zipWithIndexAndApply that zips a collection with its indices and applies the ZipWithIndex type class.

trait ZipWithIndex[T[_]]:
  def zipFunc[E](coll:T[E]):T[(E,Int)]

object ZipWithIndex:
  given ZipWithIndex[List] with
    def zipFunc[E](coll:List[E]):List[(E,Int)] =
      coll.zipWithIndex.map((x,y)=>(x,y))

extension[T[_],E](value:T[E])(using zipper:ZipWithIndex[T])
  def zipWithIndexAndApply=
    zipper.zipFunc(value)

@main def testZipWithIndexAndApply = {
  val intList = List(1, 2, 3, 4)
  val stringList = List("a", "b", "c")
  assert(intList.zipWithIndexAndApply == List((1,0), (2,1), (3,2), (4,3)))
  assert(stringList.zipWithIndexAndApply == List(("a",0), ("b",1), ("c",2)))
}

Problem 5: Extension Method for Custom Reduction with Initial Value

Objective:

Create an extension method that reduces a collection to a single value using a custom binary operation and an initial value defined by a type class.

Requirements:

	1.	Define a type class ReducerWithInitial with a method reduce that takes two elements and returns a combined result, and a method initial that returns the initial value.
	2.	Create given instances for Int (sum) and String (concatenation).
	3.	Implement an extension method reduceWithInitial that reduces a collection using the ReducerWithInitial type class.

Test Cases:

@main def testReduceWithInitial = {
  val intList = List(1, 2, 3, 4)
  val stringList = List("a", "b", "c")

  assert(intList.reduceWithInitial == 10)
  assert(stringList.reduceWithInitial == "abc")
}

Problem 6: Extension Method for Custom Mapping with Givens

Objective:

Create an extension method that maps elements of a collection to a new collection using a custom function defined by a type class and given instances.

Requirements:

	1.	Define a type class Mapper with a method mapFunc that takes an element and returns a mapped value.
	2.	Create given instances for Int (to String) and String (to Int, length).
	3.	Implement an extension method customMap that maps elements of a collection using the Mapper type class and given instances.

Test Cases:

@main def testCustomMap = {
  val intList = List(1, 2, 3, 4)
  val stringList = List("a", "ab", "abc")

  assert(intList.customMap == List("1", "2", "3", "4"))
  assert(stringList.customMap == List(1, 2, 3))
}
