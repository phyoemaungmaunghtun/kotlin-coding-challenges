package com.igorwojda.list.sort.mergesort

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun mergeSort(list: List<Int>): List<Int> {
   if(list.size <= 1){
       return list
   }
    fun merge(left:MutableList<Int>, right:MutableList<Int>):List<Int>{
        val result = mutableListOf<Int>()
        while (left.isNotEmpty() && right.isNotEmpty()){
            if(left.first() < right.first()){
                result.add(left.removeAt(0))
            }else{
                result.add(right.removeAt(0))
            }
        }
        result.addAll(left)
        result.addAll(right)
        return result
    }
    val midPoint = list.size / 2
    val leftSplit = mergeSort(list.subList(0,midPoint)).toMutableList()
    val rightSplit = mergeSort(list.subList(midPoint,list.size)).toMutableList()

    return merge(leftSplit,rightSplit)
}

private class Test {
    @Test
    fun `merge sort empty list`() {
        mergeSort(mutableListOf()) shouldBeEqualTo listOf()
    }

    @Test
    fun `merge sort 7`() {
        mergeSort(mutableListOf(7)) shouldBeEqualTo listOf(7)
    }

    @Test
    fun `merge sort empty list 9, 3`() {
        mergeSort(mutableListOf(9, 3)) shouldBeEqualTo listOf(3, 9)
    }

    @Test
    fun `merge sort 5, 1, 4, 2`() {
        mergeSort(mutableListOf(5, 1, 4, 2)) shouldBeEqualTo listOf(1, 2, 4, 5)
    }

    @Test
    fun `merge sort 5, 2, 1, 8, 4, 7, 6, 3`() {
        mergeSort(mutableListOf(5, 2, 1, 8, 4, 7, 6, 3)) shouldBeEqualTo listOf(
            1,
            2,
            3,
            4,
            5,
            6,
            7,
            8
        )
    }

    @Test
    fun `merge sort 17, 4, 12, 19, 80, 75, 16`() {
        mergeSort(mutableListOf(17, 4, 12, 19, 80, 75, 16)) shouldBeEqualTo listOf(
            4,
            12,
            16,
            17,
            19,
            75,
            80
        )
    }

    @Test
    fun `merge sort 11, 40, 40, 50, 43, 10, 30, 42, 20, 6, 19, 32, 20, 41, 23, 27`() {
        val list = mutableListOf(11, 40, 40, 50, 43, 10, 30, 42, 20, 6, 19, 32, 20, 41, 23, 27)
        val sorted = mutableListOf(6, 10, 11, 19, 20, 20, 23, 27, 30, 32, 40, 40, 41, 42, 43, 50)

        mergeSort(list) shouldBeEqualTo sorted
    }
}
