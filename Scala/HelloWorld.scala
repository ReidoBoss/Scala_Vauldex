@main def HelloWorld(args:String *)={
  
  val obtained1 = Greet("World")
  val expected1 = "Hello World"
  val assertion1Result = obtained1 == expected1
  println("did #1 solution return the expected output? " + assertion1Result)

  val obtained2 = fooBar
  val expected2 = List("1", "Foo", "3", "Foo", "5", "Foo", "7", "FooBar", "9", "Foo", "11", "Foo", "13", "Foo", "15", "FooBar", "17", "Foo", "19", "Foo")
  val assertion2Result = obtained2 == expected2
  println("did #2 solution return the expected output? " + assertion2Result)

  val obtained3 = sumOfAllNumbers(List.range(1, 50))
  val expected3 = 600
  val assertion3Result = obtained3 == expected3
  println("did #3 solution return the expected output? " + assertion3Result)

}

def Greet(name:String) =
   s"Hello $name"

def fooBar:List[Any] = 
   (1 to 20) . map {
      num => 
         if num % 2 == 0 & num % 2 == 8 then "FooBar"
         else if num % 2 == 0 then "Foo"
         else num.toString
   }.toList

def sumOfAllNumbers(list:List[Int]):Int =
   var result = 0
   list.foreach(
      listNum => result += listNum
   )
   result