package com.igorwojda.string.capitalizesentence

import com.igorwojda.string.capitalizesentence.solution.s2
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun capitalizeSentence(str: String): String {
    return solution.s2(str)
}

object solution {
    fun s1(str: String): String {
        return str.split(" ").joinToString { it.capitalize() }
    }

    fun s2(str: String): String {
        val words = mutableListOf<String>()
        str.split(" ").forEach {
            words.add(it[0].toUpperCase() + it.substring(1))
        }
        return words.joinToString(" ")
    }
}

private class Test {
    @Test
    fun `"flower" is capitalized to "Flower"`() {
        capitalizeSentence("flower") shouldBeEqualTo "Flower"
    }

    @Test
    fun `"this is a house" is capitalised to "This Is A House"`() {
        capitalizeSentence("this is a house") shouldBeEqualTo "This Is A House"
    }
}
