package graphs

/**
 * A graph stores the vertex and adjacent vertex information
 */

const val GRAPH_SIZE = 20

class Graph {
    private var vertexPosition: Int = 0
    private val adjVertex = Array(GRAPH_SIZE) { IntArray(GRAPH_SIZE) }
    private val vertexArray = arrayOfNulls<Vertex>(GRAPH_SIZE)

    /**
     * call this to add the vertex to the graph
     */
    fun addVertex(name: String) {
        vertexArray[vertexPosition++] = Vertex(name, vertexPosition)
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
    fun addAdjacenyBetweenVertex(first: Int, second: Int) {
        adjVertex[first][second] = 1
        adjVertex[second][first] = 1
    }

    /**
     * this prints the name of the vertex give the vertex position
     */
    fun printTheAdjacentNodes(first: Int) {
        println(vertexArray[first]?.name)
    }

    /**
     * this traverses the vertexs using stack as data structure
     */
    fun dfs(){

    }
}