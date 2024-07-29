@main def sorter =

	val list = List(5,4,2,3,1)

	println(sort(list))

	def sort (xs:List[Int]):List[Int] =
		if(xs.isEmpty) then Nil
		else insert(xs.head,sort(xs.tail))
	
	def insert(x:Int,xs:List[Int]):List[Int] =
		if(xs.isEmpty || x <= xs.head) then x :: xs
		else xs.head :: insert(x,xs.tail)