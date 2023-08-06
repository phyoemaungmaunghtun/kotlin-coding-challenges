package com.igorwojda.integer.getodd

import com.igorwojda.integer.getodd.solution.s1
import com.igorwojda.integer.getodd.solution.s2
import com.igorwojda.integer.getodd.solution.s3
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun filterOdd(list: List<Int>): List<Int> {
    return s3(list)
}

object solution{
    fun s1(list: List<Int>):List<Int>{
        return list.filter { it % 2 == 1 }
    }

    fun s2(list: List<Int>):List<Int>{
        if(list.isEmpty()){
            return list
        }
        return if(list.first() % 2 == 1){
            mutableListOf(list.first()) + s2(list.drop(1))
        }else{
            s2(list.drop(1))
        }
    }

    fun s3(list:List<Int>):List<Int>{

        val result = mutableListOf<Int>()

        fun helper(list:List<Int>){
            if(list.isEmpty()){
                return
            }
            if(list.first() % 2 == 1){
                result.add(list.first())
            }

            helper(list.drop(1))
        }
        helper(list)

        return result

    }
}

private class Test {
    @Test
    fun `empty list returns empty list`() {
        filterOdd(listOf()) shouldBeEqualTo emptyList()
    }

    @Test
    fun `1, 2, 3 returns 1, 3`() {
        filterOdd(listOf(1, 2, 3)) shouldBeEqualTo listOf(1, 3)
    }

    @Test
    fun `2, 9, 2, 5, 4 returns 9, 5`() {
        filterOdd(listOf(2, 9, 2, 5, 4)) shouldBeEqualTo listOf(9, 5)
    }

    @Test
    fun `7, 4, 6, 8, 7, 9 returns 7, 7, 9`() {
        filterOdd(listOf(7, 4, 6, 8, 7, 9)) shouldBeEqualTo listOf(7, 7, 9)
    }
}
