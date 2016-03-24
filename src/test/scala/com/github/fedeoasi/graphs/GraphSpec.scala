package com.github.fedeoasi.graphs

import org.scalatest.{Matchers, FunSpec}

class GraphSpec extends FunSpec with Matchers {
  it("creates a new graph that has no edges") {
    val g = new Graph(10)
    g.edgeSize shouldBe 0
    g.size shouldBe 10
  }

  it("adds an edge") {
    val g = new Graph(10)
    g.addEdge(1, 2)
    g.edgeSize shouldBe 1
    g.size shouldBe 10
    g.adj(0) shouldBe Seq.empty
    g.adj(1) shouldBe Seq(2)
    g.adj(2) shouldBe Seq(1)
  }

  it("does not add the same edge twice") {
    val g = new Graph(10)
    g.addEdge(1, 2)
    g.addEdge(1, 2)
    g.edgeSize shouldBe 1
    g.size shouldBe 10
    g.adj(0) shouldBe Seq.empty
    g.adj(1) shouldBe Seq(2)
    g.adj(2) shouldBe Seq(1)
  }

  it("returns the edges in the insertion order") {
    val g = new Graph(10)
    g.addEdge(1, 2)
    g.addEdge(1, 3)
    g.addEdge(2, 3)
    g.edgeSize shouldBe 3
    g.size shouldBe 10
    g.adj(1) shouldBe Seq(2, 3)
    g.adj(2) shouldBe Seq(1, 3)
    g.adj(3) shouldBe Seq(1, 2)
  }
}
