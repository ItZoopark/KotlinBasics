import kotlin.math.abs
import kotlin.math.pow

data class Fraction (private val num: Int, private val den: Int){

    fun plus(other: Fraction): Fraction {
        val commonDen = lcm(den, other.den)
        return Fraction(
            num = num * (commonDen / den) + other.num * (commonDen / other.den),
            den = commonDen
        )
    }

    fun minus(other: Fraction) = plus(other.copy(num = -other.num))

    fun multiply(other: Fraction): Fraction{
        val left = this.reduce()
        val right = other.reduce()
        val num = left.num * right.num
        val den = left.den * right.den
        return Fraction(num, den).reduce()
    }

    fun division(other: Fraction) = multiply(other.copy(num = other.den, den = other.num))

    fun step(m: Int) = this.copy(
            num = num.toDouble().pow(m.toDouble()).toInt(),
            den = den.toDouble().pow(m.toDouble()).toInt()
        ).reduce()

    override fun toString() = "$num / $den"

    fun show() = println(this.toString())

    private fun reduce(): Fraction{
        val maxDivisor = gcd(num, den)
        return Fraction(num / maxDivisor, den / maxDivisor)
    }

    // lcm - Least Common Multiply
    // |a*b| = gcd(a,b) * lcm(a,b)
    // lcm(a,b) = |a*b| / gcd(a,b)
    private fun lcm(a: Int, b: Int) = abs(a*b) / gcd(a, b)

    // gcd - Greatest Common Divisor
    private fun gcd(a: Int, b: Int): Int{
        var x = a
        var y = b
        while (x != y){
            if (x > y)  x -= y
            else if (x < y) y -= x
        }
        return x
    }
}

fun main() {
    // a/b + c/d = (a*d + c*b)/(b*d)
    val f1 = Fraction(2, 4)
    val f2 = Fraction(3, 2)
//    f1.plus(f2).show()
    f1.minus(f2).show()
    f1.multiply(f2).show()
    f1.division(f2).show()
    f1.step(2).show()
//    f1.plus(f2).reduce().show()
    // 1 / 2 + 3 / 32 = (1*нок/2 + 3нок/32) / 32
    // 1 / 10_000 + 2 / 1_000_000 = 1*100/1_000_000 + 2
    // нок = 32
    // 1/2 + 3/4
    // 1/2  + -3/4
    // 1_000_000/2 * 1000_000/1_000 =
    // 1/2 : 3/4 = 1/2 * 4/3
}