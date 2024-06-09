package at.jgr1585.kruskal

import at.jgr1585.kruskal.graph.Edge
import at.jgr1585.kruskal.graph.Graph
import at.jgr1585.kruskal.graph.Node

fun main() {
    val nodes = listOf(
        Node(0, "A"),
        Node(1, "B"),
        Node(2, "C"),
        Node(3, "D"),
        Node(4, "E")
    )

    val edges = listOf(
        Edge(nodes[0], nodes[1], 4),
        Edge(nodes[0], nodes[2], 4),
        Edge(nodes[1], nodes[2], 2),
        Edge(nodes[1], nodes[3], 6),
        Edge(nodes[2], nodes[3], 8),
        Edge(nodes[2], nodes[4], 9),
        Edge(nodes[3], nodes[4], 7)
    )

    val graph = Graph(vertices = nodes, edges = edges)

    val path = kruskal(graph)

    println("Minimum Spanning Tree:")
    path.forEach {
        println("${it.start.name} -> ${it.end.name} = ${it.weight}")
    }
}