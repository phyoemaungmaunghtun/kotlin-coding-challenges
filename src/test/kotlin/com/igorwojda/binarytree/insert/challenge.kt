package com.igorwojda.binarytree.insert

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private data class Node< E :Comparable<E>>(
    val data: E,
    var left: Node<E>? = null,
    var right: Node<E>? = null
)
{
    fun insert(element: E) {
        val newNode = Node(element)
         if(element == data){
             return
         }else if(element < data){
              if(left == null){
                  left = newNode
              }else{
                  left?.insert(element)
              }
         }else if(element > data){
             if(right == null){
                 right = newNode
             }else{
                 right?.insert(element)
             }
         }
    }

    fun contains(element: E): Boolean = when{
        element == data -> true
        element < data -> left?.contains(element) ?: false
        element > data -> right?.contains(element) ?: false
        else -> false
    }
}

private class Test {
    @Test
    fun `can insert correctly`() {
        // -- -------Tree------------
        //
        //           10
        //         /   \
        //        5     15
        //                \
        //                 17
        //
        // --------------------------

        val node = Node(10)
        node.insert(5)
        node.insert(15)
        node.insert(17)

        node.left?.data shouldBeEqualTo 5
        node.right?.data shouldBeEqualTo 15
        node.right?.right?.data shouldBeEqualTo 17
    }

    @Test
    fun `contains returns true when value is found`() {
        // -- -------Tree------------
        //
        //           10
        //          /  \
        //         5    15
        //        /       \
        //       0         20
        //      / \
        //    -5   3
        // --------------------------

        val node = Node(10)
        node.insert(5)
        node.insert(15)
        node.insert(20)
        node.insert(0)
        node.insert(-5)
        node.insert(3)

        node.contains(3) shouldBeEqualTo true
    }

    @Test
    fun `contains returns false if value not found`() {
        // -- -------Tree------------
        //
        //           10
        //          /  \
        //         5    15
        //        /       \
        //       0         20
        //      / \
        //    -5   3
        // --------------------------

        val node = Node(10)
        node.insert(5)
        node.insert(15)
        node.insert(20)
        node.insert(0)
        node.insert(-5)
        node.insert(3)

        node.contains(9999) shouldBeEqualTo false
    }
}
