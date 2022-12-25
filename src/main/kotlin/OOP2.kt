import kotlin.math.abs

class Money(
    private var rub: Int,
    private var kop: Int
) {

    private fun convertToKopeek(money: Money): Int{
        return money.rub * 100 + money.kop
    }

    private fun convertToMoney(totalKop: Int): Money{
        return Money(totalKop / 100, abs(totalKop % 100))
    }

    fun plus(money: Money){
        val totalSumKopeek = convertToKopeek(this) + convertToKopeek(money)
        val moneySum = convertToMoney(totalSumKopeek)
        this.rub = moneySum.rub
        this.kop = moneySum.kop
    }

    fun minus(money: Money): Money{
        val totalDifKopeek = convertToKopeek(this) - convertToKopeek(money)
        val moneyDif = convertToMoney(totalDifKopeek)
        return moneyDif
    }

    fun multiply(x: Int): Money{
        val totalKop = convertToKopeek(this) * x
        val moneyGain = convertToMoney(totalKop)
        return moneyGain
    }

    fun copy() = this

    fun show(){
        println("$rub руб. $kop коп.")
    }

    companion object{
        fun minus(money1: Money, money2: Money) = money1.minus(money2)
    }
}

// DRY - Don't repeat yourself

fun main() {
    val money2 = Money(90, 70)
    val money1 = Money(90, 70)
    val money3 = money1.copy()
    println(money1.toString())
    println(money3.toString())
    println(money2.toString())

    println(money1 == money2)
    println(money1 == money3)
//    val minus = Money.minus(money1, money2)
//    minus.show()
//    println(minus.toString())
//    money1.plus(money2)
//    money1.show()
//    money1.minus(money2).show()
//    money2.minus(money1).show()
//    money2.multiply(2).show()


}