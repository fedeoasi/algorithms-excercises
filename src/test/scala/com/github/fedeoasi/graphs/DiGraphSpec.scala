package com.github.fedeoasi.graphs

import org.scalatest.{FunSpec, Matchers}

class DiGraphSpec extends FunSpec with Matchers {
  it("creates a new graph that has no edges") {
    val g = DiGraph(10)
    g.edgeSize shouldBe 0
    g.nodeCount shouldBe 10
  }

  it("adds an edge") {
    val g = DiGraph(10, 1 -> 2)
    g.edgeSize shouldBe 1
    g.nodeCount shouldBe 10
    g.adj(0) shouldBe Seq.empty
    g.adj(1) shouldBe Seq(2)
    g.adj(2) shouldBe Seq.empty
  }

  it("does not add the same edge twice") {
    val g = DiGraph(10, 1 -> 2)
    g.addEdge(1, 2)
    g.edgeSize shouldBe 1
    g.nodeCount shouldBe 10
    g.adj(0) shouldBe Seq.empty
    g.adj(1) shouldBe Seq(2)
    g.adj(2) shouldBe Seq.empty
  }

  it("returns the edges in the insertion order") {
    val g = DiGraph(10, 1 -> 2, 1 -> 3, 2 -> 3)
    g.edgeSize shouldBe 3
    g.nodeCount shouldBe 10
    g.adj(1) shouldBe Seq(2, 3)
    g.adj(2) shouldBe Seq(3)
    g.adj(3) shouldBe Seq.empty
  }
}
