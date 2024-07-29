class Person(val name: String, val age: Int)

object Person {
  def apply(name: String, age: Int): Person = new Person(name, age)

  def unapply(p: Person): Option[(String, Int)] = {
    if (p == null) None
    else Some((p.name, p.age))
  }
}

class Address(val city: String, val postalCode: String)

object Address {
  def apply(city: String, postalCode: String): Address = new Address(city, postalCode)

  def unapply(a: Address): Option[(String, String)] = {
    if (a == null) None
    else Some((a.city, a.postalCode))
  }
}

@main def matchExample = {
  val p1 = Person("Alice", 30)
  val p2 = Person("Alice", 30)
  val addr1 = Address("New York", "10001")
  val addr2 = Address("San Francisco", "94101")
  assert (p1==p2)
  def assertMatch(obj: Any): String = obj match {
    case Person(name, age) if name == "Alice" && age == 30 =>
      "Matched Person Alice with age 30"
    case Person(name, age) if name == "Bob" && age == 25 =>
      "Matched Person Bob with age 25"
    case Address(city, postalCode) if city == "New York" && postalCode == "10001" =>
      "Matched Address in New York with postal code 10001"
    case Address(city, postalCode) if city == "San Francisco" && postalCode == "94101" =>
      "Matched Address in San Francisco with postal code 94101"
    case _ =>
      "No match"
  }
}