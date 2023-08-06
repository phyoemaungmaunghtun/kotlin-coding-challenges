package com.igorwojda.integer.pyramidgenerator

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun generatePyramid(n: Int): List<String> {
    return solution.s1(n)
}

object solution {
    fun s1(n: Int): List<String> {
        val list = mutableListOf<String>()
        val numberOfColumn = (n * 2) - 1

        (0 until n).forEach { row ->
            val numberOfHash = (row * 2) + 1
            val numberOfSpace = numberOfColumn - numberOfHash
            var space = ""
            repeat(numberOfSpace / 2) {
                space += " "
            }
            var hash = ""
            repeat(numberOfHash) {
                hash += "#"
            }
            list.add("$space$hash$space")
        }
        return list
    }

    fun s2(n: Int): List<String> {
        val list = mutableListOf<String>()
        val midPoint = ((n * 2) - 1) / 2
        val numberOfColumn = (n * 2) - 1
        (0 until n).forEach { row ->
            var hashString = ""
            (0 until numberOfColumn).forEach { column ->
                hashString += if (midPoint - row <= column && midPoint + row >= column) {
                    "#"
                } else {
                    " "
                }
            }
            list.add(hashString)
        }
        return list
    }
}

private class Test {

    @Test
    fun `pyramid n = 2`() {
        generatePyramid(2).also {
            it.size shouldBeEqualTo 2
            it[0] shouldBeEqualTo " # "
            it[1] shouldBeEqualTo "###"
        }
    }

    @Test
    fun `pyramid n = 3`() {
        generatePyramid(3).also {
            it.size shouldBeEqualTo 3
            it[0] shouldBeEqualTo "  #  "
            it[1] shouldBeEqualTo " ### "
            it[2] shouldBeEqualTo "#####"
        }
    }

    @Test
    fun `pyramid n = 4`() {
        generatePyramid(4).also {
            it.size shouldBeEqualTo 4
            it[0] shouldBeEqualTo "   #   "
            it[1] shouldBeEqualTo "  ###  "
            it[2] shouldBeEqualTo " ##### "
            it[3] shouldBeEqualTo "#######"
        }
    }
}
