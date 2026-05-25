package netology

import kotlin.math.max

fun main() {
//    val test1 = calculateCommission("Mastercard", 0, 200)
//    println("Тест 1 (Mastercard, сумма предыдущих переводов в этом месяце 0, сумма операции 80000): $test1")
//
//    val test2 = calculateCommission("Mastercard", 50000, 50000)
//    println("Тест 2 (Mastercard, сумма предыдущих переводов в этом месяце 50000, сумма операции 50000): $test2")
//
//    val test3 = calculateCommission("Visa", 0, 4000)
//    println("Тест 3 (Visa, сумма предыдущих переводов в этом месяце 0, сумма операции 4000): $test3")
//
//    val test4 = calculateCommission("Mir", 0, 100000)
//    println("Тест 4 (Mir, сумма предыдущих переводов в этом месяце 0, сумма операции 100000): $test4")
//
//    val test5 = calculateCommission("Mir", 670000, 50000)
//    println("Тест 5 (Mir, сумма предыдущих переводов в этом месяце 670000, сумма операции 50000): $test5")
//
//    val test6 = calculateCommission("Mir", 0, 200000)
//    println("Тест 6 (Mir, сумма предыдущих переводов в этом месяце 0, сумма операции 200000): $test6")
//
//    val test7 = calculateCommission("VK Pay", 0, 20000)
//    println("Тест 7 (VK Pay, сумма предыдущих переводов в этом месяце 0, сумма операции 20000): $test7")

    val test8 = calculateCommission("VK Pay", 0, 10000)
    println("Тест 8 (VK Pay, сумма предыдущих переводов в этом месяце 0, сумма операции 10000): $test8")
}

fun calculateCommission(
    cardType: String,
    sumMonth: Int = 0,
    operationSum: Int
): Int {
    val limitPerDay = 150_000
    val limitPerMonth = 600_000

    if (operationSum > limitPerDay || sumMonth + operationSum > limitPerMonth) {
        println("Ошибка: Превышены лимиты банка.")
        return -1
    }

    return when (cardType) {
        "Mastercard", "Maestro" -> {
            val minFreeLimit = 300
            val maxFreeLimit = 75_000
            val percent = 0.006
            val fixFee = 20

            when {
                sumMonth >= maxFreeLimit || operationSum < minFreeLimit -> {
                    (operationSum * percent + fixFee).toInt()
                }

                sumMonth + operationSum > maxFreeLimit -> {
                    val calcSum = (sumMonth + operationSum) - maxFreeLimit
                    (calcSum * percent + fixFee).toInt()
                }

                else -> 0
            }
        }

        "Visa", "Mir" -> {
            val percent = 0.0075
            val minFee = 35

            val calculatedFee = (operationSum * percent).toInt()
            max(calculatedFee, minFee)
        }

        "VK Pay" -> {
            val maxSumForOneTime = 15_000
            val maxSumForMonth = 40_000

            if (operationSum > maxSumForOneTime || sumMonth + operationSum > maxSumForMonth) {
                println("Ошибка: Превышены лимиты VK Pay.")
                return -1
            }
            0
        }

        else -> {
            0
        }
    }
}
