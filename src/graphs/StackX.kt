package graphs

/**
 * this class acts as an data structure to hold the data in first in last out fashion
 * this stack is an int stack taking only integer values
 */

const val SIZE = 20

/**
 * StackX class
 */
class StackX {

    var top = -1
    val stack = IntArray(SIZE)

    /**
     * call this to push something into the stack
     */
    fun push(value: Int) {
        stack[++top] = value
    }

    /**
     * call this to get and remove the top of the stack
     */
    fun pop(): Int {
        return stack[top--]
    }

    /**
     * call this to see the content of the top of the stack
     */
    fun peek(): Int {
        return stack[top]
    }

    /**
     * call this to get if the stack is empty or not
     */
    fun isEmpty(): Boolean {
        return top == -1
    }

}