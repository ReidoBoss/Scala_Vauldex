import Printer.{printerln as println,printer as print}
// Problem 1: Extension Method for Strings

// Task: Define an extension method for String that converts it to CamelCase. For example, "hello world" should be converted to "HelloWorld".
// Hints:
//   • Use Scala’s extension methods feature.
//   • Implement a function that transforms a string into CamelCase.

// extension (s:String) 
//   def toCamelCase =
//     s.split(" ").map{x=>x.head.toUpper+x.tail}.mkString

// @main def stsagarino =
//   val str1: String = "hello world"
//   val str2: String = "scala programming language"
//   val str3: String = "a b c d"

//   println(str1.toCamelCase) // Output: "HelloWorld"
//   println(str2.toCamelCase) // Output: "ScalaProgrammingLanguage"
//   println(str3.toCamelCase) // Output: "ABCD"

// Problem 2: Generic Extension Method for Lists

// Task: Create an extension method for List that returns the second-to-last element of the list. If the list has fewer than two elements, return None.

// Hints:

//   • Use Scala’s extension methods with generic types.
//   • Handle edge cases where the list length is less than 2.

// extension[A](list:List[A])
//   def secondToLast:Option[A]=
//     (list.length<=1) match {
//       case (true) => None
//       case _ => Some(list.init.last)
//     }


// @main def stsagarino =
//   val list1: List[Int] = List(1, 2, 3, 4, 5)
//   val list2: List[String] = List("a", "b", "c")
//   val list3: List[Double] = List(3.14)

//   println(list1.secondToLast) // Output: Some(4)
//   println(list2.secondToLast) // Output: Some("b")
//   println(list3.secondToLast) // Output: None


// Problem 3: Default Value with Givens

// Task: Define a type class DefaultValue that provides a default value for different types. Implement a given instance for Double and Boolean. Create an extension method that uses the given instance to provide a default value for Option.

// Hints:

//   • Define a type class DefaultValue with a default method.
//   • Implement given instances for Double and Boolean.
//   • Create an extension method for Option that uses the DefaultValue type class.

// Define the type class
// trait DefaultValue[T] {
//   def default: T
// }

// object DefaultValue{
//   given DefaultValue[Int] with 
//     def default:Int = 0
//   given DefaultValue[Boolean] with 
//     def default:Boolean = false
//   given DefaultValue[Double] with
//     def default:Double = 0.0
// }

// extension[T](opt:Option[T])
//   def getOrElseDefault(using default:DefaultValue[T]):T=
//     opt match {
//       case None => default.default
//       case Some(a) => a
//     }

// // Import the extension methods


// @main def stsagarino =

//   val optDouble: Option[Double] = None
//   val optBoolean: Option[Boolean] = None
//   val optDoubleWithValue: Option[Double] = Some(3.14)
//   val optBooleanWithValue: Option[Boolean] = Some(true)

//   // Test cases
//   assert(optDouble.getOrElseDefault == 0.0) // Default value for Double
//   assert(optBoolean.getOrElseDefault == false) // Default value for Boolean
//   assert(optDoubleWithValue.getOrElseDefault == 3.14) // Provided value
//   assert(optBooleanWithValue.getOrElseDefault == true) // Provided value

//   println("All tests passed!")

/* 
Instructions: 
  - Make the assertions below pass. Return type annotations are required.

Submission:
  1. Create a scala file named <yourid>-07292024.
  2. <yourid> must be your `<first_name_initial><middle_initial><last_name>. ex. rejima
  3. Make sure the file you submit is compilable.
  4. Submit your answer file(s) BEFORE or ON the given time. NO LATE SUBMISSION.

#1 Using Scala's `givens` and `using`, complete the implementation for the JsonSerializer
object which contains the method `toJson`. This method can serialize a `Profile` or a `User` object to a JSON string.
  - The `toJson` method for a `Profile` returns the following value:
    "{"id": "${johnProfile.id.toString}","name": "John Doe", "age": 30}"
  - The `toJson` metho for a `User` returns the following value:
    "{"email": "${user.email}", "username": "${user.username}", "id_profile": ${user.idProfile}}"
*/

// trait JsonSerializable[A]:
//   def serialize(value: A): String

// object JsonSerializable{
//   given JsonSerializable[Profile] with 
//     def serialize(prof:Profile)=
//       s"""{"id": "${prof.id}","name": "${prof.name}", "age": ${prof.age}}"""

