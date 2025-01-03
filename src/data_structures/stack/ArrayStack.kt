package data_structures.stack

class ArrayStack<T> : Stack<T> {

    private var top: Int = -1
    private var capacity: Int = 2
    private var data: Array<Any?> = arrayOfNulls(capacity)

    companion object {
        private const val STACK_IS_EMPTY_MESSAGE: String = "Stack is empty!"
    }

    override fun push(newData: T) {
        if (isFull())
            increaseSize()

        this.data[++top] = newData
    }

    @Suppress("UNCHECKED_CAST")
    override fun pop(): T {
        require(!isEmpty()) { STACK_IS_EMPTY_MESSAGE }

        val poppedData: T = data[top] as T
        data[top--] = null

        if (top <= size() / 4)
            decreaseSize()

        return poppedData
    }

    @Suppress("UNCHECKED_CAST")
    override fun peek(): T {
        require(!isEmpty()) { STACK_IS_EMPTY_MESSAGE }

        return data[top] as T
    }

    override fun size(): Int {
        return data.size
    }

    override fun isFull(): Boolean {
        return top == capacity - 1
    }

    override fun isEmpty(): Boolean {
        return top == -1
    }

    private fun increaseSize() {
        this.capacity *= 2
        this.data = data.copyOf(capacity)
    }

    private fun decreaseSize() {
        this.capacity /= 2
        this.data = data.copyOf(capacity)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ArrayStack<*>

        if (top != other.top) return false
        if (capacity != other.capacity) return false
        if (!data.contentEquals(other.data)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = top
        result = 31 * result + capacity
        result = 31 * result + data.contentHashCode()
        return result
    }

    override fun toString(): String {
        return "ArrayStack(top=$top, capacity=$capacity, data=${data.contentToString()})"
    }

}
