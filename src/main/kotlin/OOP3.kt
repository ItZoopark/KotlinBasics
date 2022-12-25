data class Money2(
    private var rub: Int,
    private var kop: Int
)

fun main() {
    val money = Money2(400, 100)
    println(money.toString())
    val moneyCopy = money.copy()
    println(moneyCopy.toString())
    println(money == moneyCopy)
    println(money.hashCode() == moneyCopy.hashCode())
}