package at.jgr1585.kruskal

import at.jgr1585.kruskal.graph.Edge
import at.jgr1585.kruskal.graph.Graph
import java.util.PriorityQueue

fun kruskal(graph: Graph): List<Edge> {
    val result = mutableListOf<Edge>()
    val que = PriorityQueue<Edge>(compareBy { it.weight })
    que.addAll(graph.edges)

    val unionFind = UnionFind(graph.vertices)

    while (result.size < graph.vertices.size - 1 && que.isNotEmpty()) {
        val edge = que.poll()
        val rootSource = unionFind.find(edge.start)
        val rootDestination = unionFind.find(edge.end)

        if (rootSource != rootDestination) {
            result.add(edge)
            unionFind.union(edge.start, edge.end)
        }
    }

    return result
}