package com.igorwojda.list.sumzero

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun sumZero(list: List<Int>): Pair<Int, Int>? {
    return solution.s2(list)
}

object solution{
    fun s1(list: List<Int>):Pair<Int,Int>?{
        if(list.isEmpty()){
            return null
        }
        var pointer1 = 0
        var pointer2 = list.lastIndex

        while(pointer1 != pointer2){
            val element1 = list[pointer1]
            val element2 = list[pointer2]
            val sum = element1 + element2

            when{
                sum == 0 -> return Pair(element1,element2)
                sum > 0 -> pointer2--
                sum < 0 -> pointer1++
            }
        }

        return null
    }

    fun s2(list:List<Int>):Pair<Int,Int>?{
        list.forEachIndexed { index, element1 ->
            (index..list.lastIndex).forEach { index2 ->
                if(element1 + list[index2] == 0){
                    return element1 to list[index2]
                }
            }
        }
        return null
    }
}

private class Test {
    @Test
    fun `sumZero empty list return null`() {
        sumZero(listOf()) shouldBeEqualTo null
    }

    @Test
    fun `sumZero 1, 2 return null`() {
        sumZero(listOf(1, 2)) shouldBeEqualTo null
    }

    @Test
    fun `sumZero 1, 2, 4, 7 return null`() {
        sumZero(listOf(1, 2, 4, 7)) shouldBeEqualTo null
    }

    @Test
    fun `sumZero -4, -3, -2, 1, 2, 3, 5 return Pair(-3, 3)`() {
        sumZero(listOf(-4, -3, -2, 1, 2, 3, 5)) shouldBeEqualTo Pair(-3, 3)
    }

    @Test
    fun `sumZero -4, -3, -2, 1, 2, 5 return Pair(-2, 2)`() {
        sumZero(listOf(-4, -3, -2, 1, 2, 5)) shouldBeEqualTo Pair(-2, 2)
    }
}
