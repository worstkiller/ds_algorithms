package graphs

fun main() {

    val nodes = arrayOf("A","B","C","D","E","F","G","H")
    val graphTopo = TopologicalGraph()

    for (item in nodes){
        graphTopo.addVertex(item)
    }

    graphTopo.addAdjVertex(0,3)
    graphTopo.addAdjVertex(0,4)
    graphTopo.addAdjVertex(1,4)
    graphTopo.addAdjVertex(2,5)
    graphTopo.addAdjVertex(3,6)
    graphTopo.addAdjVertex(4,6)
    graphTopo.addAdjVertex(5,7)
    graphTopo.addAdjVertex(6,7)

    graphTopo.sortTopo()

}

