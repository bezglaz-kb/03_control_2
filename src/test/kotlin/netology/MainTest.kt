package netology

import org.junit.Assert
import org.junit.Test

class MainTest {

    // --- ТЕСТЫ ДЛЯ MASTERCARD ---
    @Test
    fun calculateCommission_Mastercard_limitPerMonth() {
        val cardType = "Mastercard"
        val sumMonth = 650_000
        val operationSum = 1000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(-1, result)
    }
    @Test
    fun calculateCommission_Mastercard_NoMinFreeLimit_NoLimitPerDay() {
        val cardType = "Mastercard"
        val sumMonth = 0
        val operationSum = 200

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(21, result)
    }

    @Test
    fun calculateCommission_Mastercard_NoMaxFreeLimit_NoLimitPerDay() {
        val cardType = "Mastercard"
        val sumMonth = 0
        val operationSum = 1000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(0, result)
    }

    @Test
    fun calculateCommission_Mastercard_YesMaxFreeLimit_NoLimitPerDay() {
        val cardType = "Mastercard"
        val sumMonth = 0
        val operationSum = 80000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(50, result)
    }

    @Test
    fun calculateCommission_Mastercard_YesMaxFreeLimit_YesLimitPerDay() {
        val cardType = "Mastercard"
        val sumMonth = 0
        val operationSum = 200000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(-1, result)
    }

    @Test
    fun calculateCommission_Mastercard_LimitPerMonthInOperation() {
        val cardType = "Mastercard"
        val sumMonth = 65000
        val operationSum = 11000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(26, result)
    }

    @Test
    fun calculateCommission_Mastercard_LimitPerMonthYes() {
        val cardType = "Mastercard"
        val sumMonth = 76000
        val operationSum = 1000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(26, result)
    }

    // --- ТЕСТЫ ДЛЯ MAESTRO ---
    @Test
    fun calculateCommission_Maestro_limitPerMonth() {
        val cardType = "Maestro"
        val sumMonth = 650_000
        val operationSum = 1000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(-1, result)
    }

    @Test
    fun calculateCommission_Maestro_NoMinFreeLimit_NoLimitPerDay() {
        val cardType = "Maestro"
        val sumMonth = 0
        val operationSum = 200

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(21, result)
    }

    @Test
    fun calculateCommission_Maestro_NoMaxFreeLimit_NoLimitPerDay() {
        val cardType = "Maestro"
        val sumMonth = 0
        val operationSum = 1000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(0, result)
    }

    @Test
    fun calculateCommission_Maestro_YesMaxFreeLimit_NoLimitPerDay() {
        val cardType = "Maestro"
        val sumMonth = 0
        val operationSum = 80000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(50, result)
    }

    @Test
    fun calculateCommission_Maestro_YesMaxFreeLimit_YesLimitPerDay() {
        val cardType = "Maestro"
        val sumMonth = 0
        val operationSum = 200000

        val result = calculateCommission(cardType, sumMonth, operationSum)
        Assert.assertEquals(-1, result)
    }
        // --- ТЕСТЫ ДЛЯ VISA ---
    @Test
        fun calculateCommission_Visa_YesMinFee() {
            val cardType = "Visa"
            val sumMonth = 0
            val operationSum = 6000

            val result = calculateCommission(cardType, sumMonth, operationSum)
            Assert.assertEquals(45, result)
        }
    @Test
        fun calculateCommission_Visa_NoMinFee() {
            val cardType = "Visa"
            val sumMonth = 0
            val operationSum = 4000

            val result = calculateCommission(cardType, sumMonth, operationSum)


            Assert.assertEquals(35, result)
        }

    @Test
    fun calculateCommission_Visa_limitPerDay() {
        val cardType = "Visa"
        val sumMonth = 0
        val operationSum = 200000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(-1, result)
    }

    @Test
    fun calculateCommission_Visa_limitPerMonth() {
        val cardType = "Visa"
        val sumMonth = 650_000
        val operationSum = 1000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(-1, result)
    }
    // --- ТЕСТЫ ДЛЯ Mir ---
    @Test
    fun calculateCommission_Mir_YesMinFee() {
        val cardType = "Mir"
        val sumMonth = 0
        val operationSum = 6000

        val result = calculateCommission(cardType, sumMonth, operationSum)
        Assert.assertEquals(45, result)
    }

    @Test
    fun calculateCommission_Mir_NoMinFee() {
        val cardType = "Mir"
        val sumMonth = 0
        val operationSum = 4000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(35, result)
    }

    @Test
    fun calculateCommission_Mir_limitPerDay() {
        val cardType = "Mir"
        val sumMonth = 0
        val operationSum = 200000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(-1, result)
    }

    @Test
    fun calculateCommission_Mir_limitPerMonth() {
        val cardType = "Mir"
        val sumMonth = 650_000
        val operationSum = 1000

        val result = calculateCommission(cardType, sumMonth, operationSum)

        Assert.assertEquals(-1, result)
    }

    // --- ТЕСТЫ ДЛЯ VK Pay ---
    @Test
    fun calculateCommission_VK_maxSumForOneTime() {
        val cardType = "VK Pay"
        val sumMonth = 0
       val operationSum = 16000

        val result = calculateCommission(cardType, sumMonth, operationSum)
        Assert.assertEquals(-1, result)
    }

    @Test
    fun calculateCommission_VK_maxSumForMonth() {
        val cardType = "VK Pay"
        val sumMonth = 41000
        val operationSum = 100

        val result = calculateCommission(cardType, sumMonth, operationSum)
        Assert.assertEquals(-1, result)
    }

    @Test
    fun calculateCommission_VK_maxSumForMonthInOperation() {
        val cardType = "VK Pay"
        val sumMonth = 30000
        val operationSum = 20000

        val result = calculateCommission(cardType, sumMonth, operationSum)
        Assert.assertEquals(-1, result)
    }

    @Test
    fun calculateCommission_VK_normal() {
        val cardType = "VK Pay"
        val sumMonth = 1000
        val operationSum = 1000

        val result = calculateCommission(cardType, sumMonth, operationSum)
        Assert.assertEquals(0, result)
    }

    @Test
    fun calculateCommission_unknownCard() {
        val cardType = "Qiwi"
        val sumMonth = 1000
        val operationSum = 1000

        val result = calculateCommission(cardType, sumMonth, operationSum)
        Assert.assertEquals(-1, result)
    }
}