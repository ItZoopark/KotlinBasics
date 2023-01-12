import kotlin.random.Random

open class Person2(protected val name: String, protected val age: Int) {
    fun walk() = println("$name может ходить")
    fun eat() = println("$name может есть")
    fun sleep() = println("$name может спать")
}

// boilerplate code
class Driver(
    name: String,
    age: Int,
    private val experience: Int
) : Person2(name, age) {
    fun drive() = println("$name может водить, стаж вождения: $experience года")
}

open class Developer(
    name: String,
    age: Int,
    protected val experience: Int = 0
) : Person2(name, age) {
    protected open val paradigm = "ООП"
    protected open val language = "всех"
    open fun writeCode() = println("$name может писать $paradigm код на языке $language")
    open fun getLevel() = when (experience) {
        0 -> "intern"
        in 1..2 -> "junior"
        in 3..4 -> "middle"
        in 5..6 -> "senior"
        else -> "team-lead"
    }
    protected open fun getCoffeeBreak() = Random.nextBoolean()
}

class KotlinDeveloper : Developer {
    constructor(name: String, age: Int) : super(name, age)
    constructor(name: String, age: Int, experience: Int) : super(name, age, experience)

    override val language = "Kotlin"

    override fun writeCode() {
        if (getCoffeeBreak()) {
            println("$name ушел на кофе-брейке")
        } else {
            super.writeCode()
        }
    }
}

class JavaDeveloper : Developer {
    constructor(name: String, age: Int) : super(name, age)
    constructor(name: String, age: Int, experience: Int) : super(name, age, experience)

    override val language = "Java"
}

class ScalaDeveloper : Developer {
    constructor(name: String, age: Int) : super(name, age)
    constructor(name: String, age: Int, experience: Int) : super(name, age, experience)

    override val language = "Scala"
    override val paradigm = "Функциональный"
    override fun getLevel() = when (experience) {
        0 -> "intern"
        in 1..3 -> "junior"
        in 4..6 -> "middle"
        in 7..9 -> "senior"
        else -> "team-lead"
    }
}

fun main() {
    val person1 = Person2("Олег", 30)
    person1.walk()
    person1.eat()
    person1.sleep()
    val driver1 = Driver("Павел", 40, 3)
    driver1.walk()
    driver1.drive()
    val dev1 = Developer("Василий", 25)
    dev1.writeCode()
//    println(dev1.getLevel())
    val ktDev = KotlinDeveloper("Николай", 39, 5)
    val scalaDev = ScalaDeveloper("Виктор", 31, 5)
    ktDev.writeCode()
    ktDev.writeCode()
    scalaDev.writeCode()
//    println(ktDev.getLevel())
//    println(scalaDev.getLevel())
}