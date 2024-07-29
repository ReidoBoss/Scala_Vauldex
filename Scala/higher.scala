// Instructions:
//   1. Create a scala file named <yourid>-coding-07122024.
//   2. <yourid> must be your `<first_name_initial><middle_initial><last_name>`. ex. rejima
//   3. Submit your answer file(s) to _ BEFORE or ON the given time. NO LATE SUBMISSION.

// 1. Declare a variable named `addTwo` and assign it with a function that will invoke the `add` function in question 2. The arguments `n1` and `n2` will not be assigned a value yet, while`n3` will be assigned the value `2`. When invoked, `addTwo` will return the sum of `n1`, `n2` and `2`.

// 2. Write a function literal that accepts three integers: n1 and n2. The function will return the sum of all the arguments. Assign it to a variable called `add`.

// 3. Define a function that contains a closure. This function contains a counter state, which is a number with the value `0` as default. When the closure is invoked, the counter will be incremented and the result will be provided to the callback function as its argument.
// If the name of the function is `increment`, the following code should execute successfully: `increment()(println)` // prints 1

// 4. Refactor the Calculator object to simplify the code.
// ```
// object Calculator:
//   def add(n1: Int, n2: Int): Int = n1 + n2
//   def multiply(n1: Int, n2: Int): Int = n1 * n2
//   def divide (n1: Int, n2: Int): Int = n1 / n2
//   def subtract(n1: Int, n2: Int): Int = n1 - n2
// ```

// 5. Using the loan pattern with by-name parameters, complete this `filterMap` function which accepts a list of Integers, filters it by applying a given predicate function and then applies the given transform function.
// ```
// def filterMap(l: List[Int]) = ???
// ```



object Calculator:
  def add(n1: Int, n2: Int): Int = n1 + n2
  def multiply(n1: Int, n2: Int): Int = n1 * n2
  def divide (n1: Int, n2: Int): Int = n1 / n2
  def subtract(n1: Int, n2: Int): Int = n1 - n2