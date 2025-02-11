package com.igorwojda.tree.heap.maxbinaryheap

object Solution1 {
    /**
     * Time -> O(log n) for add and remove
     * Space -> O(n) for binary heap map
     * Time and Space -> O(1) for constant-time arithmetic  operation and don't use any extra space
     */
    private class MaxBinaryHeap<E : Comparable<E>> {
        val items = mutableListOf<E>()

        fun add(element: E) {
            items.add(element)
            bubbleUpLastLeaf()
        }

        fun removeMax(): E? {

            if (items.isEmpty()) return null

            if (items.size == 1) {
                return items.removeAt(0)
            }

            items.swap(0, items.lastIndex)

            val max = items.removeAt(items.lastIndex)

            if (items.size > 1) {
                bubbleDownRootElement()
            }

            return max
        }

        private fun bubbleDownRootElement() {
            var elementIndex = 0
            var leftChildIndex = getLeftChildIndex(elementIndex)
            var rightChildIndex = getRightChildIndex(elementIndex)

            // Only two elements
            if (items.getOrNull(rightChildIndex) == null) {
                if (items[elementIndex] < items[leftChildIndex]) {
                    items.swap(elementIndex, leftChildIndex)
                }
                return
            }

            while ((items[elementIndex] < items[leftChildIndex]) ||
                items[elementIndex] < items[rightChildIndex]
            ) {

                elementIndex = if (rightChildIndex > items.lastIndex ||
                    items[leftChildIndex] > items[rightChildIndex]
                ) {
                    items.swap(leftChildIndex, elementIndex)
                    leftChildIndex
                } else {
                    items.swap(rightChildIndex, elementIndex)
                    rightChildIndex
                }

                leftChildIndex = getLeftChildIndex(elementIndex)
                rightChildIndex = getRightChildIndex(elementIndex)
            }
        }

        private fun bubbleUpLastLeaf() {
            var elementIndex = items.lastIndex
            var parentIndex = getParentIndex(elementIndex)

            while (items[elementIndex] > items[parentIndex]) {
                items.swap(elementIndex, parentIndex)

                elementIndex = parentIndex
                parentIndex = getParentIndex(elementIndex)
            }
        }

        private fun getParentIndex(index: Int) = (index - 1) / 2 // divided by 2 because it is double of heap need to reduce to upward

        private fun getLeftChildIndex(index: Int) = (index * 2) + 1 // multiplied by 2 and 1 for left because need to increase size of heap to downward

        private fun getRightChildIndex(index: Int) = (index * 2) + 2 // multiplied by 2 and 2 for right because need to increase size of heap to downward

        fun isEmpty() = items.isEmpty()

        private fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
            val tmp = this[index1]
            this[index1] = this[index2]
            this[index2] = tmp
        }
    }
}

private object KtLintWillNotComplain
