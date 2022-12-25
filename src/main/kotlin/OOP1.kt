class Person{
    private var name: String = ""
    private var surName: String = ""
    private var age: Int = 0
    private var passportNumber: Long = 0

    fun show(){
        println("$name $surName $age")
    }

    fun fillData(){
        println("Введите ваше имя:")
        name = readln()
        println("Введите вашу фамилию:")
        surName = readln()
        println("Введите ваш возраст:")
        age = readln().toInt()
        println("Введите ваш паспорт:")
        passportNumber = readln().toLong()
    }

}

class Student(
    private val name: String,
    private val surName: String,
    private val age: Int
    ){

    private var mathScore: Int = 0
    private var rusScore: Int = 0
    private var thirdScore: Int = 0

    fun setScores(mathScore: Int, rusScore: Int, thirdScore: Int){
        this.mathScore = mathScore
        this.rusScore = rusScore
        this.thirdScore = thirdScore
    }

    fun isEnoughForUniversity(university: String, faculty: String, threshold: Int) =
        (mathScore + rusScore + thirdScore) >= threshold

    fun show(){
        println("$name $surName $age")
    }
}

fun main(){
//    val person1 = Person()
//    person1.fillData()
//    person1.show()
//
//    val person2 = Person()
//    person2.fillData()
//    person2.show()

    val student1 = Student("Иван", "Иванов", 15)
    student1.setScores(90, 95, 95)
    println(student1.isEnoughForUniversity(university = "MSU Lomonosov", faculty = "VMK", threshold = 285))
//    student1.show()
}