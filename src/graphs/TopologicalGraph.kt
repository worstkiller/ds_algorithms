package graphs

/**
 * a graph with all the basic features but handles directed graphs
 */
class TopologicalGraph {
    private var vertexCount: Int = 0 //current number of  vertices
    private val adjVertex = Array(GRAPH_SIZE) { IntArray(GRAPH_SIZE) } //[n]X[n] adjacency list
    private val vertexArray = arrayOfNulls<Vertex>(GRAPH_SIZE) //vertex array
    private val sortedArray = CharArray(GRAPH_SIZE) //store the directed nodes

    /**
     * call this to add the vertex to the graph
     */
    fun addVertex(name: String) {
        val vertex = Vertex(name, vertexCount, false)
        vertexArray[vertexCount++] = vertex
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
     * pass the vertex positions to which adjacent edges has to be added
     */
    fun addAdjVertex(start: Int, end: Int) {
        adjVertex[start][end] = 1
    }

    /**
     * this prints the name of the vertex give the vertex position
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
       
    }

}