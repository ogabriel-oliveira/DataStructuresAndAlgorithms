package data_structures.stack

interface Stack<T> {

    fun push(newData: T)
    fun pop(): T
    fun peek(): T
    fun size(): Int
    fun isFull(): Boolean
    fun isEmpty(): Boolean
}
