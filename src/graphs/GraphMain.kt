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

    graph.addAdjVertex(0, 1)
    graph.addAdjVertex(1, 2)
    graph.addAdjVertex(0, 3)
    graph.addAdjVertex(3, 4)

    print("Visits \n")

    graph.dfs()

}