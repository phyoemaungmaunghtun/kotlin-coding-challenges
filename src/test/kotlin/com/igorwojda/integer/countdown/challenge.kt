package com.igorwojda.integer.countdown

import com.igorwojda.integer.countdown.solution.s2
import com.igorwojda.integer.countdown.solution.s3
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun countDown(n: Int): List<Int> {
    return s2(n)
}

object solution{
    fun s1(n: Int):List<Int>{
        return (n downTo 0).toList()
    }

    fun s2(n: Int):List<Int>{
       if(n == 0){
           return listOf(0)
       }
        return mutableListOf(n).also { it.addAll(s2(n-1)) }
    }

    fun s3(n:Int):List<Int>{

       fun helper(n:Int):MutableList<Int>{
           if(n == 0){
                return mutableListOf(0)
           }
           return mutableListOf(n).also { it.addAll(helper(n-1)) }
       }

        return helper(n).toList()
    }
}

private class Test {
    @Test
    fun `count down 0`() {
        countDown(0) shouldBeEqualTo listOf(0)
    }

    @Test
    fun `count down 1`() {
        countDown(1) shouldBeEqualTo listOf(1, 0)
    }

    @Test
    fun `count down 5`() {
        countDown(5) shouldBeEqualTo listOf(5, 4, 3, 2, 1, 0)
    }
}
