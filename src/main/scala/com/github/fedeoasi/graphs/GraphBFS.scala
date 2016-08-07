package com.github.fedeoasi.graphs

import scala.collection.mutable

class GraphBFS(graph: Graph, node: Int) {
  private case class NodeAndLevel(node: Int, level: Int)

  def bfs(): BFSResult = {
    val marked = Array.fill(graph.nodeSize)(false)
    val distTo = Array.fill[Option[Int]](graph.nodeSize)(None)
    var visited = List.empty[Int]
    val queue = new mutable.Queue[NodeAndLevel]()
    queue.enqueue(NodeAndLevel(node, 0))
    while (queue.nonEmpty) {
      val NodeAndLevel(curr, level) = queue.dequeue()
      if (!marked(curr)) {
        distTo(curr) = Some(level)
        marked(curr) = true
        visited ::= curr
        graph.adj(curr).foreach { n =>
          if (!marked(n)) {
            queue.enqueue(NodeAndLevel(n, level + 1))
          }
        }
      }
    }
    BFSResult(marked, visited.reverse, distTo)
  }
}

case class BFSResult(marked: Seq[Boolean], nodes: Seq[Int], distTo: Seq[Option[Int]])