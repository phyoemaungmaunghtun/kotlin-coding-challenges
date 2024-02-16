package com.igorwojda.tree.binarysearchtree

object Solution1 {
    /**
     *     • The main operations in this BST implementation (add and contains) have an average time complexity of O(logn) if the tree is balanced.
     *     • However, their worst-case time complexity is O(n) if the tree is skewed. This is why balanced binary search trees (like AVL trees or Red-Black trees) are often preferred in practice, as they ensure that the tree remains balanced after every insert or delete operation, guaranteeing O(logn) time complexity for most operations.
     *     • The space complexity for the operations in this implementation is constant, O(1). The space used by the tree itself grows linearly with the number of elements, i.e., O(n).
     *
     */
    private class BinarySearchTree<E : Comparable<E>> {
        var root: BinaryNode<E>? = null
            private set

        fun add(element: E) {
            val newNode = BinaryNode(element)

            if (root == null) {
                root = newNode
                return
            }

            var current: BinaryNode<E> = root ?: return

            while (true) {
                when {
                    current.data == element -> {
                        return
                    }
                    element < current.data -> {
                        if (current.left == null) {
                            current.left = newNode
                            return
                        }

                        current.left?.let { current = it }
                    }
                    element > current.data -> {
                        if (current.right == null) {
                            current.right = newNode
                            return
                        }

                        current.right?.let { current = it }
                    }
                }
            }
        }

        fun contains(element: E): Boolean {
            var current = root

            while (true) {
                if (current == null) {
                    break
                } else if (current.data == element) {
                    return true
                } else if (element < current.data) {
                    current = current.left
                } else if (element > current.data) {
                    current = current.right
                }
            }

            return false
        }

        fun isEmpty() = root == null
    }

    private data class BinaryNode<E : Comparable<E>>(
        val data: E,
        var left: BinaryNode<E>? = null,
        var right: BinaryNode<E>? = null
    )
}

private object KtLintWillNotComplain
