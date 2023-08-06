package com.igorwojda.string.ispalindrome.tolerant

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun isTolerantPalindrome(str: String, characterRemoved: Boolean = false): Boolean {
    return solution.s3(str)
}

object solution {
    fun s1(str: String): Boolean {
        var characterRemoved = false

        str.forEachIndexed { index, c ->
            var lastIndex = str.lastIndex - index

            if (characterRemoved) {
                lastIndex--
            }

            if (index >= lastIndex) {
                return true
            }

            if (c != str[lastIndex]) {
                if (characterRemoved) {
                    return false
                } else {
                    characterRemoved = true
                }
            }
        }

        return false
        /*var removeCharacter = false
        str.forEachIndexed { index, char ->
            var lastIndex = str.lastIndex - index

            if(removeCharacter){
                lastIndex--
            }

            if(index >= lastIndex){
                return true
            }

            if(char != str[lastIndex]){
                if(removeCharacter){
                    return false
                }else{
                    removeCharacter = true
                }
            }
        }
        return false*/

    }

    fun s2(str: String, characterRemoved: Boolean = false): Boolean {
        return if (str.isEmpty() || str.length == 1) {
            return true
        } else {
            if (str.first() == str.last()) {
                s2(str.substring(1 until str.lastIndex), characterRemoved)
            } else {
                if (characterRemoved) {
                    return false
                } else {
                    if (str.length == 2) return true
                    val leftRemove = s2(str.substring(2 until str.lastIndex), true)
                    val rightRemove = s2(str.substring(1 until str.lastIndex - 1), true)
                    return leftRemove || rightRemove
                }
            }
        }
    }

    fun s3(str: String, characterRemoved: Boolean = false): Boolean {
       val revStr = str.reversed()
        if(revStr == str) return true
        if(characterRemoved) return false
        val removeIndex = str.commonPrefixWith(revStr).length
        if(removeIndex + 1 > str.lastIndex) return false
        return s3(str.removeRange(removeIndex,removeIndex+1),true)
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
