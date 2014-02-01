package com.github.fedeoasi.connectivity

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class QuickUnionSpec extends FunSpec with ShouldMatchers {
  describe("Weighted Quick Union") {
    it("should initialize to an array where the values are the indexes") {
      val qu = new QuickUnion(5)
      qu.printArray() should be("0 1 2 3 4")
    }

    it("nothing should be connected in the initial state") {
      val qu = new QuickUnion(5)
      qu.connected(0, 1) should be(false)
      qu.connected(1, 2) should be(false)
      qu.connected(2, 3) should be(false)
      qu.connected(3, 4) should be(false)
      qu.printArray() should be("0 1 2 3 4")
    }

    it("should connect a component") {
      val qu = new QuickUnion(5)
      qu.union(1, 3)
      qu.printArray() should be("0 3 2 3 4")
      qu.connected(1, 3) should be(true)
      qu.connected(0, 1) should be(false)
      qu.connected(1, 2) should be(false)
      qu.connected(2, 3) should be(false)
      qu.connected(3, 4) should be(false)
    }

    it("should respect the transitive property") {
      val qu = new QuickUnion(5)
      qu.union(1, 3)
      qu.union(3, 4)
      qu.printArray() should be("0 3 2 4 4")
      qu.connected(1, 3) should be(true)
      qu.connected(3, 4) should be(true)
      qu.connected(1, 4) should be(true)
      qu.connected(0, 1) should be(false)
      qu.connected(1, 2) should be(false)
      qu.connected(2, 3) should be(false)
    }

    it("should connect two subtrees") {
      val qu = new QuickUnion(5)
      qu.union(1, 3)
      qu.union(3, 4)
      qu.union(0, 2)
      qu.union(1, 2)
      qu.connected(0, 1) should be(true)
      qu.connected(1, 2) should be(true)
      qu.connected(2, 3) should be(true)
      qu.connected(3, 4) should be(true)
      qu.connected(0, 2) should be(true)
      qu.connected(0, 3) should be(true)
      qu.connected(0, 4) should be(true)
      qu.connected(1, 3) should be(true)
      qu.connected(1, 4) should be(true)
      qu.connected(2, 4) should be(true)
      qu.printArray() should be("2 3 2 4 2")
    }

    it("should union and print") {
      val qu = new QuickUnion(10)
      unionAndPrint(qu, 3, 1)
      unionAndPrint(qu, 2, 0)
      unionAndPrint(qu, 4, 6)
      unionAndPrint(qu, 3, 4)
      unionAndPrint(qu, 6, 7)
    }

    def unionAndPrint(qu: QuickUnion, p: Int, q: Int) {
      qu.union(p, q)
      println(qu.printArray())
    }
  }
}
