package com.igorwojda.list.squareequal

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun squareEquals(list: List<Int>, squared: List<Int>): Boolean {
    return solution1.s2(list,squared)
}

object solution1{
    fun s1(list: List<Int>, squared: List<Int>):Boolean{
        if(list.size != squared.size)
            return false
        val frequency1 = list.map { it * it }.groupBy { it }
        val frequency2 = squared.groupBy { it }

        return frequency1 == frequency2
    }

    fun s2(list: List<Int>, squared: List<Int>):Boolean{
        val sList = squared.toMutableList()
        if(list.size != squared.size)
            return false

        list.forEach{i ->
            val index = sList.indexOf(i * i)
            if(index == -1){
                return false
            }
            sList.removeAt(index)
        }

        return true
    }
}



private class Test {
    @Test
    fun `square 2 equal square 4`() {
        squareEquals(listOf(2), listOf(4)) shouldBeEqualTo true
    }

    @Test
    fun `square 1, 2, 3 equals square 9, 1, 4`() {
        squareEquals(listOf(1, 2, 3), listOf(9, 1, 4)) shouldBeEqualTo true
    }

    @Test
    fun `square 1, 2, 3 does not equal square 9, 1, 7`() {
        squareEquals(listOf(1, 2, 3), listOf(9, 1, 7)) shouldBeEqualTo false
    }

    @Test
    fun `square 1, 2, 3 does not equal square 9, 1`() {
        squareEquals(listOf(1, 2, 3), listOf(9, 1)) shouldBeEqualTo false
    }

    @Test
    fun `square 1, 2, 1 does not equal 4, 1, 4`() {
        squareEquals(listOf(1, 2, 1), listOf(4, 1, 4)) shouldBeEqualTo false
    }
}
