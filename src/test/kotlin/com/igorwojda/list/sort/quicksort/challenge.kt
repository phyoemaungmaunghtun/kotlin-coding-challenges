package com.igorwojda.list.sort.quicksort

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun quickSort(list: MutableList<Int>, left: Int = 0, right: Int = list.lastIndex): List<Number> {
    return solution.s1(list)
}

object solution{
    fun s1(list: MutableList<Int>, left: Int = 0, right: Int = list.lastIndex):List<Number>{
        fun findNextPivot(list: MutableList<Int>, start: Int = 0, end: Int = list.lastIndex):Int{
            val pivotValue = list[start]
            var swapIndex = start
            (start+1..list.lastIndex).forEach {
                if(pivotValue > list[it]){
                    swapIndex++
                    list.swap(swapIndex,it)
                }
            }
            list.swap(start,swapIndex)
            return swapIndex
        }
        if(left < right){
            val pivot = findNextPivot(list,left,right)

            s1(list,left,pivot-1)
            s1(list,pivot + 1,right)
        }
        return list
    }

    fun s2(list: MutableList<Int>):List<Number>{
        if(list.isEmpty()){
            return list
        }
        val pivot = list.first()
        var index = 0

        (0..list.lastIndex).forEach {
            if(pivot > list[it]){
                list.swap(index+1,it)
                index++
            }
        }

        list.swap(0,index)

        val left = list.subList(0,index)
        val right = list.subList(index+1,list.size)

        return s2(left) + listOf(pivot) + s2(right)

    }
}

private fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    val tmp = this[index1]
    println("swapIndex -> ${this[index2]} : it -> ${this[index1]}")
    this[index1] = this[index2]
    this[index2] = tmp
}

private class Test {
    @Test
    fun `quick sort empty list`() {
        quickSort(mutableListOf()) shouldBeEqualTo listOf()
    }

    @Test
    fun `quick sort 7`() {
        quickSort(mutableListOf(7)) shouldBeEqualTo listOf(7)
    }

    @Test
    fun `quick sort empty list 9, 3`() {
        quickSort(mutableListOf(9, 3)) shouldBeEqualTo listOf(3, 9)
    }

    @Test
    fun `quick sort 5, 1, 4, 2`() {
        quickSort(mutableListOf(5, 1, 4, 2)) shouldBeEqualTo listOf(1, 2, 4, 5)
    }

    @Test
    fun `quick sort 5, 2, 1, 8, 4, 7, 6, 9`() {
        quickSort(mutableListOf(5, 2, 1, 8, 4, 7, 6, 9)) shouldBeEqualTo listOf(
            1,
            2,
            4,
            5,
            6,
            7,
            8,
            9
        )
    }

    @Test
    fun `quick sort 17, 4, 12, 19, 80, 75, 16`() {
        quickSort(mutableListOf(17, 4, 12, 19, 80, 75, 16)) shouldBeEqualTo listOf(
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
    fun `quick sort 11, 40, 40, 50, 43, 10, 30, 42, 20, 6, 19, 32, 20, 41, 23, 27`() {
        val list = mutableListOf(11, 40, 40, 50, 43, 10, 30, 42, 20, 6, 19, 32, 20, 41, 23, 27)
        val sorted = mutableListOf(6, 10, 11, 19, 20, 20, 23, 27, 30, 32, 40, 40, 41, 42, 43, 50)

        quickSort(list) shouldBeEqualTo sorted
    }
}
