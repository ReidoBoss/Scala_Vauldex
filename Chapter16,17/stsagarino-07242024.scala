/*
Instructions: 
  - Write the code to make the test code below execute successfully.
  - Assertions will throw an error if the expected result is not met.

Submission:
  1. Make sure that the file you submit is compilable.
  2. Compress your files and name it as `{first_name_initial}+{middle_initial}+{lastname}-{today in MMDDYYYY format}`.
    ex. `jfdoe-07242024`
  3. Deadline: July 24, 2024 4:00 PM
  Note: Follow Scala best practices.

#1 Define a simple type hierarchy representing geometric shapes. 
Implement classes for Circle and Rectangle. Include methods to calculate and return the area 
for each shape.

formulas:
  - to determine circle area (math.Pi * radius * radius)
  - to determine rectangle area (width * height)

#2 Introduce the method `resize` in all Shape classes to resize a shape. 
This resize method accepts a factor (Int) which can be used to increase or decrease the shape,
and returns a new instance of the shape.
formulas:
  - to resize circle (radius * factor)
  - to resize rectangle (width * factor, height * factor)

*/

import scala.math.Pi





abstract class Geometry:
	def area:Double

class Circle(val radius:Double) extends Geometry:
	override def area =
		(radius*radius) * Pi
	def resize(factor:Double) =
		new Circle(radius * factor)




class Rectangle(val width:Double,val height:Double)extends Geometry:
	override def area =
		width * height

	def resize(factor:Double) =
		new Rectangle(width*factor,height*factor)



// 	#3 & 4 As a user, I want to be able to convert temperature between Fahrenheit and Celsius, so that I can easily switch between these two units of measurement depending on my needs.
// To convert Fahrenheit (F) to Celsius (C):
//   - Subtract 32 from the Fahrenheit temperature.
//   - Multiply the result by 5.
//   - Divide the result by 9.
//   - The formula is: C = (F - 32) * 5 / 9.
// To convert Celsius (C) to Fahrenheit (F):
//   - Multiply the Celsius temperature by 9.
//   - Divide the result by 5.
//   - Add 32 to the result.
//   - The formula is: F = C * 9 / 5 + 32.

class Celcius(temp:Double)

class Fahren(temp:Double)


object TemperatureConverter:
//f -> c
	def convert(f:Double,n:Fahren):Double =
		(f-32)*5/9
	def convert(c:Double,n:Celcius):Double =
		c * 9 / 5 + 32

val F: Fahren = Fahren(1.0)
val C: Celcius = Celcius(1.0)

// // test code [DO NOT CHANGE]
@main def test =
  // 1
  val circle = Circle(5.0)
  val rectangle = Rectangle(3.0, 4.0)

  val testCases1 = List(
    (circle, 78.53981633974483),
    (rectangle, 12.0)
  )

  testCases1.foreach((t) => {
    val obtained = t._1.area
    val expected = t._2
    val assertion = obtained == expected
    println(s"did #1 solution return the expected output? $assertion")
  })

  // 2 
  val testCases2 = List(
    (circle, 2.0, 314.1592653589793),
    (Circle(3.6), 2.0, 162.8601631620949)
  )

  testCases2.foreach(t => {
    val obtained = (t._1.resize(t._2)).area
    val expected = t._3
    val assertion = obtained == expected
    println(s"did #2 solution return the expected output? $assertion")
  })

  val testCases3 = List(
    (rectangle, 2.0, 48.0),
    (Rectangle(3.0, 6.0), 2.0, 72.0)
  )

  testCases3.foreach(t => {
    val obtained = (t._1.resize(t._2)).area
    val expected = t._3
    val assertion = obtained == expected
    println(s"did #2 solution return the expected output? $assertion")
  })

//   // 3
//   // F => C
  val fahrenheit = 68.0
  val expectedCelsius = 20.0
  val assertion3 = TemperatureConverter.convert(fahrenheit, F) == expectedCelsius
  println(s"did #3 solution return the expected output? $assertion3")

//   // C => F
  val celsius = 20.0
  val expectedFahrenheit = 68.0
  val assertion4 = TemperatureConverter.convert(celsius, C) == expectedFahrenheit
  println(s"did #3 solution return the expected output? $assertion4")

// // test code [DO NOT CHANGE]