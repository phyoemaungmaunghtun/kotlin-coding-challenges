package com.igorwojda.queue.basic

import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private class Queue<E> {
    val list = mutableListOf<E>()

    fun add(element: E){
        list.add(element)
    }

    fun remove() = if(list.isEmpty()) null else list.removeAt(0)

    fun isEmpty() = list.isEmpty()

    val size get() = list.size

    fun peek() = list.firstOrNull()

    /*var first: Node<E>? = null
    var last: Node<E>? = null
    var size = 0
        private set

    fun add(data: E) {
        val node = Node(data)
        if (first == null) {
            first = node
        } else {
            last?.next = node
        }
        size++
        last = node
    }

    fun remove(): E? {
        if (first == null) return null
        val node = first
        first = first?.next
        if (first == null) {
            last = null
        }
        size--
        return node!!.data
    }

    fun peek(): E? {
        return if (first == null)  null else  first!!.data
    }

    fun isEmpty() = first == null*/


}

private data class Node<E>(val data: E, var next: Node<E>? = null)

private class Test {
    @Test
    fun `can add elements to a queue`() {
        Queue<Int>().apply { add(1) }
    }

    @Test
    fun `can remove elements from empty queue`() {
        Queue<Int>().apply { remove() shouldBeEqualTo null }
    }

    @Test
    fun `can remove elements from a queue`() {
        Queue<String>().apply {
            add("ABC")
            remove()
        }
    }

    @Test
    fun `order of elements is maintained`() {
        Queue<Char>().apply {
            add('A')
            add('B')
            add('C')
            remove() shouldBeEqualTo 'A'
            remove() shouldBeEqualTo 'B'
            remove() shouldBeEqualTo 'C'
            remove() shouldBeEqualTo null
        }
    }

    @Test
    fun `peek returns, but does not remove element`() {
        Queue<Int>().apply {
            add(1)
            add(2)
            peek() shouldBeEqualTo 1
            peek() shouldBeEqualTo 1
            remove() shouldBeEqualTo 1
            peek() shouldBeEqualTo 2
            remove() shouldBeEqualTo 2
            peek() shouldBeEqualTo null
            remove() shouldBeEqualTo null
        }
    }

    @Test
    fun `isEmpty returns true`() {
        Queue<Int>().isEmpty() shouldBeEqualTo true
    }

    @Test
    fun `isEmpty returns false`() {
        Queue<Int>().apply {
            add(1)
            isEmpty() shouldBeEqualTo false
        }
    }

    @Test
    fun `queue has correct size`() {
        Queue<Char>().apply {
            size shouldBeEqualTo 0

            add('A')
            size shouldBeEqualTo 1

            add('B')
            size shouldBeEqualTo 2

            add('C')
            size shouldBeEqualTo 3

            remove()
            size shouldBeEqualTo 2

            remove()
            size shouldBeEqualTo 1

            remove()
            size shouldBeEqualTo 0
        }
    }

    @Test
    fun `remove item from empty queue`() {
        Queue<Int>().apply {
            remove()

            size shouldBeEqualTo 0
        }
    }
}
