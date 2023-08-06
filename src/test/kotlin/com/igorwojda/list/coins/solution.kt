package com.igorwojda.list.coins

fun main(array: Array<String>){
    Solution1.getCoins(4, listOf(2,3,4))
}

// Time complexity: O(n∗m)
// Space complexity: O(n)O(n)
private object Solution1 {
    fun getCoins(amount: Int, coins: List<Int>): Int {
        // array of zeros from 0..amount
        val waysOfDoingNCents = IntArray(amount + 1)

        waysOfDoingNCents[0] = 1

        for (coin in coins) {
            for (higherAmount in coin..amount) {
                val higherAmountRemainder = higherAmount - coin
                waysOfDoingNCents[higherAmount] += waysOfDoingNCents[higherAmountRemainder]
                println("coin "+coin+": higherAmount : "+higherAmount+" -> "+waysOfDoingNCents[higherAmount]+" -> "+waysOfDoingNCents.map { it })
            }
        }

        for(item in waysOfDoingNCents){
            println(item)
        }
        return waysOfDoingNCents[amount]
    }
}

private object KtLintWillNotComplain