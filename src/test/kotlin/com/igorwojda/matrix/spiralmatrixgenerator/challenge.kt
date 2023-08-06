package com.igorwojda.matrix.spiralmatrixgenerator

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun generateSpiralMatrix(n: Int): List<MutableList<Int?>> {
    val list = MutableList(n){
        MutableList<Int?>(n){null}
    }
    var direction = DIRECTION.RIGHT
    var maxNumber = n * n
    var lastIndex = n - 1
    var rowIndex = 0
    var columnIndex = 0

    (1..maxNumber).forEach{
        list[rowIndex][columnIndex] = it
        when(direction){
            DIRECTION.RIGHT -> {
                val rightValue = if(columnIndex == lastIndex) null else list[rowIndex] [columnIndex + 1]
                if(rightValue == null && columnIndex < lastIndex){
                    columnIndex++
                }else{
                    direction = DIRECTION.DOWN
                    rowIndex++
                }
            }
            DIRECTION.DOWN -> {
                val downValue = if(rowIndex == lastIndex) null else list[rowIndex + 1][columnIndex]
                if(downValue == null && rowIndex < lastIndex){
                    rowIndex++
                }else{
                    direction = DIRECTION.LEFT
                    columnIndex--
                }
            }
            DIRECTION.LEFT ->{
                val leftValue = if(columnIndex == 0) null else list[rowIndex][columnIndex - 1]
                if(leftValue == null && columnIndex > 0){
                    columnIndex--
                }else{
                    direction = DIRECTION.UP
                    rowIndex--
                }
            }
            DIRECTION.UP -> {
                val upValue = if(rowIndex == 0) null else list[rowIndex-1][columnIndex]
                if(upValue == null && rowIndex > 0){
                    rowIndex--
                }else{
                    direction = DIRECTION.RIGHT
                    columnIndex++
                }
            }
        }

    }
    return list
}

enum class DIRECTION{RIGHT,DOWN,LEFT,UP}

private class Test {
    @Test
    fun `generateSpiralMatrix generates a 2x2 matrix`() {
        val matrix = generateSpiralMatrix(2)
        matrix.size shouldBeEqualTo 2
        matrix[0] shouldBeEqualTo listOf(1, 2)
        matrix[1] shouldBeEqualTo listOf(4, 3)
    }

    @Test
    fun `generateSpiralMatrix generates a 3x3 matrix`() {
        val matrix = generateSpiralMatrix(3)
        matrix.size shouldBeEqualTo 3
        matrix[0] shouldBeEqualTo listOf(1, 2, 3)
        matrix[1] shouldBeEqualTo listOf(8, 9, 4)
        matrix[2] shouldBeEqualTo listOf(7, 6, 5)
    }

    @Test
    fun `generateSpiralMatrix generates a 4x4 matrix`() {
        val matrix = generateSpiralMatrix(4)
        matrix.size shouldBeEqualTo 4
        matrix[0] shouldBeEqualTo listOf(1, 2, 3, 4)
        matrix[1] shouldBeEqualTo listOf(12, 13, 14, 5)
        matrix[2] shouldBeEqualTo listOf(11, 16, 15, 6)
        matrix[3] shouldBeEqualTo listOf(10, 9, 8, 7)
    }
}
