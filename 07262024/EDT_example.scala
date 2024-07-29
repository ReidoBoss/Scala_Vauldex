import Printing.printer
// import EastWood.*

//------ADT EXAMPLE------
// enum EastWood[+G,+B]{

// 	def map[G2](f:G=>G2):EastWood[G2,B] =
// 		this match {
// 			case Good(g) => Good(f(g))
// 			case Bad(b) => Bad(b)
// 			case Ugly(ex) => Ugly(ex)

// 		}
// 	def get=
// 		this match 
// 			case Good(g) => g 
// 			case _ => None

// 	def getOrElse(value:Any)=
// 		this match {
// 			case Good(g) => g
// 			case _ => value
// 		}

// 	case Good(g:G)
// 	case Bad(b:B)
// 	case Ugly(ex:Throwable)	
// }
	
// @main def edt_example =
// 	val easter = Bad(4*10)
// 	printer(easter.map{x=>x}.getOrElse("Meow!"))

//----------- G A D T------------
//import Literal.*
// @main def stsagarino = 
// 	val testing = IntLit(123)
// 	printer(testing.valueOfLiteral(testing).toString)
//
// enum Literal[T]:
// 	case IntLit(value: Int) extends Literal[Int]
// 	case LongLit(value: Long) extends Literal[Long]
// 	case CharLit(value: Char) extends Literal[Char]
// 	case FloatLit(value: Float) extends Literal[Float]
// 	case DoubleLit(value: Double) extends Literal[Double]
// 	case BooleanLit(value: Boolean) extends Literal[Boolean]
// 	case StringLit(value: String) extends Literal[String]

// 	def valueOfLiteral[T](lit: Literal[T]): T =
// 	   lit match
// 	   case IntLit(n) => n
// 	   case LongLit(m) => m
// 	   case CharLit(c) => c
// 	   case FloatLit(f) => f
// 	   case DoubleLit(d) => d
// 	   case BooleanLit(b) => b
// 	   case StringLit(s) => s
