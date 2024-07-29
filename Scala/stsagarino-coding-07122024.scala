@main def routine=

	//1
	val addTwo = add(_,_,2)

	//2
	val add = (n1:Int,n2:Int,n3:Int) =>
		n1+n2+n3

	//3

	val bool = true
	def increment =
		val counter = 0

		if(!bool) 0
		else 
			println(counter + 1)
			counter + 1

	//4

	object Calculator:

	  def getNum(f:(Int,Int)=>Int) =
	  	f(1,2) 
	  def add(n1: Int, n2: Int): Int = 
	  	n1 + n2
	  def multiply(n1: Int, n2: Int): Int = 
	  	n1 * n2
	  def divide (n1: Int, n2: Int): Int = 
	  	n1 / n2
	  def subtract(n1: Int, n2: Int): Int = 
	  	n1 - n2

	 //5 
	 val predicate = (x:Int) => x % 2 == 0
	 def filterMap(l: List[Int]) = 
	 	list.filter(predicate)