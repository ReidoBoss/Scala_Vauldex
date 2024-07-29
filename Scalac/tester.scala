// accum("RqaEzty") -> "R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy"



@main def tester =
	val str:String = "RqaEzty"
	
	(0 to str.length).map{
		x =>
			s"${str.charAt(x).toUpper}" 
	}
	

