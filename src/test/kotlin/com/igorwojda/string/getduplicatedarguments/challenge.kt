package com.igorwojda.string.getduplicatedarguments

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun getDuplicatedArguments(vararg strings: String): List<String>? {
    return solution.s3(*strings)
}

object solution{
    fun s1(vararg strings:String):List<String> = strings
            .groupingBy { it }
            .eachCount()
            .filter { it.value != 1 }
            .map { it.key }

    fun s2(vararg strings:String):List<String>{
        var pointer1 = 0
        var pointer2 = 1
        val result = mutableSetOf<String>()
        val sorted = strings.sorted()

        for(it in 0 until sorted.lastIndex){
            if(sorted[pointer1] == sorted[pointer2]){
                result.add(sorted[pointer1])
            }
            pointer1++
            pointer2++
        }

        return result.toList()
    }

    fun s3(vararg strings:String):List<String>{
        val result = mutableSetOf<String>()
        strings.forEachIndexed { index1, element1 ->
            ((index1 + 1)..strings.lastIndex).forEach { index2 ->
                if(element1 == strings[index2]){
                    result.add(element1)
                }
            }
        }
        return result.toList()
    }
}

private class Test {
    @Test
    fun `a, b, c returns empty list`() {
        getDuplicatedArguments("a", "b", "c") shouldBeEqualTo listOf()
    }

    @Test
    fun `a, b, c, a returns a`() {
        getDuplicatedArguments("a", "b", "c", "a") shouldBeEqualTo listOf("a")
    }

    @Test
    fun `a, e, a, e, d, a returns a, e`() {
        getDuplicatedArguments("a", "e", "a", "e", "d", "a") shouldBeEqualTo listOf("a", "e")
    }

    @Test
    fun `no arguments returns empty list`() {
        getDuplicatedArguments() shouldBeEqualTo listOf()
    }
}