//   given JsonSerializable[User] with 
//     def serialize(user:User)=
//       s"""{"email": "${user.email}", "username": "${user.username}", "id_profile": ${user.idProfile}}"""
// }

// class Profile(val id: UUID, val name: String, val age: Int)

// object Profile:
//   def apply(name: String, age: Int): Profile = new Profile(UUID.randomUUID, name, age)

// case class User(email: String, username: String, idProfile: UUID)

// object JsonSerializer:
//   def toJson[A](value: A)(using serializer:JsonSerializable[A]): String =
//     serializer.serialize(value) 


// /*
// #2 Write the code to make the test code below execute successfully.
//   - Create the necessary classes for the test cases.
//   - To convert Kilogram to Gram, multiply the value by 1000
//   - To convert Gram to Kilogram, divide the value by 1000
//   - Hint: Scala has a built-in feature to easily convert between types
// */

// case class Kilogram(value:Double)
// case class Gram(value:Double)

// given Conversion[Kilogram,Gram] with
//   def apply(value:Kilogram):Gram = Gram(value.value*1000) 
// given Conversion[Gram,Kilogram] with
//   def apply(value:Gram):Kilogram = Kilogram(value.value/1000) 


// // DO NOT CHANGE
// @main def test =
//   // 1
//   val johnProfile = Profile("John Doe", 30)
//   val johnUser = User("jdoe@gmail.com", "jdoe", johnProfile.id)

//   val obtainedSerializedProfile = JsonSerializer.toJson(johnProfile)
//   val expectedSerilizedProfile = s"""{"id": "${johnProfile.id}","name": "John Doe", "age": 30}"""
//   println(s"obtained: $obtainedSerializedProfile")
//   println(s"expected: $expectedSerilizedProfile")
//   assert(obtainedSerializedProfile == expectedSerilizedProfile)

//   val obtainedSerializedUser = JsonSerializer.toJson(johnUser)
//   val expectedSerilizedUser = s"""{"email": "jdoe@gmail.com", "username": "jdoe", "id_profile": ${johnProfile.id}}"""
//   println(s"obtained: $obtainedSerializedUser")
//   println(s"expected: $expectedSerilizedUser")
//   assert(obtainedSerializedUser == expectedSerilizedUser)

//   // 2
//   val testCases1: List[(Kilogram, Gram)] = List(
//     (Kilogram(1.0), Gram(1000.0)), // (argument value, expected result value)
//     (Kilogram(1.6), Gram(1600.0)),
//     (Kilogram(2.89), Gram(2890.0))
//   )

//   val testCases2: List[(Gram, Kilogram)] = List(
//     (Gram(100.0), Kilogram(0.1)), // (argument value, expected result value)
//     (Gram(3.0), Kilogram(0.003)),
//     (Gram(19.8), Kilogram(0.0198))
//   )
  
//   testCases1.foreach(t => {
//     val obtained: Gram = t._1
//     val expected = t._2
//     println(s"obtained: $obtained")
//     println(s"expected: $expected")
//     assert(obtained == expected)
//   })

//   testCases2.foreach(t => {
//     val obtained: Kilogram = t._1
//     val expected = t._2
//     println(s"obtained: $obtained")
//     println(s"expected: $expected")
//     assert(obtained == expected)
//   })



// Problem 4: Generic Sorting

// Task: Create a generic extension method for Seq that sorts the sequence using a custom ordering function. The custom ordering function should be provided as an implicit parameter.
// Hints:
//   • Use an extension method with generic types.
//   • Define a custom ordering function as an implicit parameter.



// // Test Cases:
// @main def stsagarino =
// implicit val intOrdering: Ordering[Int] = Ordering[Int]

// val list1: Seq[Int] = Seq(3, 1, 4, 1, 5, 9, 2, 6, 5)
// val list2: Seq[String] = Seq("apple", "banana", "cherry")

// println(list1.customSort) // Output: Seq(1, 1, 2, 3, 4, 5, 5, 6, 9)
// println(list2.customSort) // Output: Seq("apple", "banana", "cherry")


//4
// @main def stsagarino =

//   extension(s:String)
//     def truncate(n:Int)=
//       s.zipWithIndex.map((x,y)=>if(y<=10)"."else if(y>=10)""else x)


