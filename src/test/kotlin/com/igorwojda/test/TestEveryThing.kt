package com.igorwojda.test


fun main(){
    val n = readLine()!!.trim().toInt()
    val s = readLine()!!.trim().split(" ").map { it.toInt() }.toTypedArray().toList()
    val first_multi = readLine()!!.trim().split(" ")
    val d = first_multi[0].toInt()
    val m = first_multi[1].toInt()

    println( birthday(s,d,m))

}

fun birthday(s:List<Int>,d:Int,m:Int):Int{
   var ways = 0
    for(i in 0..(s.size - m)){
        if(s.subList(i,i+m).sum() == d){
            ways++
        }
    }
    return ways
}

fun twoArrays(k:Int,A: Array<Int>, B:Array<Int>):String{
    A.sort()
    B.sortDescending()

    for (i in A.indices) {
        if (A[i] + B[i] < k) {
            return "NO"
        }
    }

    return "YES"
}
object TestEveryThing {
    fun pangram(str: String): String {
        val lowerString = str.toLowerCase()
       for(char in 'a'..'z'){
           if(char !in lowerString){
               return "not pangram"
           }
       }
        return "pangram"
    }

}