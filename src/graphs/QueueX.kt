package graphs

/**
 * Queue data structure to hold the values from graphs for BFS
 */
class QueueX {

    private val queue = IntArray(SIZE)
    private var front = 0
    private var rear = -1

    companion object {
        const val SIZE = 10
    }

    /**
     * insert an item into queue from rear
     */
    fun insert(value: Int) {
        //full queue reset the rear
        if (rear == SIZE - 1) {
            rear = -1
        }
        queue[++rear] = value
    }

    /**
     * remove an item from the queue and return the item
     */
    fun remove(): Int {
        val item = queue[front++]
        if (front == SIZE) {
            front = 0
        }
        return item
    }

    /**
     * check if queue is empty if not return false else true
     */
    fun isEmpty(): Boolean {
        if (rear + 1 == front || front - 1 == rear) {
            return true
        }
        return false
    }

}