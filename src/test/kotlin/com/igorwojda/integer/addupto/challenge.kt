package com.igorwojda.integer.addupto

import com.igorwojda.integer.addupto.solution.s1
import com.igorwojda.integer.addupto.solution.s2
import com.igorwojda.integer.addupto.solution.s3
import com.igorwojda.integer.addupto.solution.s4
import com.igorwojda.integer.addupto.solution.s5
import com.igorwojda.integer.addupto.solution.s6
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun addUpTo(n: Int): Int {
    return s6(n)
}

object solution{
    fun s1(n: Int):Int{
        return (0..n).sum()
    }
    fun s2(n: Int):Int{
        return (0..n).fold(0){acc,value -> acc + value}
    }

    fun s3(n: Int):Int{
        if(n == 1){
            return 1
        }
        return n + s3(n - 1)
    }

    fun s4(n:Int):Int{
        return n * (n + 1)/ 2
    }

    fun s5(n: Int):Int{
     var total = 0
        (0..n).forEach {
            total += it
        }
        return total
    }

    fun s6(n:Int):Int{
        var total = 0
        repeat(n + 1){
            total += it
        }
        return total
    }
}

private class Test {
    @Test
    fun `add up to 1`() {
        addUpTo(1) shouldBeEqualTo 1
    }

    @Test
    fun `add up to 3`() {
        addUpTo(3) shouldBeEqualTo 6
    }

    @Test
    fun `add up to 10`() {
        addUpTo(10) shouldBeEqualTo 55
    }
}
