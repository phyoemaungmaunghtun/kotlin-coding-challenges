package com.igorwojda.list.coins

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun main() {
   recursive(4, listOf(1,2,3), emptyList())
}

private fun recursive(amount: Int, coins: List<Int>, current: List<Int>) {

    //exact case
    if (amount == 0) {
        println(current.joinToString(", "))
        return
    }

    //impossible case
    if (amount < 0) {
        return
    }

    for (coin in coins) {
        recursive(amount - coin, coins, current + coin)
    }
}

private fun getCoins(amount: Int, coins: List<Int>): Int {
    val waysOfCoins = IntArray(amount + 1)
    waysOfCoins[0] = 1

    for (coin in coins) {
        (coin..amount).forEach {
            val remainingAmount = it - coin
            waysOfCoins[it] += waysOfCoins[remainingAmount]
        }
    }

    return waysOfCoins[amount]
}

private class Test {
    @Test
    fun `4 wys`() {
        val actual: Int = getCoins(4, listOf(1, 2, 3))
        val expected = 4
        actual shouldBeEqualTo expected
    }

    @Test
    fun `one way`() {
        val actual: Int = getCoins(0, listOf(1, 2))
        val expected = 1
        actual shouldBeEqualTo expected
    }

    @Test
    fun `no coins returns 0`() {
        val actual: Int = getCoins(1, listOf())
        val expected = 0
        actual shouldBeEqualTo expected
    }

    @Test
    fun `big coins`() {
        val actual: Int = getCoins(5, listOf(25, 50))
        val expected = 0
        actual shouldBeEqualTo expected
    }

    @Test
    fun `big amount`() {
        val actual: Int = getCoins(50, listOf(5, 10))
        val expected = 6
        actual shouldBeEqualTo expected
    }

    @Test
    fun `a lot of change`() {
        val actual: Int = getCoins(100, listOf(1, 5, 10, 25, 50))
        val expected = 292
        actual shouldBeEqualTo expected
    }
}
