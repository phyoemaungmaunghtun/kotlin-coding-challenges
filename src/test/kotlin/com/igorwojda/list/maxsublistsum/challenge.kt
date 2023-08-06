package com.igorwojda.list.maxsublistsum

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test
import kotlin.math.max

fun maxSubListSum(list: List<Int>, numElements: Int): Int? {
    return solution.s4(list,numElements)
}

object solution{
    fun s1(list:List<Int>,numElements: Int):Int?{
       if(list.isEmpty()){
           return null
       }
        var maxSum = list.take(numElements).sum()
        var tempSum = maxSum
        (numElements..list.lastIndex).forEach { index->
            tempSum = tempSum - list[index - numElements] + list[index]
            maxSum = max(tempSum,maxSum)
        }
        return maxSum
    }

    fun s2(list: List<Int>, numElements: Int):Int?{
       if(list.size < numElements){
           return null
       }
        return list.foldIndexed(0 to 0){ index,(sum,max),value->
            (sum + value - (list.getOrNull(index - numElements) ?: 0)).let {
                it to if(it > max) it else max
            }
        }.second
    }

    fun s3(list: List<Int>, numElements: Int):Int?{
       if(list.size < numElements){
           return null
       }
        var maxSum :Int? = null
        for(i in 0..(list.size - numElements)){
            var temSum :Int? = null
            for(j in i until (i + numElements)){
                if(temSum == null){
                    temSum = list[j]
                }else{
                    temSum += list[j]
                }
            }
            maxSum = max(temSum,maxSum)
        }
        return maxSum
    }

    fun s4(list: List<Int>, numElements: Int):Int?{
       if(list.size < numElements){
           return null
       }
        return (0..(list.size - numElements)).maxOfOrNull { i ->
            list.subList(i, (i + numElements)).sum()
        }
    }
}

private fun max(i1: Int?, i2: Int?): Int? {
    return when {
        i1 != null && i2 != null -> max(i1, i2)
        i1 != null && i2 == null -> i1
        i1 == null && i2 != null -> i2
        else -> null
    }
}

private class Test {
    @Test
    fun `max sublist sum for list 4, 2, 7 and n 2 `() {
        maxSubListSum(listOf(4, 2, 7), 2) shouldBeEqualTo 9
    }

    @Test
    fun `max sublist sum for list 4, 2, 7, 5, 8, 9, 5, 1 and n 3 `() {
        maxSubListSum(listOf(4, 2, 7, 5, 8, 9, 5, 1), 3) shouldBeEqualTo 22
    }

    @Test
    fun `max sublist sum for list 1,2,5,2,8,1,5 and n 4 `() {
        maxSubListSum(listOf(1, 2, 5, 2, 8, 1, 5), 4) shouldBeEqualTo 17
    }

    @Test
    fun `max sublist sum for empty list and n 5 `() {
        maxSubListSum(emptyList(), 5) shouldBeEqualTo null
    }
}
