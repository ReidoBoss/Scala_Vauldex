@main def tester() =

    val r1:Rational = Rational(1,2)
    val r2:Rational = Rational(2,3)

    val add:Rational = r1 + r2

    println(add)


class Rational(val n:Int, val d:Int):
    require(d != 0)

    private val g = gcd (n.abs,d.abs)
    val numer = n / g 
    val denum = d / g 
    override def toString(): String = 
        s"$n / $d"

    def this(n:Int) = this (n,1)

    def + (that:Rational): Rational =
        Rational(n * that.d + that.n * d ,that.d * d)
    def + (i:Int):Rational = 
        Rational(numer + i *  denum, denum)

    def - (that:Rational):Rational = 
        Rational(numer * that.denum - that.numer * denum,denum * that.denum)
    def - (i:Int ):Rational =
        Rational(numer - i * denum, denum)

    def * (that:Rational): Rational =
        Rational(that.numer * numer, that.denum * denum)
    def * (i: Int):Rational = 
        Rational(numer * i, denum)

    def / (that:Rational):Rational = 
        Rational(numer * that.denum, denum * that.numer)
    def / (i:Int):Rational =
        Rational(numer, denum * i)
    private def gcd(a:Int, b:Int): Int =
        if b == 0 then a else gcd(b, a % b)
extension (x:Int)
    def + (y:Rational) = Rational(x) + y
    def - (y:Rational) = Rational(x) - y
    def * (y:Rational) = Rational(x) * y
    def / (y:Rational) = Rational(x) / y

