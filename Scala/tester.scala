@main def test() =
    val list:MyList = MyList(1,2,3,4,5)
    val trueList:List[Int] = List(1,2,3,4,5)
    val listTest:MyList = MyList(trueList)
    // println(listTest)

// #3 Create a method named `+` to your `MyList` class. This method will receive another `MyList` instance
// and return a new `MyList` instance with the combined elements from both the given `MyList` instance and the existing one from the instance.
// hint: 
//   - the splat operator (`:_*`) can be used convert a collection into a 
// valid argument for a repeated parameter



def getParity(n: Int):String = 
  if n % 2 == 0 then "even" else "odd"

// 1 
class MyList(one:Int,two:Int,three:Int,four:Int,five:Int):
    
    override def toString():String =
     s"$one, $two, $three, $four, $five"

    def this(list:List[Int]) = this (list(0),list(1),list(2),list(3),list(4)) // 2 

    def + (myList:MyList):MyList =
        MyList


