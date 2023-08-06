package com.igorwojda.string.maxchar

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun maxOccurrentChar(str: String): Char? {
    return solution.s3(str)
}

object solution{
    fun s1(str: String):Char?{
        return str.toCharArray().groupBy { it }.maxByOrNull { it.value.size }?.key
    }

    fun s2(str: String):Char?{
        return str.toList().groupingBy { it }.eachCount().maxBy { it.value }?.key
    }

    fun s3(str: String):Char?{
        val map = mutableMapOf<Char,Int>()
        str.forEach {
            map[it] = (map[it] ?: 0) + 1
        }
        return map.maxBy { it.value }?.key
    }

    fun s4(str: String):Char?{
        str.forEachIndexed { index, c ->
            str.substring(index + 1).forEach {
                if (c == it) {
                    return it
                }
            }
        }

        return null
    }
}

private class Test {
    @Test
    fun `Don't find a char in empty string`() {
        maxOccurrentChar("") shouldBeEqualTo null
    }

    @Test
    fun `Finds char 'a' in string "a"`() {
        maxOccurrentChar("a") shouldBeEqualTo 'a'
    }

    @Test
    fun `Finds char 'a' in string "abcdefghijklmnaaaaa"`() {
        maxOccurrentChar("abcdefghijklmnaaaaa") shouldBeEqualTo 'a'
    }

    @Test
    fun `Finds char '1' in string "ab1c1d1e1f1g1"`() {
        maxOccurrentChar("ab1c1d1e1f1g1") shouldBeEqualTo '1'
    }
}
