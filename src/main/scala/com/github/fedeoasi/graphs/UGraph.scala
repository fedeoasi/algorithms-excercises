package com.github.fedeoasi.graphs

trait UGraph extends Graph

object UGraph {
  def apply(size: Int, edges: (Int, Int)*): UGraph = {
    val g = new UGraphImpl(size)
    edges.foreach { case (from, to) => g.addEdge(from, to) }
    g
  }
}

private[graphs] class UGraphImpl(val nodeSize: Int) extends UGraph {
  require(nodeSize >= 0)

  private var edgeCount = 0

  private val adjacencyLists = Array.fill(nodeSize)(List.empty[Int])

  def addEdge(from: Int, to: Int): Unit = {
    validateNode(from)
    validateNode(to)
    if (!adjacencyLists(from).contains(to)) {
      adjacencyLists(from) ::= to
      adjacencyLists(to) ::= from
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