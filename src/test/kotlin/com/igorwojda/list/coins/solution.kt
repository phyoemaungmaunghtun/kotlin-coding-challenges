package com.igorwojda.list.coins

fun main(array: Array<String>){
    Solution1.getCoins(4, listOf(1,2,3), emptyList())
}

// Time complexity: O(n∗m)
// Space complexity: O(n)O(n)
private object Solution1 {
    fun getCoins(target:Int, coins: List<Int>, current:List<Int>){
        //exact case
        if(target == 0){
            println(current.joinToString(", "))
            return
        }
        //impossible case
        if(target < 0){
            return
        }

        for(coin in coins){
            getCoins(target - coin,coins,current + coin)
        }
    }

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

        return waysOfDoingNCents[amount]
    }

}

private object KtLintWillNotComplain