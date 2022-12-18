import kotlin.reflect.typeOf

fun main() {
//    println("Введите ваше имя: ")
//    var name: String = readln()
//    println("Добрый вечер, $name!")
    var age: UByte = 240u
//    1 байт = 8 бит -> 2^8 = 256 -> [0..255] -> [-128...127]
    // UByte - Unsigned bute
    var colorsCount: UShort = 32767u
//    2 байта = 16 бит -> 2^16 -> [0..65535] -> [32768..32767]
    var peopleInMoscow: UInt = 15_000_000u
//    4 байта = 32 бит -> 2^32 -> [0..4 млрд] -> [-2 млрд.. 2 млрд]
    var earthPopulation: Long = 5_000_000_000
//    8 байт = 64 бита -> [0..10^19] -> [-10^19/2..10^19/2]
    var height: Float = 1.86f
    var weight: Double = 86.6

    var separator: Char = 'a'
//    println("Hello${separator}world!")
//    println(separator.code)
//    var some_string = readln()
//    var isIn = some_string.contains("а")
//    var isNotIn = !some_string.contains("а")
//    println(isIn)
//    println(isNotIn)
//
//    var res = some_string.replace('а', 'б', true)
//    println(res)
//
//    println("gdshkfhgdhsf".uppercase())
//    println("DFGDFGDFGDFG".lowercase())

//    var numbers: List<Int> = listOf(-16, 2, 13, 41, 10)
//    println(numbers[0])
//    println(numbers.first())
//    println(numbers.size)
//    println(numbers[numbers.size - 1])
//    println(numbers.last())
//    println(numbers.indexOf(130))
//    println(numbers.lastIndexOf(13))
//    println(numbers.subList(1, 4+1))
//    println(130 in numbers)
//    println(numbers.indices)
//    println(numbers.asReversed())
//    println(numbers.distinct())
//    println(numbers.chunked(2))
//    println(numbers.sorted())
//    println(numbers.shuffled())
//
//    var ages = mutableListOf(1, 5, -4, 5, 10)
//    ages[0] = 1000
//    println(ages)
//    ages.add(70)
//    println(ages)
//    ages.add(2, 76)
//    println(ages)

    // последовательности и циклы ------------------------------------

//    val range1 = 1..10
//    for (i in range1) print("$i ")
//
//    println()
//    val range2 = 1 until 10
//    for (i in range2) print("$i ")
//    println()
//
//    val alphabet = 'a'..'z'
//    for (i in alphabet) print("$i ")
//    println()
//
//    val odd = 1..50 step 2
//    for (i in odd) print("$i ")
//    println()
//
//    val even = 0..50 step 2
//    for (i in even) print("$i ")
//    println()

//    val descend = 20 downTo 0 step 2
//    for (i in descend) print("$i ")

//    for (i in 20 downTo 0 step 2) print("$i ")

    // Строки и списки ---------------------------------------

//    val cat = "Барсик"
//    println("$cat : ${cat.count()}")
//
//    for (c in cat) print("$c ")
//
//    println()
//    println(cat.indices)
//    for (i in cat.indices) println("$i -> ${cat[i]}")

//    val catCharArray = cat.toCharArray()
//    catCharArray[0] = 'К'
//    println(catCharArray)

//    cat.forEach { print("${it.uppercase()}-") }
//    cat.forEachIndexed { index, c -> println("$index -> $c") }

//    println("Введите перечень через пробел: ")
//    val input = readln()
//    val inputList = input.split(' ')
//    println(inputList)
//    val outputList = mutableListOf<String>()
//    for (city in inputList){
//        outputList.add(city.capitalize())
//    }
//    println(outputList)
//    println(inputList.map { it.capitalize() })

//    val chars = listOf('a', 'b', 'c', 'd')
//    println(chars.joinToString(prefix = "(", separator = " ", postfix = ")"))
//    println(chars.joinToString(separator = "|", transform = {it.uppercase()}))

//    val cats = listOf("Мурзик", "Барсик", "Тигрик", "Мариса")
//    val mutCats = cats.toMutableList()
//    mutCats[0] = "Рыжик"
//    println(mutCats)
//    println(cats.filter { it.startsWith("М") })
//    println(cats.count { it.startsWith("М") })

//    val list = listOf(1, 4, 3, 2, 5)
//    println(list.indices)
//    println(list.map { it*it })
//    println(list.average())
//    println(list.sum())
//    println(list.fold(1){ total, next -> total * next })
//    println(list.maxOf { it })
//    println(list.take(2))
//    println(list.first())
//    println(list.takeLast(2))
//    println(list.sorted())
//    println(list.sortedDescending())
//    println(list.sortedBy { it % 2 == 0 })

//    val listA = mutableListOf("a", "b", "c")
//    val listB = mutableListOf("d", "e", "f")
//    listB.addAll(listA)
//    println(listB)
//
//    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
//    val second = numbers - 4 - 17
//    println(second)

//    println(List(25){ 0 })


    // Разминочный пример
    listOf(1, 3, 3, 2, 4, 1)
        .last()
        .let { println(it) }//=1

    // Задача 1
    listOf(1, 3, 3, 2, 4, 1)
        .count()
        .let { println(it) }//=6

    // Задача 2
    listOf(1, 3, 3, 2, 4, 1)
        .takeLast(2)
        .sum()
        .let { println(it) }//=5

    // Задача 3
    listOf(1, 3, 3, 2, 4, 1)
        .map { it }
        .sum()
        .let { println(it) }//=14

    // Задача 4
    listOf(1, 3, 3, 2, 4, 1)
        .distinct()
        .average()
        .let { println(it) }//=2.5

    // Задача 5
    listOf(1, 3, 3, 2, 4, 1)
        .map { 8 }
        .average()
        .let { println(it) }//=8.0

    // Задача 6
    listOf(1, 3, 3, 2, 4, 1)
        .filter { it % 2 == 1 }
        .sum()
        .let { println(it) }//=8

    // Задача 7
    listOf(1, 3, 3, 2, 4, 1)
        .fold(1){ total, next -> total * next }
        .let { println(it) }//=72

    // Задача 10
    listOf(1, 3, 3, 2, 4, 1)
        .indices
        .sum()
        .let { println(it) }//=15
}