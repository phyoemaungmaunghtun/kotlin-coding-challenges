package com.igorwojda.integer.factorial

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test
import kotlin.time.times

private fun factorial(n: Int): Int {
    return solution.s1(n)
}

object solution{
    fun s1(n:Int):Int{
        var total = 1

        (1..n).forEach {
            total*= it
        }

        return total

    }

    fun s2(n:Int):Int= when(n){
        0 -> 1
        else -> (n downTo 1).reduce { acc, i -> acc * i }
    }

    fun s3(n:Int):Int = when(n){
        0,1 -> 1
        else -> n * s3(n-1)
    }


    fun s4(n:Int):Int{
       fun helper(n:Int):Int = when(n){
           0,1 -> 1
           else -> n * helper(n -1)
       }

        return helper(n)
    }

}

class RecursiveFactorial {
    @Test
    fun `factorial 0 should equal 1`() {
        factorial(0) shouldBeEqualTo 1
    }

    @Test
    fun `factorial 3 should equal 6`() {
        factorial(3) shouldBeEqualTo 6
    }

    @Test
    fun `factorial 5 should equal 120`() {
        factorial(5) shouldBeEqualTo 120
    }

    @Test
    fun `factorial 10 should equal 3628800`() {
        factorial(10) shouldBeEqualTo 3628800
    }
}
