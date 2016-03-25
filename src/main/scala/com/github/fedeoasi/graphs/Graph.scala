package com.github.fedeoasi.graphs

trait Graph {
  def nodeSize: Int
  def edgeSize: Int
  def addEdge(from: Int, to: Int): Unit
  def adj(i : Int): Iterable[Int]
}
