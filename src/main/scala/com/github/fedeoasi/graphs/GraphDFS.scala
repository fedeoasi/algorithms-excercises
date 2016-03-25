package com.github.fedeoasi.graphs

import scala.collection.mutable

class GraphDFS(graph: Graph, node: Int) {
  def dfs(): DFSResult = {
    val marked = Array.fill(graph.size)(false)
    var visited = List.empty[Int]
    val stack = new mutable.Stack[Int]()
    stack.push(node)
    while (stack.nonEmpty) {
      val curr = stack.pop()
      if (!marked(curr)) {
        marked(curr) = true
        visited ::= curr
        graph.adj(curr).foreach { n =>
          if (!marked(n)) {
            stack.push(n)
          }
        }
      }
    }
    DFSResult(marked, visited.reverse)
  }
}

case class DFSResult(marked: Seq[Boolean], nodes: Seq[Int])