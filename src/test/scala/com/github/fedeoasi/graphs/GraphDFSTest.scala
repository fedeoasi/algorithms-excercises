package com.github.fedeoasi.graphs

import org.scalatest.{Matchers, FunSpec}

class GraphDFSTest extends FunSpec with Matchers {
  it("traverses a simple graph") {
    val g = new Graph(5)
    g.addEdge(1, 3)
    g.addEdge(2, 4)
    g.addEdge(2, 3)
    g.addEdge(3, 4)
    g.addEdge(4, 0)
    val result = new GraphDFS(g, 1).dfs()
    result.nodes shouldBe Iterable(1, 3, 4, 0, 2)
  }
}
