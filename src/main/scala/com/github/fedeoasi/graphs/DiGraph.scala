package com.github.fedeoasi.graphs

trait DiGraph extends Graph

object DiGraph {
  def apply(size: Int, edges: (Int, Int)*): DiGraph = {
    val g = new DiGraphImpl(size)
    edges.foreach { case (from, to) => g.addEdge(from, to) }
    g
  }
}

class DiGraphImpl(val nodeSize: Int) extends DiGraph {
  require(nodeSize >= 0)

  private var edgeCount = 0

  private val adjacencyLists = Array.fill(nodeSize)(List.empty[Int])

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
    require(0 <= n && n < nodeSize)
  }
}
