package com.igorwojda.integer.printnumber.steps

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun printNumber(n: Int, step: Int = 1): List<Int> {
    return solution.s1(n,step)
}

object solution{
    fun s1(n:Int,step: Int = 1):List<Int>{
        return (n downTo 1 step step).toList()
    }
    fun s2(n: Int,step: Int = 1):List<Int> = when{
        n <= 0 -> emptyList()
        else -> listOf(n) + s2(n - step,step)
    }

    fun s3(n: Int,step: Int = 1):List<Int>{
       val result = mutableListOf<Int>()

        if(n <= 0){
            return emptyList()
        }else{
            result.add(n)
        }

        result.addAll(s3(n - step, step))

        return result
    }
}

class RecursivePrintNumberWithSteps {
    @Test
    fun `printNumber 0 step 1 return listOf()`() {
        printNumber(0, 1) shouldBeEqualTo listOf()
    }

    @Test
    fun `printNumber 1 step 1 return listOf(1)`() {
        printNumber(1, 1) shouldBeEqualTo listOf(1)
    }

    @Test
    fun `printNumber 3 step 2 return listOf(3, 1)`() {
        printNumber(3, 2) shouldBeEqualTo listOf(3, 1)
    }

    @Test
    fun `printNumber 11 step 3 return listOf(1, 8, 5, 2)`() {
        printNumber(11, 3) shouldBeEqualTo listOf(11, 8, 5, 2)
    }
}
