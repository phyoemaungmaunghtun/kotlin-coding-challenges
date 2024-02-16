package com.igorwojda.integer.power

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test
import kotlin.math.pow

private fun power(base: Int, exponent: Int): Int {
    return solution.s1(base,exponent)
}

object solution{
    fun s1(base: Int,exponent: Int):Int{
        if(exponent == 1){
            return base
        }
        return base * s1(base,exponent - 1)
    }

    fun s2(base: Int,exponent: Int):Int{
        return base.toDouble().pow(exponent).toInt()
    }
}

private class Test {
    @Test
    fun `power 2^1 returns 2`() {
        power(2, 1) shouldBeEqualTo 2
    }

    @Test
    fun `power 2^2 returns 2`() {
        power(2, 2) shouldBeEqualTo 4
    }

    @Test
    fun `power 2^3 returns 8`() {
        power(2, 3) shouldBeEqualTo 8
    }

    @Test
    fun `power 3^4 returns 81`() {
        power(3, 4) shouldBeEqualTo 81
    }
}
