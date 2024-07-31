// Functor is with a map method that applies a given function to a value it contains, resulting in a new Functor of the same type class.

// Implement a type class named Functor that includes a map method that applies a given function to a value it contains, resulting in a new Functor of the same type class, and instances of the type class for option and list.

trait Functor[T[_]]:
	def map[A,B](value:T[A])(f:A=>B):T[B]
object Functor:
	given Functor[Option] with
		def map[A,B](value:Option[A])(f:A=>B):Option[B] =
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

extension[T](opt:Option[T])(using func:Functor[Option])
	def functorForOption[B](f:T=>B):Option[B]= 
		func.map(opt)(f)


extension[T](opt:List[T])(using func:Functor[List])
	def functorForList[B](f:T=>B):List[B]= 
		func.map(opt)(f)

@main def stsagarino =
	println(Some("a").functorForOption(x=>x+"b"))
	println(List(1,2,3,4).functorForList(x=>x+1))
