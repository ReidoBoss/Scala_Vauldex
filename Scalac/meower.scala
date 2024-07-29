// def findWaldo(people: List[(String, String, Int)]): (String, String, Int) = {

// }

@main def meower =

  // def fib(n:Int) =
  //   def sumOfList(list:List[Int])=
  //     list.sum

  //   (1 to n).map{
  //     x=> if(x==1) 1
  //         else if(x==2) 1
  //         else 
  //           sumOfList(List(x-1,x-2))

  //   }.toList.sum

  // println(fib(4))
    // if(n>2)
    //   if(n==1) 1
    //   else 2
    // else
    //   val before = List().sum
    //   val after = List().sum
    //   before.sum + after.sum     

    def fib(n:Int) =
      val list = List(1,1)
      val newList =(x:Int,y:Int,iterator:Int)=> 
        if(iterator!=n)
          x+y
        else 0


