package com.igorwojda.integer.countupanddown

import com.igorwojda.integer.countupanddown.solution.s1
import com.igorwojda.integer.countupanddown.solution.s2
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun countUpAndDown(n: Int): List<Int> {
    return s2(n)
}

object solution{
     fun s1(n:Int):List<Int> {
         val size = (n * 2) + 1
         return List(size){
             when{
                 it <= n -> it
                 else  -> (n*2) - it
             }
         }
     }
    fun s2(n:Int):List<Int>{
        return (0 until n) + (n downTo 0)
    }
    }

private class Test {
    @Test
    fun `count up and down 0`() {
        countUpAndDown(0) shouldBeEqualTo listOf(0)
    }

    @Test
    fun `count up and down 1`() {
        countUpAndDown(1) shouldBeEqualTo listOf(0, 1, 0)
    }

    @Test
    fun `count up and down 2`() {
        countUpAndDown(2) shouldBeEqualTo listOf(0, 1, 2, 1, 0)
    }

    @Test
    fun `count up and down 3`() {
        countUpAndDown(3) shouldBeEqualTo listOf(0, 1, 2, 3, 2, 1, 0)
    }

    @Test
    fun `count up and down 4`() {
        countUpAndDown(4) shouldBeEqualTo listOf(0, 1, 2, 3, 4, 3, 2, 1, 0)
    }

    @Test
    fun `count up and down 9`() {
        countUpAndDown(9) shouldBeEqualTo listOf(
            0,
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8,
            9,
            8,
            7,
            6,
            5,
            4,
            3,
            2,
            1,
            0
        )
    }
}
