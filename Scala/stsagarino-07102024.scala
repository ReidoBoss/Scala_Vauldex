@main def m() =
  val person1 = new PersonName("John", "Vitualla", "Lesmes")
  val person2 = new PersonName("", "Tell", "Cueme")


  // // It should prints "John Vitualla Lesmes"
   person1 match
     case PersonName(first, middle, last) => println(s"${first} ${middle} ${last}")
     case _ => println("Person does not have a name")

   // // It should prints "Person does not have a name"
   // person2 match
   //   case PersonName(first, middle, last) => println(s"${first} ${middle} ${last}")
   //   case _ => println("Person does not have a name")


class Person(name:String,age:Int):

	val juan = Person("juan",20) 
	println(juan)

case class Name(first:String,middle:String,last:String)


 object User
 	val juan = Person("Juan",20)

class PersonName(val first:String,val middle:String,val last:String)