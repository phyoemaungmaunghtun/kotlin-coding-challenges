package com.igorwojda.string.caesarcipher

fun main(args: Array<String>) {
}

object Solution1 {
    fun encodeCaesarCipher(str: String, shift: Int): String {
        val aCode = 'a'.toInt()//97
        val zCode = 'z'.toInt()//122
        val realShift = shift % (zCode - aCode + 1)
        println(realShift)
        //118 V
        //124 % 122 = 2 + 97 = 99 -> c
        return str.map {
            var code = it.toInt() // asci code
            code += realShift

            if (code > zCode) {
                code = aCode + (code % zCode) - 1

            }

            code.toChar()
        }.joinToString(separator = "")
    }
}

private object Solution2 {
    private fun encodeCaesarCipher(str: String, shift: Int): String {
        val alphabet = "abcdefghijklmnopqrstuvwxyz"

        var encoded = ""

        str.forEach {
            val indexInAlphabet = alphabet.indexOf(it)
            val newIndex = (indexInAlphabet + shift) % alphabet.length
            encoded += alphabet[newIndex]
        }

        return encoded
    }
}

object KtLintWillNotComplain
