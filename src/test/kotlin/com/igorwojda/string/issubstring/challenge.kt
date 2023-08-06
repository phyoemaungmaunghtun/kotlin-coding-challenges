package com.igorwojda.string.issubstring

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun isSubstring(str: String, subStr: String): Boolean {
    return solution.s4(str, subStr)
}

object solution {
    fun s1(str: String, subStr: String): Boolean {
        return str.contains(subStr) || str.isNotEmpty() && subStr.isNotEmpty()
    }

    fun s2(str: String, subStr: String): Boolean {
        if (str.isEmpty() || subStr.isEmpty()) return false
        if (str.length <= subStr.length) return false
        var pointer1 = 0
        var pointer2 = 0

        while (pointer1 <= str.lastIndex) {
            if (str[pointer1] == subStr[pointer2]) {
                pointer2++
            } else {
                if (pointer2 > 0) {
                    pointer2 = 0
                    pointer1 = --pointer1
                }
            }

            if (pointer2 == subStr.length) {
                return true
            }

            pointer1++
        }
        return false
    }

    fun s3(str: String, subStr: String): Boolean {
        if(str.length < subStr.length){
            return false
        }
        if(str.isEmpty() || subStr.isEmpty()){
            return false
        }
        return if(str.first() == subStr.first()){
            val localStr = str.drop(1)
            val localSubStr = subStr.drop(1)
            if(localSubStr.isEmpty()){
                return true
            }else{
                s3(localStr,localSubStr)
            }
        }else{
            s3(str.drop(1),subStr)
        }
    }

    fun s4(str: String,subStr: String):Boolean {
        /*if(str.isEmpty() || subStr.isEmpty()){
            return false
        }

        fun helper(first:String, second:String, firstPointer: Int = 0, secondPointer:Int = 0):Boolean{
            if(firstPointer > first.lastIndex){
                return false
            }

            return if(first[firstPointer] == second[secondPointer]){
                   val localFirstPointer = firstPointer + 1
                   val localSecondPointer = secondPointer + 1
                if(localFirstPointer > first.lastIndex || localSecondPointer > second.lastIndex){
                    true
                }else{
                    helper(first,second,localFirstPointer,localSecondPointer)
                }

            }else{
                val P1 = firstPointer + 1
                if(secondPointer > 0){
                    helper(first,second,firstPointer,0)
                }else{
                    if(P1 > first.lastIndex){
                        return false
                    }
                    helper(first,second,P1,secondPointer)
                }


            }
        }

        return helper(str,subStr)*/
        if(str.isEmpty() || subStr.isEmpty()){
            return false
        }

        fun helper(first:String, second:String,firstPointer:Int = 0 , secondPointer: Int = 0):Boolean
        {
            if(firstPointer < first.lastIndex){
                return false
            }

            return if(first[firstPointer] == second[secondPointer]){
                val localFirst = firstPointer + 1
                val localSecond = secondPointer + 1
                if(localSecond > second.lastIndex || localFirst > first.lastIndex){
                    return true
                }else{
                    helper(first,second,localFirst,localSecond)
                }
            }else{
                val p1 = firstPointer + 1
                if(secondPointer > 0){
                    helper(first,second,firstPointer,0)
                }else{
                    if(p1 > first.lastIndex){
                        return false
                    }
                    helper(first,second,p1,secondPointer)
                }

            }

        }
        return helper(str,subStr)
    }
}

private class Test {
    @Test
    fun `abd not in abcd`() {
        isSubstring("abcd", "abd") shouldBeEqualTo false
    }

    @Test
    fun `e not in abcd`() {
        isSubstring("abcd", "e") shouldBeEqualTo false
    }

    @Test
    fun `ab in abd`() {
        isSubstring("abc", "ab") shouldBeEqualTo true
    }

    @Test
    fun `bc in abc`() {
        isSubstring("abc", "bc") shouldBeEqualTo true
    }

    @Test
    fun `abc in ababc`() {
        isSubstring("ababc", "abc") shouldBeEqualTo true
    }

    @Test
    fun `cd in abcdef`() {
        isSubstring("abcdef", "cd") shouldBeEqualTo true
    }

    @Test
    fun `empty sub-string not in abc`() {
        isSubstring("abc", "") shouldBeEqualTo false
    }

    @Test
    fun `abc not in empty string`() {
        isSubstring("", "abc") shouldBeEqualTo false
    }

    @Test
    fun `empty sub-string not in empt ystring`() {
        isSubstring("", "") shouldBeEqualTo false
    }

    @Test
    fun `abc in adabc`() {
        isSubstring("acabe", "abe") shouldBeEqualTo true
    }
}
