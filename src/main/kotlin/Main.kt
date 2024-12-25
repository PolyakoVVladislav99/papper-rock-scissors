import kotlin.random.Random

fun main() {
    println("Добро пожаловать в игру 'Камень-Ножницы-Бумага'!")
    val choices = mapOf(1 to "Камень", 2 to "Ножницы", 3 to "Бумага")

    while (true) {
        println("Выберите: 1 - Камень, 2 - Ножницы, 3 - Бумага")
        val playerChoice = readLine()?.toIntOrNull()

        if (playerChoice !in choices.keys) {
            println("Ошибка: Введите число от 1 до 3.")
            continue
        }

        val computerChoice = Random.nextInt(1, 4)
        println("Ваш выбор: ${choices[playerChoice]}")
        println("Выбор компьютера: ${choices[computerChoice]}")

        val result = determineWinner(playerChoice!!, computerChoice)
        when (result) {
            "Игрок" -> {
                println("Вы победили!")
                break
            }
            "Компьютер" -> {
                println("Компьютер победил!")
                break
            }
            "Ничья" -> println("Ничья! Попробуйте снова.")
        }
    }
}

fun determineWinner(player: Int, computer: Int): String {
    return when {
        player == computer -> "Ничья"
        (player == 1 && computer == 2) ||
                (player == 2 && computer == 3) ||
                (player == 3 && computer == 1) ->
            "Игрок"
        else -> "Компьютер"
    }
}
