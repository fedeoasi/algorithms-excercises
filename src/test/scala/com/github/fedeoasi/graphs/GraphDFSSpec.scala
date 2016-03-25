package com.github.fedeoasi.graphs

import org.scalatest.{Matchers, FunSpec}

class GraphDFSSpec extends FunSpec with Matchers {
  it("traverses a simple undirected graph") {
    val g = UGraph(5, 1 -> 3, 2 -> 4, 2 -> 3, 3 -> 4, 4 -> 0)
    val result = new GraphDFS(g, 1).dfs()
    result.nodes shouldBe Iterable(1, 3, 4, 0, 2)
  }

  it("traverses a simple directed graph") {
    val g = DiGraph(5, 1 -> 3, 2 -> 4, 2 -> 3, 3 -> 4, 4 -> 0)
    val result = new GraphDFS(g, 1).dfs()
    result.nodes shouldBe Iterable(1, 3, 4, 0)
  }
}
