enum MatterState:
	case Solid
	case Liquid
	case Gas
	case Plasma
	def vibrate=
		this match {
			case Solid => "jiggling but generally not moving from place to place."
			case Liquid => "moving about, and sliding past each other."
			case Gas => "jiggling but generally not moving from place to place."
			case Plasma => "interacting with electrical and magnetic fields"
		}


import Currency.*
enum Currency:
	case USD
	case EUR
	case GBP


case class Money(amount: Double, currency: Currency)

def convertMoney(amount: Money, target: Currency): Money = 
	(amount.currency,target) match {
		case (USD,EUR) => new Money(amount.amount * 0.85,EUR) 
		case (USD,GBP) => new Money(amount.amount * 0.73,GBP)
		case (EUR,USD) => new Money(amount.amount * 1.18,USD)
		case (EUR,GBP) => new Money(amount.amount * 0.86,GBP)
		case (GBP,USD) => new Money(amount.amount * 1.37,USD)
		case (GBP,EUR) => new Money(amount.amount * 1.16,EUR)

	}

// // 5

trait Request:
	type Response

	def send:Response

class AuthorizedRequest(
	val method: String,
	val url: String,
	val params: Map[String, String],
	val headers: Map[String, String]
) extends Request {
	type Response = Map[String, String]

	def send: Response = Map(
		"method" -> method,
		"url" -> url,
		"params" -> params.toString,
		"headers" -> headers.toString
	)
}

// Test code [DO NOT CHANGE]
@main def stsagarino: Unit = 
  // // for 1 - 4
	val obtained1 = MatterState.values.toList.mkString
	val expected1 = "SolidLiquidGasPlasma"
	val assertion1: Boolean = obtained1 == expected1
	println(s"Did #1 return the expected output? $assertion1")
	val testCases = List(
		(MatterState.Solid, "jiggling but generally not moving from place to place."),
		(MatterState.Liquid, "moving about, and sliding past each other."),
		(MatterState.Gas, "jiggling but generally not moving from place to place."),
		(MatterState.Plasma, "interacting with electrical and magnetic fields")
	)

	testCases.foreach { tc =>
		val obtained = tc._1.vibrate
		val expected = tc._2
		val assertion = obtained == expected
		println(s"Did #2 return the expected output? $assertion")
	}
	val amountInUSD = Money(100.0, Currency.USD)
	val amountInEUR = convertMoney(amountInUSD, Currency.EUR)
	val amountInGBP = convertMoney(amountInUSD, Currency.GBP)

	println(s"$amountInUSD is equivalent to $amountInEUR")
	println(s"$amountInUSD is equivalent to $amountInGBP")

	class AuthorizedRequest(
		val method: String,
		val url: String,
		val params: Map[String, String],
		val headers: Map[String, String]
	) extends Request {
		type Response = Map[String, String]

		def send: Response = Map(
			"method" -> method,
			"url" -> url,
			"params" -> params.toString,
			"headers" -> headers.toString
		)
	}
  
	val request = new AuthorizedRequest(
		"GET",
		"/users",
		Map("page" -> "1"),
		Map("Authorization" -> "Basic XYZ")
	)

	val testCases5 = List(
		(request.method, "GET"),
		(request.url, "/users"),
		(request.params, Map("page" -> "1")),
		(request.headers, Map("Authorization" -> "Basic XYZ"))
	) 

	testCases5.foreach(t =>
		val obtained = t._1
		val expected = t._2
		val assertion = obtained == expected
		println(s"Did #5 return the expected output? $assertion")
	)
