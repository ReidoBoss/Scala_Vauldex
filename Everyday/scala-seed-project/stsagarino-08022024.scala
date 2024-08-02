import Printer.{printerln as println, printer as print}
/*
Instructions:
  - Fulfill the requirements below.
  - Create a scala file and name it as <yourid>-08022024
  - Fulfill the requirements below
*/

// #1
case class Book(title: String, author: String, genre: String, price: Double)

val books: List[Book] = List(
  Book("Ejisan's Adventures", "Ryo Ejisan", "Fantasy", 10.99),
  Book("To Kill a Mockingbird", "Harper Lee", "Classic", 10.99),
  Book("1984", "George Orwell", "Dystopian", 9.99),
  Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 12.99),
  Book("The Hobbit", "J.R.R. Tolkien", "Fantasy", 11.99),
  Book("Brave New World", "Aldous Huxley", "Dystopian", 8.99),
  Book("Moby-Dick", "Herman Melville", "Classic", 7.99),
  Book("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "Magic Realism", 13.99),
  Book("Crime and Punishment", "Fyodor Dostoevsky", "Classic", 14.99))

	

// @main def stsagarino =
// // 1.1. Find all the books that cost less than $10.
// 	println(books.filter(x=>x.price>10))
// // 1.2. Find the titles of all books that are "Classic".
// 	println(books.filter(x=>x.genre=="Classic"))
// // 1.3. Group the books by genre.
// 	println(books.groupBy(x=>x.genre))
// // 1.4. Calculate the average price of all books.
// 	println(books.foldLeft(0.0)((x,y)=>x+y.price)/books.length)
// // 1.5. Find the most expensive book.
// 	println(books.filter(x=>x.price==books.map{x=>x.price}.max))
// // 1.6. Group the books by genre, and within each genre, sort the books by price in ascending order.
// 	println(books.groupBy(x=>x.genre))
// // 1.7. Find the total price of all books for each genre.
// 	println(books.foldLeft(0.0)((x,y)=>x+y.price))
// // 1.8. Find the average price of books for each author, sorted by average price in descending order.
// 	println(books.groupBy(x=>x.author))
// // 1.9. Transform the dataset into a Map[String, Map[String, List[String]]], where the first key is the genre, the second key is the author, and the list contains titles.
// // 1.10. Create a list of all titles, sorted by the last word in the title.
// 	println(books.map(x=>x.title).sortBy(
// 		x=>x.reverse.takeWhile(_!=' ').reverse
// 	))

// #2
/*
Imagine you're building a system to model and track the activities of a university.
You have to track students, their courses, and grades for each course. Your task is to calculate:
The average grade for each course.
The average grade for each student.
The top-performing student in each course.
The overall top-performing student.
The worst-performing student in each course.
The overall worst-performing student based on average grades.
The most challenging course, i.e., the course with the lowest average grade.
The easiest course, i.e., the course with the highest average grade.
- A grade is a simple integer between 0 and 100
- Answer them returning methods on the bottom
- No loop, mutable state, no internet (except for API references)
*/

case class Student(id: Int, name: String)
case class Course(id: Int, name: String)
case class Enrollment(studentId: Int, courseId: Int, grade: Int):
  require(0 <= grade && grade <= 100)

val students = List(
  Student(1, "Alice"),
  Student(2, "Bob"),
  Student(3, "Catherine"))

val courses = List(
  Course(1, "Math"),
  Course(2, "Science"),
  Course(3, "History"))

val enrollments = List(
  Enrollment(1, 1, 85),
  Enrollment(1, 2, 91),
  Enrollment(1, 3, 76),
  Enrollment(2, 1, 78),
  Enrollment(2, 2, 87),
  Enrollment(3, 1, 92),
  Enrollment(3, 3, 89))
@main def stsagarino =
	// 2.1. The average grade for each course
	def avgGradePerCourse:String = 
		val math= enrollments.filter(x=>x.courseId==1)
		val mathAve = enrollments.map(x=>x.grade).sum / math.length
		val science= enrollments.filter(x=>x.courseId==2)
		val scienceAve = enrollments.map(x=>x.grade).sum / science.length
		val history= enrollments.filter(x=>x.courseId==2)
		val historyAve = enrollments.map(x=>x.grade).sum / history.length
		s"Math Average:${mathAve}\n Science Average: ${scienceAve} \nHistory Average: ${historyAve}"
	// 2.2. The average grade for each student
	def avgGradePerStudent = 
		val aliceGrade = enrollments.filter(x=>x.studentId==1).map(x=>x.grade)
		val bobGrade = enrollments.filter(x=>x.studentId==2).map(x=>x.grade)
		val cathGrade = enrollments.filter(x=>x.studentId==3).map(x=>x.grade)
		s"Alice Grade:${aliceGrade.sum/aliceGrade.length} Bob Grade:${bobGrade.sum/bobGrade.length} Catherine Grade:${cathGrade.sum/cathGrade.length}"


	// 2.3. The top-performing student in each course
		// oh my god
	def topStudentPerCourse = 
		enrollments.groupBy(x=>x.grade).toList.groupBy((x,y)=>y(0).courseId).toList.map(
			(x,y)=> List(x,y.maxBy((e,r)=>e))
			)
	//helper
	def sAHelper(id:Int) =
		enrollments.filter(x=>x.studentId==id).map(x=>x.grade).sum / 3
	// 2.4. The overall top-performing student
	// def overallTopStudent = 
	// 	students.filter(x=>x.courseId==List(sAHelpe(1),sAHelpe(2),sAHelpe(3)).max)
	// println(overallTopStudent)
	// 2.5. The worst-performing student in each course
	def worstStudentPerCourse = 
		enrollments.groupBy(x=>x.grade).toList.groupBy((x,y)=>y(0).courseId).toList.map(
			(x,y)=> List(x,y.minBy((e,r)=>e))
			)	


	// 2.6. The overall worst-performing student based on average grades
	def overallWorstStudent = 
		students.filter(x=>x.id == enrollments.minBy(x=>x.grade).studentId)

	// 2.7. The most challenging course (course with the lowest average grade)
	def mostChallengingCourse = 
		val math= enrollments.filter(x=>x.courseId==1)
		val mathAve = enrollments.map(x=>x.grade).sum / math.length
		val science= enrollments.filter(x=>x.courseId==2)
		val scienceAve = enrollments.map(x=>x.grade).sum / science.length
		val history= enrollments.filter(x=>x.courseId==2)
		val historyAve = enrollments.map(x=>x.grade).sum / history.length
		List(mathAve,scienceAve,historyAve).min
	// 2.8. The easiest course (course with the highest average grade)
	def easiestCourse = 
		val math= enrollments.filter(x=>x.courseId==1)
		val mathAve = enrollments.map(x=>x.grade).sum / math.length
		val science= enrollments.filter(x=>x.courseId==2)
		val scienceAve = enrollments.map(x=>x.grade).sum / science.length
		val history= enrollments.filter(x=>x.courseId==2)
		val historyAve = enrollments.map(x=>x.grade).sum / history.length
		List(mathAve,scienceAve,historyAve).max
