package com.igorwojda.string.longestword

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun longestWord(str: String): String {
   return solution.s1(str)
}

object solution{
    fun s1(str:String):String{
        return str.map { if(it.isLetter()) it else ' ' }
            .joinToString("")
            .split(" ")
            .filterNot { it.isBlank() }
            .maxByOrNull { it.length } ?: ""
    }
}

private class Test {
    @Test
    fun `"flower" return "flower"`() {
        longestWord("flower") shouldBeEqualTo "flower"
    }

    @Test
    fun `"flower is growing fast" return "growing"`() {
        longestWord("flower is growing fast") shouldBeEqualTo "growing"
    }

    @Test
    fun `"This is my jeep" return "jeep"`() {
        longestWord("This is my jeep") shouldBeEqualTo "This"
    }

    @Test
    fun `"Home!@#&sweet home" return "sweet"`() {
        longestWord("Home!@&#sweet home") shouldBeEqualTo "sweet"
    }
}
