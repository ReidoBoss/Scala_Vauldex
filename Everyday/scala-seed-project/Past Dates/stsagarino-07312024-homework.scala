import Printer.{printerln as println, printer as print}

// Problem 5: Extension Method for Custom Reduction with Initial Value

// Objective:

// Create an extension method that reduces a collection to a single value using a custom binary operation and an initial value defined by a type class.

// Requirements:

// 	1.	Define a type class ReducerWithInitial with a method reduce that takes two elements and returns a combined result, and a method initial that returns the initial value.
// 	2.	Create given instances for Int (sum) and String (concatenation).
// 	3.	Implement an extension method reduceWithInitial that reduces a collection using the ReducerWithInitial type class.

trait ReducerWithInitial[T[_]]


@main def stsagarino = {
  val intList = List(1, 2, 3, 4)
  val stringList = List("a", "b", "c")

  // assert(intList.reduceWithInitial == 10)
  // assert(stringList.reduceWithInitial == "abc")
}

