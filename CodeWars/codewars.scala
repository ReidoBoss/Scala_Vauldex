//999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2, there are 4 multiplications)

@main def codewars=
	println(fibo(5))
	


def countSmileys(vec: Vector[String]): Int = 
	vec.filter(isSmiley).map{x=>1}.sum

 
def isSmiley(s:String)=
	if((s(0)==':'||s(0)==';')&&(s(1)=='-'||s(1)=='~')&&(s(2)=='D'||s(2)==')')) true 
	else if((s(0)==':'||s(0)==';')&&(s(1)=='D'||s(1)==')'))true
	else false