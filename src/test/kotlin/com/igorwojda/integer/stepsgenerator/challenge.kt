package com.igorwojda.integer.stepsgenerator

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

fun generateSteps(n: Int): List<String> {
    return solution.s2(n)
}

object solution{
    fun s1(n:Int) = List(n){"#".repeat(it + 1)+" ".repeat(n - it - 1)}

    fun s2(n:Int):List<String>{
        val list = mutableListOf<String>()
        (1.. n).forEach{row ->
            var items = ""
            (1.. n).forEach{column->
                val char = if(column <= row) '#' else ' '
                items += char
            }
            list.add(items)
        }
        return list
    }

    fun s3(n:Int,row:Int = 0, stair:String = ""){
        if(n == row){
            return
        }
        if(stair.length == n){
            s3(n,row + 1)
            return
        }

        val char = if(stair.length <= row) '#' else ' '
        val currentStair = stair + char
        s3(n,row,currentStair)
    }
}

private class Test {
    @Test
    fun `steps n = 1`() {
        val actual = generateSteps(1)
        actual.size shouldBeEqualTo 1
        actual[0] shouldBeEqualTo "#"
    }

    @Test
    fun `steps n = 2`() {
        val actual = generateSteps(2)
        actual.size shouldBeEqualTo 2
        actual[0] shouldBeEqualTo "# "
        actual[1] shouldBeEqualTo "##"
    }

    @Test
    fun `steps n = 3`() {
        val actual = generateSteps(3)
        actual.size shouldBeEqualTo 3
        actual[0] shouldBeEqualTo "#  "
        actual[1] shouldBeEqualTo "## "
        actual[2] shouldBeEqualTo "###"
    }
}
