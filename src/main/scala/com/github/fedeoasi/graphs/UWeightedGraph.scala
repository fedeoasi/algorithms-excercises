package com.github.fedeoasi.graphs

case class Edge(v: Int, w: Int, weight: Double) {
  def nodePair: (Int, Int) = (v, w)
}

class UWeightedGraph(val nodeSize: Int) {
  var edgeCount = 0

  private var edgesByNodePair = Map.empty[(Int, Int), Edge]

  private val adjacencyLists = Array.fill(nodeSize) {
    List.empty[Edge]
  }

  def edgeSize: Int = edgeCount

  def addEdge(e: Edge): Unit = {
    if (!edgesByNodePair.contains(e.nodePair)) {
      edgeCount += 1
      adjacencyLists(e.v) ::= e
      adjacencyLists(e.w) ::= e
      edgesByNodePair = edgesByNodePair.updated(e.nodePair, e)
    }
  }

  def adj(i : Int): Iterable[Edge] = {
    adjacencyLists(i)
  }
}