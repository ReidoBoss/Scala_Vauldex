/*
Instructions: Make the test code execute successfully. Return type annotations are required.

Submission:
  - Create a scala file named `<yourid>-07112024`.
  - `<yourid>` must be your `<first_initial><middle_initial><last_name>`. ex. `rejima`
  - Submit your scala file to _ on or before 4:40 PM today.

#1 Create a class called `MyList` which receives repeated argument items of type `Int` and
has a method `toString` which returns a comma separated string of all the given elements.
Note: The created object of this class must be immutable.
Hint: Repeated parameters are written as such: `def methodName(args:String*) { /* ... */ }`

#2 Add an auxiliary class constructor to your `MyList` class so that it can accept a list of type Int
as argument upon instantiation.

#3 Create a method named `+` to your `MyList` class. This method will receive another `MyList` instance
and return a new `MyList` instance with the combined elements from both the given `MyList` instance and the existing one from the instance.
hint: 
  - the splat operator (`:_*`) can be used convert a collection into a 
valid argument for a repeated parameter

#4 Complete the function literal `getParity` below so that it returns the string "even" or "odd" depending on the received argument.
*/
class MyList(val x:Int*):
  override def toString =
    x.mkString(", ")
  def this(list:List[Int]) =
    this(list*)
  def + (list:MyList):MyList =
    MyList(x ++ list.x*)


val getParity = (n:Int) => 
  if(n%2==0) "even" else "odd"

// test to check if the function works --- [DO NOT CHANGE THIS PART] ---
@main def test =
  val obtained1 = new MyList(1, 2, 3, 4, 5).toString
  val expected1 = "1, 2, 3, 4, 5"
  val isObtainedEqual1 = obtained1 == expected1
  println("did #1 solution return the expected output? " + isObtainedEqual1)

  val obtained2 = new MyList(List(1, 2, 3, 4, 5)).toString()
  val expected2 = "1, 2, 3, 4, 5"
  val isObtainedEqual2 = obtained2 == expected2
  println("did #2 solution return the expected output? " + isObtainedEqual2)

  val obtained3 = (new MyList(List(1, 2, 3, 4, 5)) + new MyList(6, 7, 8, 9, 10)).toString
  val expected3 = new MyList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10).toString
  val isObtainedEqual3 = obtained3 == expected3
  println("did #3 solution return the expected output? " + isObtainedEqual3)

  val obtained4 = getParity(68)
  val expected4 = "even"
  val isObtainedEqual4 = obtained4 == expected4
  println("did #4 solution return the expected output? " + isObtainedEqual4)
  
// --- [DO NOT CHANGE THIS PART] ---