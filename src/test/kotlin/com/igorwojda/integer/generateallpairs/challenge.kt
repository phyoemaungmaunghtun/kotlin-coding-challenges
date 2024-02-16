package com.igorwojda.integer.generateallpairs

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun getAllPairs(n: Int): List<Pair<Int, Int>> {
    return solution.s1(n)
}

object solution{
    fun s1(n:Int):List<Pair<Int,Int>>{
       val result = mutableListOf<Pair<Int,Int>>()
        (0..n).forEach { i->
            (0..n).forEach { j->
                result.add(i to j)
            }
        }
        return result
    }

    fun s2(n: Int):List<Pair<Int,Int>>{
       return (0..n).map { i->
           (0..n).map { j->
               i to j
           }
       }.flatten()
    }
}

private class Test {
    @Test
    fun `get all pairs 0`() {
        getAllPairs(0) shouldBeEqualTo listOf(0 to 0)
    }

    @Test
    fun `get all pairs 1`() {
        getAllPairs(1) shouldBeEqualTo listOf(
            0 to 0,
            0 to 1,
            1 to 0,
            1 to 1
        )
    }

    @Test
    fun `get all pairs 2`() {
        getAllPairs(2) shouldBeEqualTo listOf(
            0 to 0,
            0 to 1,
            0 to 2,
            1 to 0,
            1 to 1,
            1 to 2,
            2 to 0,
            2 to 1,
            2 to 2
        )
    }
}
