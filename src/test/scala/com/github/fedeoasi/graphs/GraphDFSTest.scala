package com.github.fedeoasi.graphs

import org.scalatest.{Matchers, FunSpec}

class GraphDFSTest extends FunSpec with Matchers {
  it("traverses a simple undirected graph") {
    val g = Graph(5, 1 -> 3, 2 -> 4, 2 -> 3, 3 -> 4, 4 -> 0)
    val result = new GraphDFS(g, 1).dfs()
    result.nodes shouldBe Iterable(1, 3, 4, 0, 2)
  }
}
