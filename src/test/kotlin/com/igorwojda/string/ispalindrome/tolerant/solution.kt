package com.igorwojda.string.ispalindrome.tolerant

// iterative solution
private object Solution1 {
    fun isTolerantPalindrome(s: String): Boolean {
        var i = 0
        var j = s.lastIndex
        while (i < j) {
            if (s[i] != s[j]) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1)
            }
            i++
            j--
        }
        return true
    }

    fun isPalindrome(s: String, i: Int, j: Int): Boolean {
        var start = i
        var end = j
        while (start < end) {
            if (s[start] != s[end]) {
                return false
            }
            start++
            end--
        }
        return true
    }
}
// recursive solution
private object Solution2 {
    private fun isTolerantPalindrome(str: String, characterRemoved: Boolean = false): Boolean {
        return if (str.isEmpty() || str.length == 1) {
            true
        } else {
            if (str.first() == str.last()) {
                isTolerantPalindrome(
                    str.substring(1 until str.lastIndex),
                    characterRemoved
                )
            } else {
                if (characterRemoved) {
                    false
                } else {
                    val removeLeftResult = isTolerantPalindrome(
                        str.substring(1 until str.lastIndex + 1),
                        true
                    )
                    val removeRightResult = isTolerantPalindrome(
                        str.substring(0 until str.lastIndex),
                        true
                    )

                    removeLeftResult || removeRightResult
                }
            }
        }
    }
}

// recursive solution 2
private object Solution3 {
private fun isTolerantPalindrome(str: String, characterRemoved: Boolean = false): Boolean {
    val revStr = str.reversed()
    if (revStr == str) return true
    if (characterRemoved) return false

    // Remove a single non matching character and re-compare
    val removeIndex = str.commonPrefixWith(revStr).length
    if (removeIndex + 1 > str.length) return false // reached end of string

    // Try removing a character from the start of the string
    val reducedStrStart = str.removeRange(removeIndex, removeIndex + 1)
    if (isTolerantPalindrome(reducedStrStart, true)) return true

    // Try removing a character from the end of the string
    val reducedStrEnd = str.removeRange(str.lastIndex - removeIndex, str.lastIndex - removeIndex + 1)
    return isTolerantPalindrome(reducedStrEnd, true)
}
}