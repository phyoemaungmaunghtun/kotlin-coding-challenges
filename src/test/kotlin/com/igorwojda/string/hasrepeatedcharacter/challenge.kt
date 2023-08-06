package com.igorwojda.string.hasrepeatedcharacter

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun hasRepeatedChar(str: String): Boolean {
    return solution.s2(str)
}

object solution{
    fun s1(str: String):Boolean{
        val count = str.groupingBy { it }.eachCount()
        return count.any{it.value > 1}
    }

    fun s2(str: String):Boolean{
        val frequency = str.groupingBy { it }.eachCount()
        frequency.forEach{
            if(it.value > 1){
                return true
            }
        }
        return false
    }
}

private class Test {
    @Test
    fun `"abc" don't have repeated character`() {
        hasRepeatedChar("abc") shouldBeEqualTo false
    }

    @Test
    fun `"aabc" has repeated character`() {
        hasRepeatedChar("aabc") shouldBeEqualTo true
    }

    @Test
    fun `"aabcc" has repeated character`() {
        hasRepeatedChar("aabcc") shouldBeEqualTo true
    }
}
