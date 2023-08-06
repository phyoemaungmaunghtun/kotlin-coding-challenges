package com.igorwojda.list.capitalizeFirst

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun capitalizeFirst(list: List<String>): List<String> {
    return solution.s1(list)
}

object solution{
    fun s1(list: List<String>):List<String>{
       return list.map { it.capitalize() }
    }

    fun s2(list:List<String>):List<String>{
       if(list.isEmpty()){
           return emptyList()
       }

       return listOf(list.first().capitalize()) + s2(list.drop(1))
    }

    fun s3(list: List<String>):List<String>{
       if(list.size == 1){
           return list.map { it.capitalize() }
       }

        return list.take(1).map { it.capitalize() } + s3(list.drop(1))
    }
}

private class Test {
    @Test
    fun `capitalize list with one string`() {
        capitalizeFirst(listOf("igor")) shouldBeEqualTo listOf("Igor")
    }

    @Test
    fun `capitalize list with two strings`() {
        capitalizeFirst(listOf("igor", "wojda")) shouldBeEqualTo listOf("Igor", "Wojda")
    }

    @Test
    fun `capitalize list with empty string`() {
        capitalizeFirst(listOf("")) shouldBeEqualTo listOf("")
    }

    @Test
    fun `capitalize list with sentence`() {
        capitalizeFirst(listOf("what a", "beautiful", "morning")) shouldBeEqualTo listOf(
            "What a",
            "Beautiful",
            "Morning"
        )
    }
}
