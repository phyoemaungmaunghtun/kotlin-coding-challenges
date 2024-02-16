package com.igorwojda.string.caesarcipher

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun encodeCaesarCipher(str: String, shift: Int): String {
    val aCode = 'a'.toInt()
    val zCode = 'z'.toInt()
    val realShift = shift % (zCode - aCode + 1)

    return str.map {
        var code = it.toInt()
        code += realShift
        //println("Code :$code ")

        if(code > zCode){
            if(code == 123){
                val test =  aCode + (code % zCode) - 1
                println("Code :${test.toChar()} ")
            }
            code =  aCode + (code % zCode) - 1

        }
        code.toChar()
    }.joinToString("")
}

private class Test {
    @Test
    fun `"abc" with shift 1 return "bcd"`() {
        encodeCaesarCipher("abc", 1) shouldBeEqualTo "bcd"
    }

    @Test
    fun `"abcdefghijklmnopqrstuvwxyz" shift 1 returns "bcdefghijklmnopqrstuvwxyza"`() {
        encodeCaesarCipher(
            "abcdefghijklmnopqrstuvwxyz",
            3
        ) shouldBeEqualTo "defghijklmnopqrstuvwxyzabc"
    }

    @Test
    fun `"abcdefghijklmnopqrstuvwxyz" shift 7 returns "hijklmnopqrstuvwxyzabcdefg"`() {
        encodeCaesarCipher(
            "abcdefghijklmnopqrstuvwxyz",
            7
        ) shouldBeEqualTo "hijklmnopqrstuvwxyzabcdefg"
    }

    @Test
    fun `"abcdefghijklmnopqrstuvwxyz" shift 50 returns "yzabcdefghijklmnopqrstuvwx"`() {
        encodeCaesarCipher(
            "abcdefghijklmnopqrstuvwxyz",
            50
        ) shouldBeEqualTo "yzabcdefghijklmnopqrstuvwx"
    }
}
