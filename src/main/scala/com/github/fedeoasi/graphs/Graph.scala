package com.github.fedeoasi.graphs

trait Graph {
  def nodeSize: Int
  def edgeSize: Int
  def addEdge(from: Int, to: Int): Unit
  def adj(i : Int): Iterable[Int]
}

object Graph {
  def apply(size: Int, edges: (Int, Int)*): Graph = {
    val g = new GraphImpl(size)
    edges.foreach { case (from, to) => g.addEdge(from, to) }
    g
  }
}

private[graphs] class GraphImpl(val nodeSize: Int) extends Graph {
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