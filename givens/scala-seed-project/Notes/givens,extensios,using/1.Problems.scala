import Printer.{printerln => println, printer => print}

// Problem 1: Extension Method for Strings

// Task: Define an extension method for String that converts it to CamelCase. For example, "hello world" should be converted to "HelloWorld".
// Hints:
//   • Use Scala’s extension methods feature.
//   • Implement a function that transforms a string into CamelCase.

extension (s:String) 
  def toCamelCase =
    s.split(" ").map{x=>x.head.toUpper+x.tail}

@main def stsagarino =
  val str1: String = "hello world"
  val str2: String = "scala programming language"
  val str3: String = "a b c d"

  println(str1.toCamelCase) // Output: "HelloWorld"
  println(str2.toCamelCase) // Output: "ScalaProgrammingLanguage"
  println(str3.toCamelCase) // Output: "ABCD"