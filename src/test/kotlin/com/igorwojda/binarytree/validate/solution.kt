package com.igorwojda.binarytree.validate

private object Solution1 {
    /**
     *
    Time Complexity:
    The function is a recursive function that visits each node of the tree exactly once. In the worst case, the function will visit all the nodes of the tree.
    For a tree with n nodes:
    • The time complexity of visiting each node is O(1).
    • Since each node is visited once, the overall time complexity is O(n).
    Therefore, the time complexity of the isValidSearchBinaryTree function is O(n), where n is the number of nodes in the tree.

    Space Complexity:
    The primary space consumption in this function is from the recursive call stack. In the worst case, the function will recurse as deep as the height of the tree.
    • For a balanced binary search tree, the height is O(logn).
    • For a skewed binary search tree (where each node has only one child), the height is O(n).
    In the worst case (a skewed tree), the maximum number of frames on the call stack (due to recursion) will be n.
    Therefore, the space complexity of the isValidSearchBinaryTree function is O(n) in the worst case, and O(logn) in the best case (for a balanced tree).
    Note: Here, the space complexity is mainly driven by the recursive call stack depth. We're not considering the space taken by input, as that's typically not included in space complexity calculations for algorithms.

     */
    private fun isValidSearchBinaryTree(node: Node<Int>, min: Int? = null, max: Int? = null): Boolean {
        if (min != null && node.data < min) {
            return false
        }

        if (max != null && node.data > max) {
            return false
        }

        val leftNode = node.left
        if (leftNode != null) {
            return isValidSearchBinaryTree(leftNode, min, node.data)
        }

        val rightNode = node.right
        if (rightNode != null) {
            return isValidSearchBinaryTree(rightNode, node.data, max)
        }

        return true
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
}

private object KtLintWillNotComplain
