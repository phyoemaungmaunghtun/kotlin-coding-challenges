package com.igorwojda.list.search.binarysearch

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun binarySearch(list: List<Char>, element: Char): Int {
    var left = 0
    var right = list.size - 1
    while (left <= right){
        val mid = (left + right) / 2
        if(list[mid] == element){
            return mid
        }
        if(list[mid] < element){
            left = mid + 1
        }else{
            right = mid - 1
        }
    }

 return -1
}

private class Test {
    @Test
    fun `index of A in A, B, C is 0`() {
        binarySearch(listOf('A', 'B', 'C'), 'A') shouldBeEqualTo 0
    }

    @Test
    fun `index of B in A, B, C is 1`() {
        binarySearch(listOf('A', 'B', 'C'), 'B') shouldBeEqualTo 1
    }

    @Test
    fun `index of C in A, B, C is 2`() {
        binarySearch(listOf('A', 'B', 'C'), 'C') shouldBeEqualTo 2
    }

    @Test
    fun `index of H in A, B, C is -1`() {
        binarySearch(listOf('A', 'B', 'C'), 'H') shouldBeEqualTo -1
    }

    @Test
    fun `index of A in A, B, C, D is 0`() {
        binarySearch(listOf('A', 'B', 'C', 'D'), 'A') shouldBeEqualTo 0
    }

    @Test
    fun `index of B in A, B, C, D is 1`() {
        binarySearch(listOf('A', 'B', 'C', 'D'), 'B') shouldBeEqualTo 1
    }

    @Test
    fun `index of C in A, B, C, D is 2`() {
        binarySearch(listOf('A', 'B', 'C', 'D'), 'C') shouldBeEqualTo 2
    }

    @Test
    fun `index of D in A, B, C, D is 2`() {
        binarySearch(listOf('A', 'B', 'C', 'D'), 'D') shouldBeEqualTo 3
    }

    @Test
    fun `index of H in A, B, C, D is -1`() {
        binarySearch(listOf('A', 'B', 'C', 'D'), 'H') shouldBeEqualTo -1
    }
}
