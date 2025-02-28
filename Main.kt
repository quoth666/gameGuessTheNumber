package org.quoth

import kotlin.random.Random

fun main() {
    println("Игра: Угадай число")

    // Выбор сложности
    print(
        "Выберите сложность:\n" +
                "1) 1-9\n" +
                "2) 1-99\n" +
                "3) 1-999\n" +
                "Введите номер выбранной сложности: "
    )
    val difficulty = readln().toInt()

    val range = when (difficulty) {
        1 -> 1..9
        2 -> 1..99
        3 -> 1..999
        else -> error("Некорректный выбор сложности. Введите от 1 до 3.")
    }

    // Генерация случайного числа
    val secretNumber = Random.nextInt(range.first, range.last + 1)
    var attempts = 0 // Счётчик попыток

    println("Число загадано. Попробуйте угадать!")

    // Основной игровой цикл
    while (true) {
        print("Введите ваше число: ")
        val guess = readln().toIntOrNull()

        if (guess == null) {
            println("Пожалуйста, введите корректное число.")
            continue
        }

        attempts++ // Увеличиваем счётчик попыток

        when {
            guess < secretNumber -> println("Загаданное число больше.")
            guess > secretNumber -> println("Загаданное число меньше.")
            else -> {
                println("Поздравляем! Вы угадали число $secretNumber за $attempts попыток.")
                break // Завершаем игру
            }
        }
    }
}