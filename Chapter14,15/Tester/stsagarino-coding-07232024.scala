/*
Instructions: Make the test code below work. Return type annotations are required.

Submission:
1. Create a scala file named <yourid>-coding-<today in MMDDYYYY format>.
2. <yourid> must be your `<first_name_initial><middle_initial><last_name>. ex. jfdoe
3. Make sure the file you submit is compilable.
4. Submit your answer file(s) to _ BEFORE or ON 4 PM today. No late submission.
*/

/*
1. Complete the function: `squareDigits` from `???`. Write a program that can square every digit of the given number and concatenate the squared digits to form a new number. Put your answer in a scala file named "<yourid>-square-digits.scala”.
For example, if we run `9119` through the function, `811181` will come out, because 9 squared is 81 and 1 squared is 1. (81-1-1-81)
Example #2: An input of `765` will return `493625` because 7 squared is 49, 6 squared is 36, and 5 squared is 25. (49-36-25)
*/

object SquareDigit:
  def squareDigits(n: Int): Int = 
  	n.toString.map{
  		x=> x.asDigit * x.asDigit
  	}.mkString("").toInt
/*
2. Complete the function: `postiveSum` from `???`, this function will return the sum of all positive integers. Put your answer in a scala file named "<yourid>-positive-sum.scala".
Example [1, -4, 7, 12] => 1 + 7 + 12 = 20

Note: 1. If there is nothing to sum, the sum is default to 0.
*/
object SumOfPositive:
  def positiveSum(arr: Array[Int]): Int = 
  	arr.filter(x=>x>0).sum
/*
// 3. Complete the code below so that the variables are assigned their proper values
// */

val fruits: List[String] = List("banana", "apple", "orange")
val banana: String = fruits(0)
val apple: String = fruits(1)
val orange: String = fruits(2)

// /*
// 4. Complete the function `isAmstrong`.
// Armstrong number is a positive n-digit number that is equal to the 
// sum of the nth powers of their digits. It is also known as pluperfect, 
// or Plus Perfect, or Narcissistic number

// Armstrong Number Example

// 1: 1^1 = 1

// 2: 2^1 = 2

// 3: 3^1 = 3

// 153: 1^3 + 5^3 + 3^3 = 1 + 125+ 27 = 153

// 125: 1^3 + 2^3 + 5^3 = 1 + 8 + 125 = 134 (Not an Armstrong Number)

// 1634: 1^4 + 6^4 + 3^4 + 4^4 = 1 + 1296 + 81 + 256 = 1634

// // */ 
object Amstrong:
  def isAmstrong(n: Int):Boolean = if(n.toString.map{x=> List.fill(n.toString.length)(x.asDigit).reduce(_*_)}.sum == n) true else false

@main def main =
  // #1 
  println(811181 == SquareDigit.squareDigits(9119)) // true
  println(0 == SquareDigit.squareDigits(0)) // true

  // #2 
  println(4 == SumOfPositive.positiveSum(Array(2, 2))) // true
  println(13 == SumOfPositive.positiveSum(Array(1, -2, 3, 4, 5))) // true
  println(0 == SumOfPositive.positiveSum(Array())) // true
  println(0 == SumOfPositive.positiveSum(Array(-1, -2, -3, -4, -5))) // true

  // #3
  println(banana) // "banana"
  println(apple) // "apple"
  println(orange) // "orange"

  // #4
  println(Amstrong.isAmstrong(1)) // true
  println(Amstrong.isAmstrong(2)) // true
  println(Amstrong.isAmstrong(3)) // true
  println(Amstrong.isAmstrong(153)) // true
  println(Amstrong.isAmstrong(125)) // false
  println(Amstrong.isAmstrong(1634)) // true