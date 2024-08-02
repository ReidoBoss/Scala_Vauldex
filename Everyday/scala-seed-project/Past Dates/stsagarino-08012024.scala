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
	def show(value:T):String

object Show:
	def apply[A](using show:Show[A]) = show

	given Show[Int] with 
		def show(value:Int):String =
			value.toString
	given [A]:Show[List[A]] with
		def show(value:List[A]):String =
			s"[${value.mkString(", ")}]"

extension[T](sh:Show[T]) (using shower:Show[T])
	def show(i:T):String=
		shower.show(i)


//------------------------------------------------------------------------------------------------------------------
trait Eq[T]:
	def eq(a:T,b:T):Boolean
object Eq:
	def apply[T](using equalizer:Eq[T])= equalizer
	given Eq[Int] with 
		def eq(a:Int,b:Int):Boolean = a==b 
	given [A]:Eq[List[A]] with
		def eq(a:List[A],b:List[A]) = a==b

extension (value:Eq[Int])(using equalizer:Eq[Int])
	def eq(a:Int,b:Int) = equalizer.eq(a,b)
extension[A](value:Eq[List[A]])(using equalizer:Eq[List[A]])
	def eq(a:List[A],b:List[A]) = equalizer.eq(a,b)	
//-----------------------------------------------------------------------------------------------------------------

@main def stsagarino =
/* DO NOT CHANGE */
  // 1
  println("meow")
  val showInt1 = Show[Int].show(123)
  assert(showInt1 == "123")

  val showList1 = Show[List[Int]].show(List(1, 2, 3))
  assert(showList1 == "[1, 2, 3]")

  val showInt2 = summon[Show[Int]].show(123)
  assert(showInt2 == "123")
  
  val showList2 = summon[Show[List[Int]]].show(List(1, 2, 3))
  assert(showList2 == "[1, 2, 3]")

  // 2
  val eqInt1 = Eq[Int].eq(123, 123)
  assert(eqInt1 == true)

  val eqList1 = Eq[List[Int]].eq(List(1, 2, 3), List(1, 2, 3))
  assert(eqList1 == true)

  val eqInt2 = summon[Eq[Int]].eq(123, 123)
  assert(eqInt2 == true)

  val eqList2 = summon[Eq[List[Int]]].eq(List(1, 2, 3), List(1, 2, 3))
  assert(eqList2 == true)
/* DO NOT CHANGE */