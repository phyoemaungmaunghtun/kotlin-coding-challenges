package com.igorwojda.string.ispalindrome.tolerant

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun isTolerantPalindrome(str: String, characterRemoved: Boolean = false): Boolean {
    return solution.s1(str)
}

object solution {

    fun s1(s: String): Boolean {
        var i = 0
        var j = s.lastIndex
        while (i < j){
            if(s[i] != s[j]){
                return isPalindrome(s,i+1,j) || isPalindrome(s, i, j-1)
            }
            i++
            j--
        }
        return true
    }

    fun isPalindrome(s: String, i: Int, j: Int): Boolean {
        var start = i
        var end = j
        while (start < end){
            if(s[start] != s[end]){
                return false
            }
            start++
            end--
        }
        return true
    }

    fun s2(str: String, characterRemoved: Boolean = false): Boolean {
        return if(str.isEmpty() || str.length == 1){
            return true
        }else{
            if(str.first() == str.last()){
                s2(str.substring(1 until str.lastIndex),characterRemoved)
            }else{
                if(characterRemoved){
                    false
                }else{
                    val reduceStart = s2(str.substring(1 until str.lastIndex + 1),true)

                    val reduceEnd = s2(str.substring(0 until str.lastIndex),true)

                    return reduceStart || reduceEnd
                }
            }
        }
    }

    fun s3(str: String, characterRemoved: Boolean = false): Boolean {
        val reverseStr = str.reversed()
        if(str == reverseStr) return true
        if(characterRemoved) return false

        val removeIndex = str.commonPrefixWith(reverseStr).length
        if(removeIndex + 1 > str.length) return false
        val removeStart = str.removeRange(removeIndex,removeIndex+1)
        if(s3(removeStart,true)) return true

        val removeLast = str.removeRange(str.lastIndex - removeIndex, str.length - (removeIndex + 1))
        return s3(removeLast,true)
    }
}

private class Test {
    @Test
    fun `"aba" is a palindrome`() {
        isTolerantPalindrome("aba") shouldBeEqualTo true
    }

    @Test
    fun `"ab!a" is a palindrome`() {
        isTolerantPalindrome("ab!a") shouldBeEqualTo true
    }

    @Test
    fun `"a!ba" is a palindrome`() {
        isTolerantPalindrome("a!ba") shouldBeEqualTo true
    }

    @Test
    fun `" aba" is a palindrome`() {
        isTolerantPalindrome(" aba") shouldBeEqualTo true
    }

    @Test
    fun `"aa#!aa " is not a palindrome`() {
        isTolerantPalindrome("aa#!aa ") shouldBeEqualTo false
    }

    @Test
    fun `"greetings" is not a palindrome`() {
        isTolerantPalindrome("greetings") shouldBeEqualTo false
    }

    @Test
    fun `"1000000001" a palindrome`() {
        isTolerantPalindrome("1000000001") shouldBeEqualTo true
    }

    @Test
    fun `"10A00000001" is a palindrome`() {
        isTolerantPalindrome("10A00000001") shouldBeEqualTo true
    }

    @Test
    fun `"Fish hsif" is not a palindrome`() {
        isTolerantPalindrome("Fish hsif") shouldBeEqualTo false
    }

    @Test
    fun `"pennep" a palindrome`() {
        isTolerantPalindrome("pennep") shouldBeEqualTo true
    }

    @Test
    fun `"abb#cdeedcbba" a palindrome`() {
        isTolerantPalindrome("abb#cdeedcbba") shouldBeEqualTo true
    }
}
