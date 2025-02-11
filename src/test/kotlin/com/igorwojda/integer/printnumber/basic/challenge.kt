package com.igorwojda.integer.printnumber.basic

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun printNumber(n: Int): List<Int> {
    return solution.s3(n)
}

object solution{
    fun s1(n: Int):List<Int>{
        return (n downTo 1).toList()
    }
    fun s2(n:Int):List<Int> =
        when{
            n == 0 -> emptyList()
            else -> listOf(n) + s2(n-1)
        }

    fun s3(n:Int):List<Int>{
        val list = mutableListOf<Int>()
        if(n == 0){
            return emptyList()
        }else{
            list.add(n)
        }
        list.addAll(s3(n - 1))
        return list
    }
}

class RecursivePrintNumber {
    @Test
    fun `printNumber 0 return listOf()`() {
        printNumber(0) shouldBeEqualTo listOf()
    }

    @Test
    fun `printNumber 1 return listOf(1)`() {
        printNumber(1) shouldBeEqualTo listOf(1)
    }

    @Test
    fun `printNumber 3 return listOf(3, 2, 1)`() {
        printNumber(3) shouldBeEqualTo listOf(3, 2, 1)
    }

    @Test
    fun `printNumber 5 return listOf(5, 4, 3, 2, 1)`() {
        printNumber(5) shouldBeEqualTo listOf(5, 4, 3, 2, 1)
    }
}
