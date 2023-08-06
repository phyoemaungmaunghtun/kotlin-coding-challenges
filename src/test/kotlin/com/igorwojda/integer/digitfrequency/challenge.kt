package com.igorwojda.integer.digitfrequency

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun equalDigitFrequency(i1: Int, i2: Int): Boolean {
    return solution.s2(i1,i2)
}

object solution{
    fun s1(i1: Int,i2: Int):Boolean{
        val list1 = i1.toString()
        val list2 = i2.toString()
        if(list1.length != list2.length){
            return false
        }
        val frequency1 = list1.groupingBy {  it }.eachCount()
        val frequency2 = list2.groupingBy { it }.eachCount()

        return frequency1 == frequency2
    }

    fun s2(i1: Int,i2: Int):Boolean{
        val iStr1 = i1.toString().toList()
        val iStr2 = i2.toString().toMutableList()

        if(iStr1.size != iStr2.size){
            return false
        }

        iStr1.forEach{
            val index  = iStr2.indexOf(it)
            if(index == -1){
                return false
            }
            iStr2.removeAt(index)
        }
        return true
    }
}

private class Test {
    @Test
    fun `"789" and "897" have the same digit frequency`() {
        equalDigitFrequency(789, 897) shouldBeEqualTo true
    }

    @Test
    fun `"123445" and "451243" have the same digit frequency`() {
        equalDigitFrequency(123445, 451243) shouldBeEqualTo true
    }

    @Test
    fun `"447" and "477" have different digit frequency"`() {
        equalDigitFrequency(447, 477) shouldBeEqualTo false
    }

    @Test
    fun `"578" and "0" have different digit frequency"`() {
        equalDigitFrequency(578, 0) shouldBeEqualTo false
    }

    @Test
    fun `"0" and "0" have the same digit frequency"`() {
        equalDigitFrequency(0, 0) shouldBeEqualTo true
    }
}
