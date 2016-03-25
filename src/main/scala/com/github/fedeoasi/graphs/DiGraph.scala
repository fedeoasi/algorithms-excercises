package com.github.fedeoasi.graphs

class DiGraph(val nodeCount: Int) {
  require(nodeCount >= 0)

  private var edgeCount = 0

  private val adjacencyLists = Array.fill(nodeCount)(List.empty[Int])

  def addEdge(from: Int, to: Int): Unit = {
    validateNode(from)
    validateNode(to)
    if (!adjacencyLists(from).contains(to)) {
      adjacencyLists(from) ::= to
      edgeCount += 1
    }
  }

  def adj(i: Int): Iterable[Int] = {
    adjacencyLists(i).reverse
  }

  def edgeSize: Int = edgeCount

  private def validateNode(n: Int) = {
    require(0 <= n && n < nodeCount)
  }
}

object DiGraph {
  def apply(size: Int, edges: (Int, Int)*): DiGraph = {
    val g = new DiGraph(size)
    edges.foreach { case (from, to) => g.addEdge(from, to) }
    g
  }
}