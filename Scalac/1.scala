/*
Instructions: Make the assertions inside this scala file pass. Return type annotations are required.

Submission:
  - Create a scala file named `<yourid>-07092024`.
  - `<yourid>` is your `<first_name_initial><middle_initial><last_name>. ex. `jfkennedy`
  - Submit your scala file to Kevin as a direct message on Slack or before 4:20 PM today.
*/
// #1 Complete this function which returns the string greeting for the given name.
def makeGreeting(name: String) = 
  s"Hello $name"
  

/*
#2 Complete this function which returns a list containing the stringified numbers 
from 1 to 20. But for the multiples of two, the string "Foo" is included instead of the number, 
and for the multiples of eight, "Bar." is included.
For numbers that are multiples of two and eight, "FooBar" is included. 

Otherwise, the stringified number is included as is.
*/
def generateFooBar = 
  (1 to 20).map{
    x=>
      if(x % 2 ==0 && x % 8 ==0)"FooBar"
      else if(x%2==0)"Foo"
      else x.toString
  }.toList

/*
#3 Without using the "if" statement, complete this function which returns the sum of all
even numbers in a given list.
*/
def sumOfEvensInList(list: List[Int]) = 
  list.filter(x=>x%2==0).sum
  
// --- [DO NOT CHANGE THIS PART] ---
@main def one = 
  val obtained1 = makeGreeting("World")
  val expected1 = "Hello World"
  val assertion1Result = obtained1 == expected1
  println("did #1 solution return the expected output? " + assertion1Result)

  val obtained2 = generateFooBar
  val expected2 = List("1", "Foo", "3", "Foo", "5", "Foo", "7", "FooBar", "9", "Foo", "11", "Foo", "13", "Foo", "15", "FooBar", "17", "Foo", "19", "Foo")
  val assertion2Result = obtained2 == expected2
  println("did #2 solution return the expected output? " + assertion2Result)

  val obtained3 = sumOfEvensInList(List.range(1, 50))
  val expected3 = 600
  val assertion3Result = obtained3 == expected3
  println("did #3 solution return the expected output? " + assertion3Result)
// --- [DO NOT CHANGE THIS PART] ---