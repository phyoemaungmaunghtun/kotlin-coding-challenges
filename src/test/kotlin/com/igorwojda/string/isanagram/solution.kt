package com.igorwojda.string.isanagram


fun main(array: Array<String>){
    Solution3.isAnagram("Hellllooo","Heool")
}
private object Solution1 {
    private fun isAnagram(str1: String, str2: String): Boolean {
        val a1 = str1.toUpperCase().filter { it.isLetter() }.groupBy { it }
        val a2 = str2.toUpperCase().filter { it.isLetter() }.groupBy { it }
        return a1 == a2
    }
}
 object Solution2 {
     fun isAnagram(str1: String, str2: String): Boolean {
        getCharFrequency(str1).map { println("${it.key} ${it.value}") }
        return getCharFrequency(str1) == getCharFrequency(str2)
    }

    private fun getCharFrequency(str: String): Map<Char, List<Char>> {
        return str.toLowerCase()
            .filter { it.isLetterOrDigit() }
            .groupBy { it }
    }
}
 object Solution3 {
    fun isAnagram(str1: String, str2: String): Boolean {
        Solution3.getCharFrequency(str1).map { println("${it.key} ${it.value}") }
        return getCharFrequency(str1) == getCharFrequency(str2)
    }

     fun getCharFrequency(str: String): Map<Char, Int> {
        return str.toLowerCase()
            .filter { it.isLetterOrDigit() }
            .groupingBy { it }
            .eachCount()
    }
}

private object KtLintWillNotComplain
