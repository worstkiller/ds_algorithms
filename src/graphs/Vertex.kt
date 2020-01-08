package graphs

/**
 * A Vertex is a node in graph which stores information about a real word entity
 */
class Vertex(val name: String, val position: Int, var wasVisited: Boolean) {

    override fun toString(): String {
        return "-- Name =  $name -- Position = $position -- Was Visited = $wasVisited"
    }
}