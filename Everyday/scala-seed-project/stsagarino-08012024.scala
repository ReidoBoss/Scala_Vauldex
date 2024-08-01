import Printer.{printerln as println, printer as print}
/* 
Instructions:
  - Fulfill the requirements below.
  - Create a scala file and name it as <yourid>-08012024
  - Submit your answer to me on slack @mribersabal on or before 4 PM today.

#1 Implement a type class named Show that provides a way to represent different types as strings,
and instances of the type class for Int, String, Boolean and List.

#2 Implement a type class named Eq that provides equality for different data types as a method to compare two elements of the same type and determine whether they are equal, and instances of the type class for Int, String and List.
*/

trait Show[T]:
	def shower(value:T):String

object Show:
	given Show[Int] with 
		def shower(value:Int):String = value.toString

	// given Show[List] with 
	// 	def shower[A](value:List[A]):String = s"[${value.mkString(", ")}]"

	def apply[A](using show:Show[A]) = show


extension [T](s:Show[T]) (using shower:Show[T]) 
	def show(value:T):String = shower.shower(value).toString


trait Eq[T[_]]:
	def eq[A,B](l1:T[A],l2:T[B]):Boolean
object Eq:

	given Eq[List] with 
		def eq[A,B](list:List[A],list2:List[B]):Boolean =
			list == list2

// extension[A](list:List[A]) 
// 	def eq[B](list2:List[B])(using equalizer:Eq[List]):Boolean =
// 		equalizer.eq(list,list2)


@main def stsagarino =
/* DO NOT CHANGE */
  // 1
  println("meow")
  val showInt1 = Show[Int].show(123)
  // assert(showInt1 == "123")

  // val showList1 = Show[List[Int]].show(List(1, 2, 3))
  // assert(showList1 == "[1, 2, 3]")

  // val showInt2 = summon[Show[Int]].show(123)
  // assert(showInt2 == "123")
  
  // val showList2 = summon[Show[List[Int]]].show(List(1, 2, 3))
  // assert(showList2 == "[1, 2, 3]")

  // // 2
  // val eqInt1 = Eq[Int].eq(123, 123)
  // assert(eqInt1 == true)

  // val eqList1 = Eq[List[Int]].eq(List(1, 2, 3), List(1, 2, 3))
  // assert(eqList1 == true)

  // val eqInt2 = summon[Eq[Int]].eq(123, 123)
  // assert(eqInt2 == true)

  // val eqList2 = summon[Eq[List[Int]]].eq(List(1, 2, 3), List(1, 2, 3))
  // assert(eqList2 == true)
/* DO NOT CHANGE */