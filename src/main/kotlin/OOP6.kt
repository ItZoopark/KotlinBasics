import kotlin.random.Random
import kotlin.random.nextInt

open class Animal(
    protected var energy: Int,
    protected var weight: Int,
    protected val maxAge: Int,
    protected val name: String
) {
    private var currentAge: Int = 0
    var isTooOld = currentAge > maxAge

    fun sleep() {
        if (isTooOld) return
        energy += 5
        currentAge += 1
        println("$name спит")
    }

    fun eat() {
        if (isTooOld) return
        energy += 3
        weight += 1
        tryIncrementAge()
        println("$name ест")
    }

    open fun move(): Boolean {
        if (isTooOld) return false
        energy += 5
        weight += 1
        tryIncrementAge()
        println("$name передвигается")
        return true
    }

    open fun giveBirth(): Animal {
        val newAnimal = Animal(
            name = this.name,
            maxAge = this.maxAge,
            energy = Random.nextInt(1, 11),
            weight = Random.nextInt(1, 5)
        )
        println("был рожден $name $maxAge $energy $weight")
        return newAnimal
    }

    private fun tryIncrementAge() {
        if (Random.nextBoolean())
            currentAge += 1
    }
}

class Bird(
    energy: Int,
    weight: Int,
    maxAge: Int,
    name: String
) : Animal(energy, weight, maxAge, name) {

    override fun move(): Boolean {
        if (super.move()) {
            println("$name еще и летит")
            return true
        }
        return false
    }

    override fun giveBirth(): Bird {
        val newBird = Bird(
            name = this.name,
            maxAge = this.maxAge,
            energy = Random.nextInt(1, 11),
            weight = Random.nextInt(1, 5)
        )
        println("был рожден $name $maxAge $energy $weight")
        return newBird
    }
}

class Fish(
    energy: Int,
    weight: Int,
    maxAge: Int,
    name: String
) : Animal(energy, weight, maxAge, name) {

    override fun move(): Boolean {
        if (super.move()) {
            println("$name еще и плывет")
            return true
        }
        return false
    }

    override fun giveBirth(): Fish {
        val newFish = Fish(
            name = this.name,
            maxAge = this.maxAge,
            energy = Random.nextInt(1, 11),
            weight = Random.nextInt(1, 5)
        )
        println("был рожден $name $maxAge $energy $weight")
        return newFish
    }
}

class Dog(
    energy: Int,
    weight: Int,
    maxAge: Int,
    name: String
) : Animal(energy, weight, maxAge, name) {

    override fun move(): Boolean {
        if (super.move()) {
            println("$name еще и бежит")
            return true
        }
        return false
    }

    override fun giveBirth(): Dog {
        val newDog = Dog(
            name = this.name,
            maxAge = this.maxAge,
            energy = Random.nextInt(1, 11),
            weight = Random.nextInt(1, 5)
        )
        println("был рожден $name $maxAge $energy $weight")
        return newDog
    }
}

class NatureReserve{
    companion object {
        private const val maxRange = 5
        fun createAnimals(
            countBird: Int = Random.nextInt(1, maxRange),
            countFish: Int = Random.nextInt(1, maxRange),
            countDog: Int = Random.nextInt(1, maxRange),
            countOther: Int = Random.nextInt(1, maxRange)
        ): List<Animal> {
            val animals = mutableListOf<Animal>()
            for (i in 1..countBird) {
                animals.add(
                    Bird(
                        energy = Random.nextInt(1, 101),
                        weight = Random.nextInt(1, 30),
                        maxAge = Random.nextInt(1, 100),
                        name = "bird_$i"
                    )
                )
            }
            for (i in 1..countFish) {
                animals.add(
                    Fish(
                        energy = Random.nextInt(1, 101),
                        weight = Random.nextInt(1, 30),
                        maxAge = Random.nextInt(1, 100),
                        name = "fish_$i"
                    )
                )
            }
            for (i in 1..countDog) {
                animals.add(
                    Dog(
                        energy = Random.nextInt(1, 101),
                        weight = Random.nextInt(1, 30),
                        maxAge = Random.nextInt(1, 100),
                        name = "dog_$i"
                    )
                )
            }
            for (i in 1..countOther) {
                animals.add(
                    Animal(
                        energy = Random.nextInt(1, 101),
                        weight = Random.nextInt(1, 30),
                        maxAge = Random.nextInt(1, 100),
                        name = "animal_$i"
                    )
                )
            }
            return animals
        }
    }
}

fun main() {
    val animals = NatureReserve.createAnimals(countBird = 5, countFish = 3, countDog = 2).toMutableList()
    val N = Random.nextInt(20, 50)
    for (i in 1..N){
        animals.shuffled().forEach { animal ->
            when(Random.nextInt(1, 5)){
                1 -> animal.eat()
                2 -> animals.add(animal.giveBirth())
                3 -> animal.move()
                4 -> animal.sleep()
            }
            if (animal.isTooOld)
                animals.remove(animal)
        }
        if (animals.isEmpty()){
            println("В заповедники нет больше животных")
            return
        }
    }
    println("В заповеднике осталось ${animals.size} животных")
}