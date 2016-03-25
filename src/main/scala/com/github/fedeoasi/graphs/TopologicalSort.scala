package com.github.fedeoasi.graphs

import scala.collection.mutable

class TopologicalSort(graph: DiGraph) {
  private val marked = Array.fill(graph.nodeSize)(false)
  private val visited = new mutable.Stack[Int]()

  private def sort(i: Int): Unit = {
    if (!marked(i)) {
      marked(i) = true
      graph.adj(i).foreach { n =>
        sort(n)
      }
      visited.push(i)
    }
  }

  def sort(): Iterable[Int] = {
    if (graph.nodeSize > 0) {
      sort(0)
    }
    visited
  }
}
