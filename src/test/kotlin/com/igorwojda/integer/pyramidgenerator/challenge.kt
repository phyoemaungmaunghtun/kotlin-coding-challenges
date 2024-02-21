package com.igorwojda.integer.pyramidgenerator

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun generatePyramid(n: Int): List<String> {
    return solution.s2(n)
}

fun main() {
    solution.s2(4)
}

object solution {
    fun s1(n: Int): List<String> {

        val result = mutableListOf<String>()
        val numOfColumn = (n * 2) - 1
        (0 until n).forEach { row ->
            val numOfHash = (2 * row) + 1
            val numOfSpace = numOfColumn - numOfHash
            var space = ""
            repeat(numOfSpace / 2) {
                space += " "
            }
            var hash = ""
            repeat(numOfHash) {
                hash += "#"
            }
            result.add("$space$hash$space")
        }

        return result
    }

    fun s2(n: Int): List<String> {
        val list = mutableListOf<String>()
        val mid = ((n * 2) - 1) / 2
        val numColumn = (n * 2) - 1
        (0 until n).forEach { row->
            var str = ""
            (0 until numColumn).forEach { col ->
                str += if(mid - row <= col && mid + row >= col){
                    "#"
                }else{
                    " "
                }
            }
            list.add(str)
        }
        return list.toList()
    }


    fun s3(n: Int, row: Int = 0) {
        if (n == row) {
            return
        }
        val midPoint = n - 1
        val numOfColumn = (2 * n) - 1
        var hashLine = ""
        (0 until numOfColumn).forEach { column ->
            hashLine += if (midPoint - row <= column && midPoint + row >= column) {
                "#"
            } else {
                " "
            }
        }

        println(hashLine)

        return s3(n, row + 1)

    }

    fun generatePyramid(n: Int, row: Int = 0) {
        val numColumns = 2 * n - 1 // Number of columns for the pyramid
        val midpoint = n - 1 // Midpoint of the row

        // handle complete all of the work
        if (n == row) {
            return
        }

        // handle the case where we are assembling string
        var rowStr = ""

        (0 until numColumns).forEach { column ->
            rowStr += if (midpoint - row <= column && midpoint + row >= column) {
                "#"
            } else {
                " "
            }
        }

        println(rowStr)

        // handle row
        generatePyramid(n, row + 1)
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
