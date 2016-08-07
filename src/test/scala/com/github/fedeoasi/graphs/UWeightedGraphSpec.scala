package com.github.fedeoasi.graphs

import org.scalatest.{FunSpec, Matchers}

class UWeightedGraphSpec extends FunSpec with Matchers {
  it("creates a new graph that has no edges") {
    val g = new UWeightedGraph(10)
    g.edgeSize shouldBe 0
    g.nodeSize shouldBe 10
  }

  it("adds an edge") {
    val g = new UWeightedGraph(10)
    val e1 = Edge(1, 2, 0.5)
    g.addEdge(e1)
    g.edgeSize shouldBe 1
    g.nodeSize shouldBe 10
    g.adj(0) shouldBe Seq.empty
    g.adj(1) shouldBe Seq(e1)
    g.adj(2) shouldBe Seq(e1)
  }

  it("does not add the same edge twice") {
    val g = new UWeightedGraph(10)
    val e1 = Edge(1, 2, 0.5)
    g.addEdge(e1)
    g.addEdge(e1)
    g.edgeSize shouldBe 1
    g.nodeSize shouldBe 10
    g.adj(0) shouldBe Seq.empty
    g.adj(1) shouldBe Seq(e1)
    g.adj(2) shouldBe Seq(e1)
  }

  it("returns the edges in the insertion order") {
    val g = new UWeightedGraph(10)
    val e1 = Edge(1, 2, 0.5)
    val e2 = Edge(1, 3, 0.6)
    val e3 = Edge(2, 3, 0.7)
    g.edgeSize shouldBe 3
    g.nodeSize shouldBe 10
    g.adj(1) shouldBe Seq(e1, e2)
    g.adj(2) shouldBe Seq(e1, e3)
    g.adj(3) shouldBe Seq(e2, e3)
  }
}
