package com.igorwojda.string.vowels

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun vowels(str: String): Int {
    return solution.s1(str)
}

object solution{
    fun s1(str: String):Int{
       val vowel = listOf('a','e','i','o','u','y')
        return str.count { it.toLowerCase() in vowel }
    }

    fun s2(str: String):Int{
        val vowel = listOf('a','e','i','o','u','y')
        var count = 0
        str.forEach {
            if(vowel.contains(it.toLowerCase())){
                count++
            }
        }
        return count
    }

    fun s3(str: String):Int{
       return Regex("[aeiouy]").findAll(str.toLowerCase()).count()
    }
}

private class Test {
    @Test
    fun `"aeiouy" has 6 vovels`() {
        vowels("aeiouy") shouldBeEqualTo 6
    }

    @Test
    fun `"AEIOUY" has 6 vovels`() {
        vowels("AEIOUY") shouldBeEqualTo 6
    }

    @Test
    fun `"abcdefghijklmnopqrstuvwxyz" has 6 vovels`() {
        vowels("abcdefghijklmnopqrstuvwxyz") shouldBeEqualTo 6
    }

    @Test
    fun `"bcadfaghijkl" has 3 vovels`() {
        vowels("bcadfaghijkl") shouldBeEqualTo 3
    }

    @Test
    fun `"bcdfghjkl" has 0 vovels`() {
        vowels("bcdfghjkl") shouldBeEqualTo 0
    }
}
