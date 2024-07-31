import Printer.{printerln => println, printer => print}

// ----IMPLICIT CLASS----
// case class Person(name:String):
//   def greet: String = s"My name is $name"

// implicit class PersonClass(string:String):
//   def greet:String = Person(string).greet

// val danielGreet = "Daniel".greet

//-----EXTENSION METHOD-----//
case class Person(name:String):
  def greet: String = s"My name is $name"

extension (string:String) 
  def greet:String = Person(string).greet
//-----GENERIC EXTENSION METHOD-----//
sealed abstract class Tree[+A] 
case class Leaf[+A](value:A) extends Tree[A]
case class Branch[+A](left:Tree[A],right:Tree[A])extends Tree[A]

extension[A](tree:Tree[A])
  def filter(predicate: A=>Boolean):Boolean = tree match {
    case Leaf(value) => predicate(value)
    case Branch(left,right) => left.filter(predicate) && right.filter(predicate)
  }

extension[A](tree:Tree[A])
  def map[B](f:A=>B):Tree[B] = tree match {
    case Leaf(value) => Leaf(f(value)) 
    case Branch(left,right) => Branch(left.map(f),right.map(f))
  } 

extension[A](tree:Tree[A])(using numeric: Numeric[A])
  def sum:A = tree match {
    case Leaf(value) => value
    case Branch(left,right) => numeric.plus(left.sum,right.sum)
  }

// @main def stsagarino = 
//   val tree = Branch(Leaf(1),Leaf(2))
//   println(tree.filter(_>0))
//   println(tree.map(_*10))
//   println(tree.left.map(_*10))
//   println(tree.sum)

//-----------------------------------//



import Printer.{printerln => println, printer => print}


//Extension methods allow one to add methods to a type after the type is defined. Example:
case class Circle(x: Double, y: Double, radius: Double)

extension (c: Circle)
  def circumference: Double = c.radius * math.Pi * 2

// @main def stsagarino = 

//   val circle = Circle(0, 0, 1)

//   println(circle.circumference)


extension (ss: Seq[String])
  def longestStrings: Seq[String] =
    val maxLength = ss.map(_.length).max
    ss.filter(_.length == maxLength)

  def longestString: String = longestStrings.head

//Collective Extension
extension [T](xs: List[T])
  def second = xs.tail.head

extension [T: Numeric](x: T)
  def + (y: T): T = summon[Numeric[T]].plus(x, y)


extension [T](ss: Seq[T]) 
  def map[B](predicate: T=>B):Seq[B] = {
    ss match {
      case Nil => Nil
      case _ => ss.map(predicate)
    }
  }
  def filter(predicate: T=>Boolean):Seq[T]={
    ss match {
      case Nil => Nil
      case _ => ss.filter(predicate)
    }
  }


// @main def stsagarino = 
  
//   val list = List(1,2)
//   println(Nil)


//---------Tail Option----------

import Printer.{printerln => println, printer => print}


extension [T](xs: List[T])
   def tailOption: Option[List[T]] =
    if xs.nonEmpty then Some(xs.tail) else None


@main def stsagarino = 
  
  val list = List()
  println(tailOption[Int](List(1,2,4,5)))
  println(list.tailOption.getOrElse("0"))
































