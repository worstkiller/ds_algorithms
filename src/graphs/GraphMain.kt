package graphs

/**
 * a main class for the graph to execute the data structure operations
 */
fun main() {
    val alphas = arrayOf("A", "B", "C", "D", "E")
    val graph = Graph()
    //adding the graphs
    for (alpha in alphas) {
        graph.addVertex(alpha)
    }

    graph.addAdjacenyBetweenVertex(0, 1)
    graph.addAdjacenyBetweenVertex(1, 2)
    graph.addAdjacenyBetweenVertex(0, 3)
    graph.addAdjacenyBetweenVertex(3, 4)

    println("The total no of vertexs are ${graph.getTotalVertexs()}")

    println("The Vertex information is = ${graph.getVertex("Berlin")?.toString() ?: "Not present"}")

    print("Visits \n")

    graph.dfs()

}