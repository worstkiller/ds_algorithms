package graphs

/**
 * a main class for the graph to execute the data structure operations
 */
fun main() {
    val alphas = arrayOf('A'..'E').map { it.toString() }.toList()
    val graph = Graph()
    //adding the graphs
    for (alpha in alphas) {
        graph.addVertex(alpha)
    }

    graph.addAdjVertex(0, 1)
    graph.addAdjVertex(1, 2)
    graph.addAdjVertex(2, 3)
    graph.addAdjVertex(0, 4)
    graph.addAdjVertex(0, 5)
    graph.addAdjVertex(5, 6)
    graph.addAdjVertex(6, 7)
    graph.addAdjVertex(0, 8)

    print("Visits Dfs\n")

    graph.dfs()

    println()

    print("Visits Bfs")

    println()

    graph.bfs()

    println("Visits Mst")

    graph.mst()

}