package graphs

/**
 * A graph stores the vertex and adjacent vertex information
 */

const val GRAPH_SIZE = 10

class Graph {
    private var vertexPosition: Int = 0
    private val adjVertex = Array(GRAPH_SIZE) { IntArray(GRAPH_SIZE) }
    private val vertexArray = arrayOfNulls<Vertex>(GRAPH_SIZE)
    private val stackX = StackX()
    private val queueX = QueueX()

    /**
     * call this to add the vertex to the graph
     */
    fun addVertex(name: String) {
        val vertex = Vertex(name, vertexPosition, false)
        vertexArray[vertexPosition++] = vertex
    }

    /**
     * this  vertex name has to be unique
     */
    fun getVertex(name: String): Vertex? {
        for (vertex in vertexArray) {
            if (name == vertex?.name) {
                return vertex
            }
        }
        return null
    }

    /**
     * this returns the total number of the vertexes in a graph
     */
    fun getTotalVertexs(): Int {
        return vertexPosition
    }

    /**
     * pass the vertex positions to which adjacent edges has to be added
     */
    fun addAdjVertex(first: Int, second: Int) {
        adjVertex[first][second] = 1
        adjVertex[second][first] = 1
    }

    /**
     * this prints the name of the vertex give the vertex position
     */
    fun printTheNodes(first: Int) {
        print(vertexArray[first]?.name)
    }

    /**
     * this traverses the vertexs using stack as data structure
     * this does 4 things by default
     * 1 it examins the top stack item using peek
     * 2 it tries to find the un visited neighbor of this vertex
     * 3 if it doesn't find one then it pops the stack
     * 4 if it finds such a vertex, it visits that vertex and pushes onto the stack
     */
    fun dfs() {
        //step 1
        vertexArray[0]?.let {
            visitNodeDfs(it)
        }
        while (!stackX.isEmpty()) {
            //step 2
            vertexArray[stackX.peek()]?.let {
                val nextNode = getAdjUnVisitedVertex(it.name)
                //step 3
                if (nextNode == null) {
                    stackX.pop()
                } else {
                    visitNodeDfs(nextNode)
                }
            }
        }

        //reset the graph
        clearGraph()
    }

    /**
     * this traverses the vertexs using queue as data structure
     * this does 4 things by default
     * 1 it examins the top queue item using remove
     * 2 it tries to find the un visited neighbor of this vertex
     * 3 if it doesn't find one then it pops the stack
     * 4 if it finds such a vertex, it visits that vertex and pushes onto the stack
     */
    fun bfs() {
        //step 1 visit the starting point first marks it, inserts it into queue and displays them
        vertexArray[0]?.let {
            visitNodeBfs(it)
        }
        while (!queueX.isEmpty()) { //while queue is not empty
            val v1 = queueX.remove() //remove vertex at head
            //loop until the head has no unvisited vertexes
            vertexArray[v1]?.let {
                while (true) {
                    val adjacentVertex = getAdjUnVisitedVertex(it.name)
                    if (adjacentVertex != null) {
                        visitNodeBfs(adjacentVertex)
                    } else {
                        break
                    }
                }
            }
        }
        //reset the graph
        clearGraph()
    }

    /**
     * this clears the dfs operation related values reset
     */
    private fun clearGraph() {
        for (item in vertexArray) {
            item?.wasVisited = false
        }
    }

    /**
     * push them to stack
     * display it
     * mark them visited
     */
    private fun visitNodeDfs(it: Vertex) {
        it.wasVisited = true
        printTheNodes(it.position)
        stackX.push(it.position)
    }

    /**
     * insert them to queue
     * display it
     * mark them visited
     */
    private fun visitNodeBfs(it: Vertex) {
        it.wasVisited = true
        printTheNodes(it.position)
        queueX.insert(it.position)
    }

    /**
     * It returns the un visited vertex position of the current vertex otherwise null
     */
    fun getAdjUnVisitedVertex(name: String): Vertex? {
        getVertex(name)?.let {
            for (node in vertexArray) {
                node?.let { path ->
                    if (adjVertex[it.position][path.position] == 1 && !path.wasVisited) {
                        return path
                    }
                }
            }
        }
        //default response
        return null
    }
}