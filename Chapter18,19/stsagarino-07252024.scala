// Instructions:
//   1. Create a scala file named `<yourid>-07252024`.
//   2. `<yourid>` must be your `<first_initial><middle_initial><last_name>. ex. `rejima`
//   3. Add your answer in the scala file you created.
//   4. Make sure the file you submit is compilable
//   5. Submit your answer file(s) to 
// @jkvlesmes
//  BEFORE or ON the given time. NO LATE SUBMISSION.
// 1. Define a trait `MyTrait` that takes invariant parameter type and has `value` member. Then, create two case classes `A` and `B` that extends `MyTrait`.
// Test spec:
// ```
// // Do not change
// @main def m() =
//   println(A.value) // "abc"
//   println(B.value) // 10
// ```
// 2. In functional programming, a Functor is a design pattern inspired by the definition from category 
// theory that allows one to apply a function to values inside a generic type without changing the structure of the generic type.
// Create a Functor that contains a map method which applies a given function to a value it contains, resulting in a new Functor of the same type class.
// Define a trait `Functor` and `functorForOption` instance.
// Test spec:
// ```
// ```

trait MyTrait[T]:
	val value:T

object A extends MyTrait[String]:
	val value = "abc" 

object B extends MyTrait[Int]:
	val value = 10 

// @main def m() =
//   println(A.value) // "abc"
//   println(B.value) // 10

trait Functor[T]:
	def map(some: Option[T])(predicate: T<:U)=
		Some(some.predicate)



// val functorForOption[T] = Functor[T]

// @main def m() =
// 	assert(functorForOption.map(Some(2))(_ + 1) == Some(3))
// 	assert(functorForOption.map(Some(3))(_.toString) == Some("3"))
// 	assert(functorForOption.map(Some("4"))(_.toInt) == Some(4))


// @main def m() =
//   println(A.value) // "abc"
//   println(B.value) // 10
// 	assert(functorForOption.map(Some(2))(_ + 1) == Some(3))
// 	assert(functorForOption.map(Some(3))(_.toString) == Some("3"))
// 	assert(functorForOption.map(Some("4"))(_.toInt) == Some(4))