//   assert("Lorem ipsum dolor sit amet, consectetur adipiscing elit.".truncate(10) == "Lorem ipsu...")

import java.util.UUID
/* 
Instructions: 
  - Make the assertions below pass. Return type annotations are required.

Submission:
  1. Create a scala file named <yourid>-07292024.
  2. <yourid> must be your `<first_name_initial><middle_initial><last_name>. ex. rejima
  3. Make sure the file you submit is compilable.
  4. Submit your answer file(s) BEFORE or ON the given time. NO LATE SUBMISSION.

#1 Using Scala's `givens` and `using`, complete the implementation for the JsonSerializer
object which contains the method `toJson`. This method can serialize a `Profile` or a `User` object to a JSON string.
  - The `toJson` method for a `Profile` returns the following value:
    "{"id": "${johnProfile.id.toString}","name": "John Doe", "age": 30}"
  - The `toJson` metho for a `User` returns the following value:
    "{"email": "${user.email}", "username": "${user.username}", "id_profile": ${user.idProfile}}"
*/

trait JsonSerializable[A]:
  def serialize(value: A): String

object JsonSerializable:
  given JsonSerializable[Profile] with
    def serialize(value:Profile):String = 
      s"""{"id": "${value.id}","name": "${value.name}", "age": ${value.age}}"""
  given JsonSerializable[User] with
    def serialize(value:User):String = 
      s"""{"email": "${value.email}", "username": "${value.username}", "id_profile": ${value.idProfile}}"""

class Profile(val id: UUID, val name: String, val age: Int)

object Profile:
  def apply(name: String, age: Int): Profile = new Profile(UUID.randomUUID, name, age)

case class User(email: String, username: String, idProfile: UUID)

object JsonSerializer:
  def toJson[A](value: A)(using serializer:JsonSerializable[A]): String = 
    serializer.serialize(value)


/*
#2 Write the code to make the test code below execute successfully.
  - Create the necessary classes for the test cases.
  - To convert Kilogram to Gram, multiply the value by 1000
  - To convert Gram to Kilogram, divide the value by 1000
  - Hint: Scala has a built-in feature to easily convert between types
*/
case class Gram(value:Double)
case class Kilogram(value:Double)

given Conversion[Kilogram,Gram] with
  def apply(k:Kilogram) = Gram(k.value*1000)
given Conversion[Gram,Kilogram] with
  def apply(k:Gram) = Kilogram(k.value/1000)

// DO NOT CHANGE
@main def stsagarino =
  // 1
  val johnProfile = Profile("John Doe", 30)
  val johnUser = User("jdoe@gmail.com", "jdoe", johnProfile.id)

  val obtainedSerializedProfile = JsonSerializer.toJson(johnProfile)
  val expectedSerilizedProfile = s"""{"id": "${johnProfile.id}","name": "John Doe", "age": 30}"""
  println(s"obtained: $obtainedSerializedProfile")
  println(s"expected: $expectedSerilizedProfile")
  assert(obtainedSerializedProfile == expectedSerilizedProfile)

  val obtainedSerializedUser = JsonSerializer.toJson(johnUser)
  val expectedSerilizedUser = s"""{"email": "jdoe@gmail.com", "username": "jdoe", "id_profile": ${johnProfile.id}}"""
  println(s"obtained: $obtainedSerializedUser")
  println(s"expected: $expectedSerilizedUser")
  assert(obtainedSerializedUser == expectedSerilizedUser)

  // 2
  val testCases1: List[(Kilogram, Gram)] = List(
    (Kilogram(1.0), Gram(1000.0)), // (argument value, expected result value)
    (Kilogram(1.6), Gram(1600.0)),
    (Kilogram(2.89), Gram(2890.0))
  )

  val testCases2: List[(Gram, Kilogram)] = List(
    (Gram(100.0), Kilogram(0.1)), // (argument value, expected result value)
    (Gram(3.0), Kilogram(0.003)),
    (Gram(19.8), Kilogram(0.0198))
  )
  
  testCases1.foreach(t => {
    val obtained: Gram = t._1
    val expected = t._2
    println(s"obtained: $obtained")
    println(s"expected: $expected")
    assert(obtained == expected)
  })

  testCases2.foreach(t => {
    val obtained: Kilogram = t._1
    val expected = t._2
    println(s"obtained: $obtained")
    println(s"expected: $expected")
    assert(obtained == expected)
  })




