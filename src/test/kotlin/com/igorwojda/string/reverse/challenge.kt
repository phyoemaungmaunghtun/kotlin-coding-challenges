package com.igorwojda.string.reverse

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun reverse(str: String): String {
    return solution.s1(str)

}

object solution {
    fun s1(str: String): String {
       return str.reversed()
    }

    fun s2(str: String): String {
       var reversed = ""
        str.forEach {
            reversed = it + reversed
        }
        return reversed
    }

    fun s3(str: String):String{
       if(str.length == 1){
           return str
       }
        return s3(str.drop(1) ) + str.first()
    }

    fun s4(str: String):String{
        val list = str.toMutableList()
        var leftIndex = 0
        var rightIndex = list.lastIndex
        while (leftIndex <= rightIndex){
            val temp = list[leftIndex]
            list[leftIndex] = list[rightIndex]
            list[rightIndex] = temp
            leftIndex++
            rightIndex--
        }
        return  list.joinToString (transform = {it.toString()}, separator = "" )
    }

    fun s5(str: String):String{
       return str.foldRight(""){c: Char, reverse: String ->  reverse + c}
    }
}

private class Test {
    @Test
    fun `Reverse of "abcd" is "dcba"`() {
        reverse("abcd") shouldBeEqualTo "dcba"
    }

    @Test
    fun `Reverse of "aabbccdd" is "ddccbbaa"`() {
        reverse("aabbccdd") shouldBeEqualTo "ddccbbaa"
    }
}
