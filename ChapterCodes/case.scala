/*
Instructions: Make the test code below work. Return type annotations are required.

Submission:
1. Create a scala file named <yourid>-coding-<today in MMDDYYYY format>.
2. <yourid> must be your `<first_name_initial><middle_initial><last_name>. ex. jfdoe
3. Make sure the file you submit is compilable.
4. Submit your answer file(s) to me BEFORE or ON 4:50 PM today. No late submission.
*/
/*
#1 Complete the method below. This method takes an Integer and returns "One!" if 
he integer given is `1`, "Two~" if the integer is `2`, "Threeee" if the integer is `3` and finally, 
"I dunno" if the integer is neither `1`, `2` or `3`. 
*/

def sayNumber(n: Int) = n match {
  case 1 => "One!"
  case 2 => "Two~"
  case 3 => "Threeee"
  case _ => "I dunno" 
}
  

// /*
// #2 Complete the method below. This method takes an Option[String] and returns the string "has a value" if it contains 
// a value, or "has no value" if it does not contain a value. 
// */

def processOption(o: Option[String]) = 
  o match {
    case Some(s) => s"has a value"
    case _ => "has no value"
  }

// /*
// #3 Complete the method below. This method a list of integers and returns the following:
//   - the string "Empty list", if the list has no value.
//   - the string "List with single element: " concatinated with the head of the list, if the list
//     contains a single item.
//   - the string "List with multiple elements: <size> elements", the `size` value being the length
//     of the list.
// */

def processList(list: List[Int]) = 
  list match {
    case List()=> "Empty list"
    case List(s) => s"List with single element: ${s}"
    case _ => s"List with multiple elements: ${list.size} elements"
  }

// /*
// #4 Create a class called Book with members title, author and year and complete the method below. 
//   This method takes a list of Book type and returns the only list of books written 
//   by JK Rowling using pattern matching.
// */

case class Book(title: String, author: String, year: Int)

def findJKRowling(books: List[Book]): List[Book] = 
  books.filter{
    x=>
      x match {
        case Book(_,"J. K. Rowling",_) => true
        case _ => false
      }
  }
  
// /* 
// #5 Complete the method below. This method takes a tuple of Int and String and returns the following:
//   - "Even integer with an empty string" if the tuple contains an even integer and an empty string.
//   - "Odd integer with an empty string" if the tuple contains an odd integer and an empty string.
//   - "Even integer with non-empty string" if the tuple contains an even integer and a non-empty string.
//   - "Odd integer with non-empty string" if the tuple contains an odd integer and a non-empty string.
// */

def processTuple(tuple: (Int, String)): String = 
  tuple match {
    case (a,b) if a%2==0 && b.length == 0=> "Even integer with an empty string"
    case (a,b) if a%2!=0 && b.length == 0=> "Odd integer with an empty string"
    case (a,b) if a%2==0 && b.length != 0=> s"Even integer with non-empty string: $b"
    case (a,b) if a%2!=0 && b.length != 0=> s"Odd integer with non-empty string: $b"

  }


@main def test =
// DO NOT CHANGE THIS PART //
  //1
  val numbers = List((1, "One!"), (100, "I dunno"))
  numbers.foreach(testCase => {
    val obtained = sayNumber(testCase._1)
    val expected = testCase._2
    val assertion = obtained == expected
    println(s"did #1 solution return the expected output? $assertion")
  })

  //2
  val options = List((Option("Hello"), "has a value"), (None, "has no value"))
  options.foreach { o =>
    val obtained = processOption(o._1)
    val expected = o._2
    val assertion = obtained == expected
    println(s"did #2 solution return the expected output? $assertion")
  }

  //3
  val lists = List(
    (List.empty, "Empty list"), 
    (List(1), "List with single element: 1"), 
    (List(1, 2, 3), "List with multiple elements: 3 elements")
  )

  lists.foreach { l =>
    val obtained = processList(l._1)
    val expected = l._2
    val assertion = obtained == expected
    println(s"did #3 solution return the expected output? $assertion")
  }

  //4
  val books = List(
    (List(
      Book("Harry Potter", "J. K. Rowling", 1997),
      Book("Harry Potter 2", "J. K. Rowling", 2002)
    ), 2),
    (List(
      Book("Shadow and Bone", "Leigh Bardugo", 2012),
      Book("Six of Crows", "Leigh Bardugo", 2015),
      Book("The Return of the King", "J. R. R. Tolkien", 1955)
    ), 0)
  )

  books.foreach { b =>
    val obtained = findJKRowling(b._1).length
    val expected = b._2
    val assertion = obtained == expected
    println("did #4 solution return the expected output? " + assertion)
  }

  //5
  val tuple1 = ((4, "Scala"), "Even integer with non-empty string: Scala")
  val tuple2 = ((7, ""), "Odd integer with an empty string")
  val tuple3 = ((10, "Pattern Matching"), "Even integer with non-empty string: Pattern Matching")

  List(tuple1, tuple2, tuple3).foreach(tuple => {
    val obtained = processTuple(tuple._1)
    val expected = tuple._2
    val assertion = obtained == expected
    println(s"did #5 solution return the expected output? $assertion")
  })