package at.jgr1585.kruskal

import at.jgr1585.kruskal.graph.Node

class UnionFind(nodes: List<Node>) {
    private val parent = mutableMapOf<Node, Node>()
    private val rank = mutableMapOf<Node, Int>()

    init {
        for (node in nodes) {
            parent[node] = node
            rank[node] = 0
        }
    }

    fun union(node1: Node, node2: Node) {
        val root1 = find(node1)
        val root2 = find(node2)

        if (root1 != root2) {
            if (rank[root1]!! > rank[root2]!!) {
                parent[root2] = root1
            } else if (rank[root1]!! < rank[root2]!!) {
                parent[root1] = root2
            } else {
                parent[root2] = root1
                rank[root1] = rank[root1]!! + 1
            }
        }
    }

    fun find(node: Node): Node {
        if (parent[node] != node) {
            parent[node] = find(parent[node]!!)
        }
        return parent[node]!!
    }
}