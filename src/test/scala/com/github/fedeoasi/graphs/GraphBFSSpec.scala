package com.github.fedeoasi.graphs

import org.scalatest.{FunSpec, Matchers}

class GraphBFSSpec extends FunSpec with Matchers {
  it("traverses a simple undirected graph") {
    val g = UGraph(5, 1 -> 3, 2 -> 4, 2 -> 3, 3 -> 4, 4 -> 0)
    val result = new GraphBFS(g, 1).bfs()
    result.nodes shouldBe Iterable(1, 3, 2, 4, 0)
    result.distTo shouldBe Iterable(Some(3), Some(0), Some(2), Some(1), Some(2))
  }

  it("traverses a simple directed graph") {
    val g = DiGraph(5, 1 -> 3, 2 -> 4, 2 -> 3, 3 -> 4, 4 -> 0)
    val result = new GraphBFS(g, 1).bfs()
    result.nodes shouldBe Iterable(1, 3, 4, 0)
    result.distTo shouldBe Iterable(Some(3), Some(0), None, Some(1), Some(2))
  }
}
