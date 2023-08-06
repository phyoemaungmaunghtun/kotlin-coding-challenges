package com.igorwojda.list.product

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun product(list: List<Int>): Int {
    return solution.s1(list)
}

object solution{
    fun s1(list: List<Int>):Int{
        return list.reduce { acc, current -> acc * current  }
    }
    fun s2(list:List<Int>):Int{
        if(list.size == 1){
            return list.first()
        }

        return list.first() * s2(list.drop(1))
    }

    fun s3(list:List<Int>):Int{
        fun prod(acc:Int,list:List<Int>):Int{
            if(list.isEmpty()){
                return acc
            }
            return prod(acc * list.first(),list.drop(1))
        }
        return prod(1,list)
    }
}

private class Test {
    @Test
    fun `product 0 returns 0`() {
        product(listOf(0)) shouldBeEqualTo 0
    }

    @Test
    fun `product 1, 2, 3 returns 6`() {
        product(listOf(1, 2, 3)) shouldBeEqualTo 6
    }

    @Test
    fun `product 4, 2, 10 returns 80`() {
        product(listOf(2, 4, 10)) shouldBeEqualTo 80
    }
}
