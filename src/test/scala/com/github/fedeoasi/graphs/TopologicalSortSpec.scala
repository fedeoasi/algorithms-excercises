package com.github.fedeoasi.graphs

import org.scalatest.{Matchers, FunSpec}

class TopologicalSortSpec extends FunSpec with Matchers {
  it("sorts a an empty graph") {
    new TopologicalSort(DiGraph(0)).sort() shouldBe Iterable.empty[Int]
  }

  it("sorts a single node") {
    new TopologicalSort(DiGraph(1)).sort() shouldBe Iterable(0)
  }

  it("sorts two connected nodes") {
    val g = DiGraph(2, 0 -> 1)
    new TopologicalSort(g).sort() shouldBe Iterable(0, 1)
  }

  it("sorts three connected nodes") {
    val g = DiGraph(3, 0 -> 1 , 1 -> 2)
    new TopologicalSort(g).sort() shouldBe Iterable(0, 1, 2)
  }

  it("sorts three nodes forming a binary tree") {
    val g = DiGraph(3, 0 -> 1, 0 -> 2)
    new TopologicalSort(g).sort() shouldBe Iterable(0, 2, 1)
  }

  it("sorts a more complicated graph") {
    val g = DiGraph(7, 0 -> 1, 0 -> 4, 1 -> 2, 1 -> 3, 4 -> 5, 3 -> 6, 5 -> 6)
    new TopologicalSort(g).sort() shouldBe Iterable(0, 4, 5, 1, 3, 6, 2)
  }
}
