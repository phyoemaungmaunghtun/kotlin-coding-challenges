package com.igorwojda.string.decapitalizeconst

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun decapitalizeConst(str: String): String? {
    return solution.s2(str)
}

object solution{
    fun s1(str: String):String{
        val subsStringsList = str.split("_").map { it.toLowerCase().capitalize() }
        return subsStringsList.joinToString("").decapitalize()
    }
    fun s2(str: String):String?{
        val words = str.split("_").filter { it.isNotEmpty() }

        if (words.size <= 1) return null

        return words.mapIndexed { index, word ->
            if (index == 0) {
                word.toLowerCase()
            } else {
                word.first().toUpperCase() + word.drop(1).toLowerCase()
            }
        }.joinToString(separator = "")
    }
}

private class Test {
    @Test
    fun `"FOOBAR" return foobar`() {
        decapitalizeConst("FOOBAR") shouldBeEqualTo "foobar"
    }

    @Test
    fun `"FOO_BAR" return "fooBar"`() {
        decapitalizeConst("FOO_BAR") shouldBeEqualTo "fooBar"
    }

    @Test
    fun `"FOO_BAR_BAZ" return "fooBarBaz"`() {
        decapitalizeConst("FOO_BAR_BAZ") shouldBeEqualTo "fooBarBaz"
    }

    @Test
    fun `"__F_BAR" return "fBar"`() {
        decapitalizeConst("__F_BAR") shouldBeEqualTo "fBar"
    }

    @Test
    fun `"F_BAR" return "fBar"`() {
        decapitalizeConst("F_BAR") shouldBeEqualTo "fBar"
    }

    @Test
    fun `empty string return empty string`() {
        decapitalizeConst("") shouldBeEqualTo ""
    }
}
