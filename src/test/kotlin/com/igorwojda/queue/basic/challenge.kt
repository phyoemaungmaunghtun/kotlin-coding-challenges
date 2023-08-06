package com.igorwojda.queue.basic

import com.igorwojda.linkedlist.singly.base.Solution1
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

private class Queue<E> {

    /*val list = mutableListOf<E>()

    fun add(data:E){
        list.add(data)
    }

    fun remove(){
        list.removeAt(0)
    }

    fun peek():E?{
        return list.firstOrNull()
    }

    fun isEmpty() = list.isEmpty()

    val size get() = list.size*/
    var size = 0
        private set

    var first: Node<E>? = null
    var last: Node<E>? = null

    fun add(element: E) {
        val node = Node(element)
        if (first == null) {
            first = node
        } else {
            last?.next = node
        }
        size++
        last = node
    }

    fun remove(): E? {
        if(size == 0){
            return null;
        }
        val node = first
        first = first?.next
        size--
        return node?.data
    }

    fun peek(): E? = first?.data

    fun isEmpty(): Boolean = first == null
}

private data class Node<E>(val data: E, var next:Node<E>? = null)

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
