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
// 	def functorForOption[B](f:T=>B):Option[B]= 
// 		func.map(opt)(f)

extension[T,A[_]](value:A[T])(using func:Functor[A])
	def functor[B](f:T=>B):A[B]=
		func.map(value)(f)

@main def stsagarino = 
	val meow:Option[String] = None
	println(meow.functor(x=>x+"B"))
	println(List(1,2,3,4,5).functor(x=>x+1))