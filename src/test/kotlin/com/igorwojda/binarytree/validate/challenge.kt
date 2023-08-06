package com.igorwojda.binarytree.validate

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private fun isValidSearchBinaryTree(node: Node<Int>,min: Int? = null, max:Int? = null): Boolean {
    if(min != null && node.data < min){
        return false
    }
    if(max != null && node.data > max){
        return false
    }
    val leftNode = node.left
    if(leftNode?.data != null){
        return isValidSearchBinaryTree(leftNode,min,node.data)
    }
    val rightNode = node.right
    if(rightNode?.data != null ){
        return isValidSearchBinaryTree(rightNode,node.data,max)
    }
    return true
}

private class Test {
    @Test
    fun `Validate recognizes a valid BST`() {
        // -- -------Tree------------
        //
        //           10
        //          /  \
        //         5    15
        //        /       \
        //       0         20
        // --------------------------

        val node = Node(10)
        node.insert(5)
        node.insert(15)
        node.insert(0)
        node.insert(20)

        isValidSearchBinaryTree(node) shouldBeEqualTo true
    }

    @Test
    fun `Validate recognizes an invalid BST`() {
        // -- -------Tree------------
        //
        //           10
        //          /  \
        //         5    15
        //        /       \
        //       0         20
        //        \
        //        999
        // --------------------------

        val node = Node(10)
        node.insert(5)
        node.insert(15)
        node.insert(0)
        node.insert(20)
        node.left?.left?.right = Node(999)

        isValidSearchBinaryTree(node) shouldBeEqualTo false
    }
}

private data class Node<E : Comparable<E>>(
    var data: E,
    var left: Node<E>? = null,
    var right: Node<E>? = null
) {
    fun insert(e: E) {
        if (e < data) { // left node
            if (left == null) {
                left = Node(e)
            } else {
                left?.insert(e)
            }
        } else if (e > data) { // right node
            if (right == null) {
                right = Node(e)
            } else {
                right?.insert(e)
            }
        }
    }
}
