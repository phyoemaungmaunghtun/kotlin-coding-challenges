package com.igorwojda.string.ispalindrome.basic

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun isPalindrome(str: String): Boolean {
    return solution.s4(str)
}

object solution {
    fun s1(str: String): Boolean {
       return str == str.reversed()
    }

    fun s2(str: String): Boolean {
       var leftIndex = 0
        var rightIndex = str.lastIndex

        while(leftIndex <= rightIndex){
            val leftValue = str[leftIndex]
            val rightValue = str[rightIndex]
            if(leftValue != rightValue){
                return false
            }
            leftIndex++
            rightIndex--
        }
        return true
    }

    fun s3(str: String): Boolean {
        str.forEachIndexed { index, char ->
             val rightIndex = str.lastIndex - index
            if(char != str[rightIndex])
                return false
            if(index > rightIndex)
                return true
        }
        return true
    }

    fun s4(str: String): Boolean {
        return if(str.isEmpty() || str.length == 1){
            true
        }else{
            if(str.first() == str.last()){
                 s4(str.substring(1 until str.lastIndex))
            }else{
                 false
            }
        }
    }
}

private class Test {

    @Test
    fun `"aba" is a palindrome`() {
        isPalindrome("aba") shouldBeEqualTo true
    }

    @Test
    fun `" aba" is not a palindrome`() {
        isPalindrome(" aba") shouldBeEqualTo false
    }

    @Test
    fun `"aba " is not a palindrome`() {
        isPalindrome("aba ") shouldBeEqualTo false
    }

    @Test
    fun `"greetings" is not a palindrome`() {
        isPalindrome("greetings") shouldBeEqualTo false
    }

    @Test
    fun `"1000000001" a palindrome`() {
        isPalindrome("1000000001") shouldBeEqualTo true
    }

    @Test
    fun `"Fish hsif" is not a palindrome`() {
        isPalindrome("Fish hsif") shouldBeEqualTo false
    }

    @Test
    fun `"pennep" a palindrome`() {
        isPalindrome("pennep") shouldBeEqualTo true
    }
}
