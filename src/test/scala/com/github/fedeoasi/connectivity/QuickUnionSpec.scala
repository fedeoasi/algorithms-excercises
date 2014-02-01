package com.github.fedeoasi.connectivity

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class QuickUnionSpec extends FunSpec with ShouldMatchers {
  describe("Weighted Quick Union") {
    it("should initialize to an array where the values are the indexes") {
      val wqu = new QuickUnion(5)
      wqu.printArray() should be("0 1 2 3 4")
    }

    it("nothing should be connected in the initial state") {
      val wqu = new QuickUnion(5)
      wqu.connected(0, 1) should be(false)
      wqu.connected(1, 2) should be(false)
      wqu.connected(2, 3) should be(false)
      wqu.connected(3, 4) should be(false)
      wqu.printArray() should be("0 1 2 3 4")
    }

    it("should connect a component") {
      val wqu = new QuickUnion(5)
      wqu.union(1, 3)
      wqu.printArray() should be("0 3 2 3 4")
      wqu.connected(1, 3) should be(true)
      wqu.connected(0, 1) should be(false)
      wqu.connected(1, 2) should be(false)
      wqu.connected(2, 3) should be(false)
      wqu.connected(3, 4) should be(false)
    }

    it("should respect the transitive property") {
      val wqu = new QuickUnion(5)
      wqu.union(1, 3)
      wqu.union(3, 4)
      wqu.printArray() should be("0 3 2 4 4")
      wqu.connected(1, 3) should be(true)
      wqu.connected(3, 4) should be(true)
      wqu.connected(1, 4) should be(true)
      wqu.connected(0, 1) should be(false)
      wqu.connected(1, 2) should be(false)
      wqu.connected(2, 3) should be(false)
    }

    it("should connect two subtrees") {
      val wqu = new QuickUnion(5)
      wqu.union(1, 3)
      wqu.union(3, 4)
      wqu.union(0, 2)
      wqu.union(1, 2)
      wqu.connected(0, 1) should be(true)
      wqu.connected(1, 2) should be(true)
      wqu.connected(2, 3) should be(true)
      wqu.connected(3, 4) should be(true)
      wqu.connected(0, 2) should be(true)
      wqu.connected(0, 3) should be(true)
      wqu.connected(0, 4) should be(true)
      wqu.connected(1, 3) should be(true)
      wqu.connected(1, 4) should be(true)
      wqu.connected(2, 4) should be(true)
      wqu.printArray() should be("2 3 2 4 2")
    }

    it("should union and print") {
      val wqu = new QuickUnion(10)
      unionAndPrint(wqu, 3, 1)
      unionAndPrint(wqu, 2, 0)
      unionAndPrint(wqu, 4, 6)
      unionAndPrint(wqu, 3, 4)
      unionAndPrint(wqu, 4, 5)
      unionAndPrint(wqu, 3, 7)
    }

    def unionAndPrint(wqu: QuickUnion, p: Int, q: Int) {
      wqu.union(p, q)
      println(wqu.printArray())
    }
  }
}
