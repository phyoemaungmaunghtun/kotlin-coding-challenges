package com.igorwojda.string.reverse

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun reverse(str: String): String {
    return solution.s5(str)

}

object solution {
    fun s1(str: String): String {
       return str.reversed()
    }

    fun s2(str: String): String {
        var reverse = ""
        str.forEach {
            reverse = it + reverse
        }
        return reverse
    }

    fun s3(str: String):String{
        if(str.isEmpty()){
            return str
        }

        return s3(str.drop(1)) + str.first()
    }

    fun s4(str: String):String{
        return str.foldRight(""){char,reverse -> reverse + char}
    }

    fun s5(str: String):String{
        val chars = str.toMutableList()
       var leftIndex = 0
        var rightIndex = str.lastIndex

        while (leftIndex <= rightIndex){
            val temp = str[leftIndex]
            chars[leftIndex] = str[rightIndex]
            chars[rightIndex] = temp
            rightIndex--
            leftIndex++
        }
        return chars.joinToString(transform = {it.toString()}, separator = "")
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
