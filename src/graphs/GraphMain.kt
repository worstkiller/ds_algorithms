package graphs

/**
 * a main class for the graph to execute the data structure operations
 */
fun main() {
    val alphas = arrayOf("Tokyo", "Berlin", "Mosco", "Oslo", "Denver", "Nairobi", "Bogota")
    val graph = Graph()
    //adding the graphs
    for (alpha in alphas) {
        graph.addVertex(alpha)
    }

    graph.addAdjacenyBetweenVertex(0, 3)
    graph.addAdjacenyBetweenVertex(2, 5)
    graph.addAdjacenyBetweenVertex(1, 5)
    graph.addAdjacenyBetweenVertex(4, 6)

    println("The total no of vertexs are ${graph.getTotalVertexs()}")

    println("The Vertex information is = ${graph.getVertex("Berlin")?.toString() ?: "Not present"}")

    graph.printTheAdjacentNodes(0)

}