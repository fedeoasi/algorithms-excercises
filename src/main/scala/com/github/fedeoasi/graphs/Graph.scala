package com.github.fedeoasi.graphs

class Graph(val size: Int) {
  require(size >= 0)

  private var edgeCount = 0

  private val adjacencyLists = Array.fill(size)(List.empty[Int])

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
    require(0 <= n && n < size)
  }
}
