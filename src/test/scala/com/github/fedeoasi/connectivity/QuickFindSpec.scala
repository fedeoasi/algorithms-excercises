package com.github.fedeoasi.connectivity

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class QuickFindSpec extends FunSpec with ShouldMatchers {
  describe("Quick Find") {
    it("should initialize to an array where the values are the indexes") {
      val qf = new QuickFind(5)
      qf.printArray() should be("0 1 2 3 4")
    }

    it("nothing should be connected in the initial state") {
      val qf = new QuickFind(5)
      qf.connected(0, 1) should be(false)
      qf.connected(1, 2) should be(false)
      qf.connected(2, 3) should be(false)
      qf.connected(3, 4) should be(false)
      qf.printArray() should be("0 1 2 3 4")
    }

    it("should connect a component") {
      val qf = new QuickFind(5)
      qf.union(1, 3)
      qf.printArray() should be("0 3 2 3 4")
      qf.connected(1, 3) should be(true)
      qf.connected(0, 1) should be(false)
      qf.connected(1, 2) should be(false)
      qf.connected(2, 3) should be(false)
      qf.connected(3, 4) should be(false)
    }

    it("should respect the transitive property") {
      val qf = new QuickFind(5)
      qf.union(1, 3)
      qf.union(3, 4)
      qf.printArray() should be("0 4 2 4 4")
      qf.connected(1, 3) should be(true)
      qf.connected(3, 4) should be(true)
      qf.connected(1, 4) should be(true)
      qf.connected(0, 1) should be(false)
      qf.connected(1, 2) should be(false)
      qf.connected(2, 3) should be(false)
    }

    it("should union and print") {
      val qf = new QuickFind(10)
      unionAndPrint(qf, 3, 1)
      unionAndPrint(qf, 2, 0)
      unionAndPrint(qf, 4, 6)
      unionAndPrint(qf, 3, 4)
      unionAndPrint(qf, 4, 5)
      unionAndPrint(qf, 3, 7)
    }

    def unionAndPrint(qf: QuickFind, p: Int, q: Int) {
      qf.union(p, q)
      println(qf.printArray())
    }
  }
}
