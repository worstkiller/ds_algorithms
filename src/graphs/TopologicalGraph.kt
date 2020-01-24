package graphs

/**
 * a graph with all the basic features but handles directed graphs with topological order
 * certain nodes must be visit before visiting another
 */
class TopologicalGraph {
    private var vertexCount: Int = 0 //current number of  vertices
    private val adjVertex = Array(GRAPH_SIZE) { IntArray(GRAPH_SIZE) } //[n]X[n] adjacency list
    private val vertexArray = arrayOfNulls<Vertex>(GRAPH_SIZE) //vertex array
    private val sortedArray = arrayOfNulls<String>(GRAPH_SIZE)  //store the directed nodes

    /**
     * call this to add the vertex to the graph
     */
    fun addVertex(name: String) {
        val vertex = Vertex(name, vertexCount, false)
        vertexArray[vertexCount++] = vertex
    }

    /**
     * this vertex name has to be unique
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
     * pass the vertex positions to which adjacent edges has to be added
     */
    fun addAdjVertex(start: Int, end: Int) {
        adjVertex[start][end] = 1
    }

    /**
     * this prints the name of the vertex given the vertex position
     */
    fun displayVertex(first: Int) {
        print(vertexArray[first]?.name)
    }

    /**
     * sort the graph topological,
     * directed and add the compulsion of visiting one node before another
     * to fulfill the constraint for topological graph
     */
    fun sortTopo() {
        val noOfVertices = vertexCount
        while (vertexCount > 0) {
            //get the no successor node to start with
            val currentVertex = noSuccessors()
            if (currentVertex == null) {
                println("This graph is cyclic or it has loops")
                return
            }
            sortedArray[vertexCount - 1] = vertexArray[currentVertex]?.name
            deleteVertex(currentVertex)
        }
        displayTopologicalOrder(noOfVertices)
    }

    /**
     * to find the node or vertex with no successor or forward node from current one
     */
    fun noSuccessors(): Int? {
        var isEdge: Boolean //edge from row to column in adjacency matrix
        for (rows in 0 until vertexCount) {
            isEdge = false
            for (column in 0 until vertexCount) {
                if (adjVertex[rows][column] > 0) {
                    isEdge = true
                    break //found edge between two vertices, break and return for next iteration
                }
            }
            if (!isEdge) { //if no edge return the row
                return rows
            }
        }
        return null
    }

    /**
     * delete the given node and move the positions of existing nodes
     */
    fun deleteVertex(nodePosition: Int) {
        print(nodePosition)
        //if not last vertex
        if (nodePosition != vertexCount - 1) {
            //removing the node from the vertex list
            for (count in nodePosition until vertexCount - 1) {
                vertexArray[count] = vertexArray[count + 1]
            }

            //moving the row or delete the row by shifting data to previous row upwards
            for (row in nodePosition until vertexCount - 1) {
                moveRowUp(row, vertexCount)
            }

            //removing the column from the adjacency matrix by shifting data to left
            for (column in nodePosition until vertexCount - 1) {
                moveColumnLeft(column, vertexCount - 1)
            }
        }
        vertexCount--
    }

    /**
     * call this to move the data upwards in adjacency matrix
     */
    private fun moveRowUp(row: Int, length: Int) {
        for (column in 0 until length) {
            adjVertex[row][column] = adjVertex[row + 1][column]
        }
    }

    /**
     * call this to move the column data to left in adjacency matrix
     */
    private fun moveColumnLeft(column: Int, length: Int) {
        for (row in 0 until length) {
            adjVertex[row][column] = adjVertex[row][column + 1]
        }
    }

    /**
     * iterates over the sorted array and displays it accordingly
     */
    fun displayTopologicalOrder(noOfVertices: Int) {
        println("Topological Order is as follows")
        for (count in 0 until noOfVertices)
            print(sortedArray[count])
        println()
    }

}