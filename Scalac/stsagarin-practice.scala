import scala.collection.mutable.ListBuffer

/*
Instructions:
  1. Make the test code below execute successfully.
  2. Your file must be named `<first_name_initial><middle_initial><full_lastname>-practice-07162024.scala`
    ex. `jfdoe-practice-07162024.scala`
  3. Submit to _ or before 4:30 PM today
*/

/*
 #1 - #3: Change the code in the functions below so that it adheres to the principles of functional programming. 
  It should perform the same behavior without side effects or using mutable state.
*/

/* #1
 this method accepts a list of string and returns a string 
 where all items are combined, separated by coma `, `
*/
def combineStrings(strings: List[String]): String = {
	strings.mkString(", ")
}

/* #2
  this function accepts a list of tuple with type (String, String, Int)
  and finds a tuple which contains the string "Waldo" and "String" 
  respectively. If not found, it will return ("", "", -1).
*/
def findWaldo(people: List[(String, String, Int)]): (String, String, Int) = {
	val peopleFound = people.toList.filter((x,y,z)=>x=="Waldo"&y=="Smith")
	if(peopleFound.length!=0) (peopleFound(0)(0),peopleFound(0)(1),peopleFound(0)(2))
	else ("","",-1)
}

// /* #3
//  this function generates the fibonacci sequence from 0 until the given
//  integer.
// */
// def generateFibonacciSeq (term: Int): ListBuffer[Int] = {
//   var res: ListBuffer[Int] = ListBuffer.empty
//   var i = 0
//   while (i <= term) {
//     if (i < 2) {
//       res += i
//     } else {
//       res += res(i - 1) + res(i - 2)
//     }
//     i += 1
//   }
//   res
// }

/*
#4 Without using case class, define a class to make the #4 test code below work:
  Hints:
    - Companion object and its magical behaviors


#5 Without using case class, define the classes to make the #5 test code below work:
  Hints:
    - You need a common parent (maybe bear)
    - Other than common parent, it's almost same as #4
    - See test code for further hint
*/

// class Panda(val name:String,val favorite:String)

// object Panda:
// 	def apply(name:String,favorite:String)
// 		new Panda(name,favorite)

// 	def unapply(panda:Panda) : Option[String,String] =
//       Some((panda.name, panda.favorite))


class Panda(val name: String, val favorite: String)

object Panda:
	def apply(name: String, favorite: String): Panda =
	  new Panda(name, favorite)

	def unapply(Panda: Panda): Option[(String, String)] =
	  Some((Panda.name, Panda.favorite))
////////// SUNBEAR!///////
class SunBear(val name: String, val favorite: String)

object SunBear:
	def apply(name: String, favorite: String): SunBear =
	  new SunBear(name, favorite)

	def unapply(SunBear: SunBear): Option[(String, String)] =
	  Some((SunBear.name, SunBear.favorite))	

class BrownBear(val name: String, val favorite: String)
///////////////// BROWN BEAR////////////////
object BrownBear:
	def apply(name: String, favorite: String): BrownBear =
	  new BrownBear(name, favorite)

	def unapply(BrownBear: BrownBear): Option[(String, String)] =
	  Some((BrownBear.name, BrownBear.favorite))

// Panda("John", "Doe") match
// case Panda(name, favorite) => println(s"My name is $name $favorite")



@main def test =
  // #4 
  val pandas = List(
    Panda("Spot", "bamboo"),
    Panda("Dotty", "sunflower"),
    Panda("Rocky", "human"))

  for (panda <- pandas) panda match {
    case Panda(name, favorite) => println(s"Hey! I'm $name! Where's my $favorite?")
  }

  // // #5
  val bears = List(
    Panda("Spot", "bamboo"),
    SunBear("Dotty", "nap"),
    BrownBear("Rocky", "YOU"))

  for (bear <- bears) bear match {
    case Panda(name, favorite) => println(s"Hey! I'm $name! Where's my $favorite?")
    case SunBear(name, favorite) => println(s"Hi there! I'm $name! Come take a $favorite with us!")
    case BrownBear(name, favorite) => println(s"Grrr! I'm $name! YOU my dinner!")
  }

  // // Hint:
  // class Name(val first: String, val last: String)

  // object Name:
  //   def apply(first: String, last: String): Name =
  //     new Name(first, last)
  
  //   def unapply(name: Name): Option[(String, String)] =
  //     Some((name.first, name.last))

  // Name("John", "Doe") match
  //   case Name(first, last) => println(s"My name is $first $last")
  
  // 1 - 3 test code
  val obtained1 = combineStrings(List("orange", "banana", "apple", "mango"))
  val expected1 = "orange, banana, apple, mango"
  println(obtained1)
  val assertion = assert(obtained1 == expected1)

  var people = List(
    ("Jane", "Doe", 20),
    ("John", "Doe", 23),
    ("Waldo", "Smith", 21),
    ("Juan", "Dela Cruz", 21),
    ("Pedro", "Dela Cruz", 21),
  )

  val obtained2 = findWaldo(people)
  val expected2 = ("Waldo", "Smith", 21) // should use `Option` but we will tackle that later.
  println(obtained2)
  val assertion2 = assert(obtained2 == expected2)

  // val obtained3 = generateFibonacciSeq(5)
  // val expected3 = Seq(0,1,1,2,3,5)
  // println(obtained3)
  // val assertion3 = assert(obtained3.toSeq == expected3)