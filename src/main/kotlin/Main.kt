import kotlin.random.Random

fun main(args: Array<String>) {
    var min = args[0].toInt()
    var max = args[1].toInt()
    val target = args[2].toInt()
    var guesses = 0
    var guess = Random.nextInt(min,max)
    println("Min: $min | Max: $max | Target: $target | Guess: $guess")
    while(true) {
        if (guess == target) {
            break
        } else if (guess < target) {
            println("Guessed $guess which is smaller than $target.")
            min = guess
            guesses++
            guess = Random.nextInt(min,max)
        } else {
            println("Guessed $guess which is bigger than $target.")
            max = guess
            guesses++
            guess = Random.nextInt(min,max)
        }
    }
    println("It took $guesses guesses to reach $target")
}