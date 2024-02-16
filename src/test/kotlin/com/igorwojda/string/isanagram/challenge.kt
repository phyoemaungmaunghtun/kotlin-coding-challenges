package com.igorwojda.string.isanagram

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun isAnagram(str1: String, str2: String): Boolean {
    return solution.s1(str1, str2)
}

object solution {
    fun s1(str1: String, str2: String): Boolean {
        val firstString = str1.toUpperCase().filter { it.isLetterOrDigit() }.groupBy { it }
        val secondString = str2.toUpperCase().filter { it.isLetterOrDigit() }.groupBy { it }
        return firstString == secondString
    }

    fun s2(str1: String, str2: String): Boolean {
        return getFrequency(str1) == getFrequency(str2)
    }

    private fun getFrequency(str:String):Map<Char,List<Char>>{
        return str.toLowerCase().filter { it.isLetterOrDigit() }.groupBy { it }
    }


    fun s3(str1: String,str2: String):Boolean{
        return getFrequencyChar(str1) == getFrequencyChar(str2)
    }

    private fun getFrequencyChar(str:String):Map<Char,Int>{
        return str.toLowerCase().filter { it.isLetterOrDigit() }.groupingBy { it }.eachCount()
    }


}

private class Test {
    @Test
    fun `"rail safety" is an anagram of "fairy tales"`() {
        isAnagram("rail safety", "fairy tales") shouldBeEqualTo true
    }

    @Test
    fun `"RAIL SAFETY" is an anagram of "fairy tales" - ignore letter casing`() {
        isAnagram("RAIL SAFETY", "fairy tales") shouldBeEqualTo true
    }

    @Test
    fun `"rail safety!!" is an anagram of "fairy tales" - ignore special characters`() {
        isAnagram("rail safety!!", "fairy tales") shouldBeEqualTo true
    }

    @Test
    fun `"hi" is not an anagram of "ihi"`() {
        isAnagram("hi", "ihi") shouldBeEqualTo false
    }

    @Test
    fun `"hello" is an anagram of "llohe"`() {
        isAnagram("hello", "llohe") shouldBeEqualTo true
    }

    @Test
    fun `"Whoa! Hi!" is an anagram of "Hi! Whoa!"`() {
        isAnagram("Whoa! Hi!", "Hi! Whoa!") shouldBeEqualTo true
    }

    @Test
    fun `"One One" is not an anagram of "Two two two"`() {
        isAnagram("One One", "Two two two") shouldBeEqualTo false
    }

    @Test
    fun `"One one" is not an anagram of "One one c"`() {
        isAnagram("One one", "One one c") shouldBeEqualTo false
    }

    @Test
    fun `"One one" is not an anagram of "One one  " - ignore spaces`() {
        isAnagram("One one", "One one  ") shouldBeEqualTo true
    }

    @Test
    fun `"A tree, a life, a bench" is not an anagram of "A tree, a fence, a yard"`() {
        isAnagram("A tree, a life, a bench", "A tree, a fence, a yard") shouldBeEqualTo false
    }
}
