// Instructions:
//   - Fulfill the requirements stated below.
// Submission:
//   - Create a scala file named <yourid>-07102024.
//   - `<yourid>` must be your <first_initial><middle_initial><last_name>. ex. rejima
//   - Submit your scala file to 
// @jkvlesmes
//  on or before 4:30 PM today.
// 1.1 Define a class named `Person` that takes `name` as a string and `age` as an integer. Let the name and age be its properties.
// 1.2 Then, create an immutable variable named `juan`. Instantiate a `Person` object with name as "Juan" and age as 20. Assign the instantiated `Person` object to the variable `juan`.
// 1.3 Prints the `name` and `age` from `Person` object.
// 2.1 Define a case class `Name` has a string of first, middle and last.
// 2.2 Define a companion object of `User` has a Name object, integer age, and boolean status of isActivated with a default of `true`.
// 3. Define a class `PersonName` has a string of first, middle and last. The class `PersonName` can be pattern match just like in the test spec below.
// Note: Make the test spec below pass.
// Test spec:
class Person(val name:String,val age:Int)

case class Name(first:String,middle:String,last:String)


class User(name:Name,age:Int,isActivated:Boolean = true)
object User

case class PersonName(first:String,middle:String,last:String):
	require(first.length > 0,"Person has no name!")






@main def two=
  val person1 = new PersonName("John", "Vitualla", "Lesmes")
  val person2 = new PersonName("", "Tell", "Cueme")

  // It should prints "John Vitualla Lesmes"
  val juan = Person("Juan",20)
  println(juan.name+" "+juan.age)

  person1 match
  	case PersonName("",middle,last) => println("Person has no name")
  	case PersonName(first,middle,last) => println(s"${first} ${middle} ${last}")

  // It should prints "Person does not have a name"
  person2 match
    case PersonName("", middle, last) => println("Person has no name")
    case PersonName(first,middle,last) => println(s"${first} ${middle} ${last}")