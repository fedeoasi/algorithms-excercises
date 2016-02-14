package com.github.fedeoasi.connectivity

import org.scalatest.FunSpec
import org.scalatest.Matchers

class QuickFindSpec extends FunSpec with Matchers {
  describe("Quick Find") {
    it("should initialize to an array where the values are the indexes") {
      val qf = new QuickFind(5)
      qf.printArray() shouldBe "0 1 2 3 4"
    }

    it("nothing shouldBe connected in the initial state") {
      val qf = new QuickFind(5)
      qf.connected(0, 1) shouldBe false
      qf.connected(1, 2) shouldBe false
      qf.connected(2, 3) shouldBe false
      qf.connected(3, 4) shouldBe false
      qf.printArray() shouldBe "0 1 2 3 4"
    }

    it("should connect a component") {
      val qf = new QuickFind(5)
      qf.union(1, 3)
      qf.printArray() shouldBe "0 3 2 3 4"
      qf.connected(1, 3) shouldBe true
      qf.connected(0, 1) shouldBe false
      qf.connected(1, 2) shouldBe false
      qf.connected(2, 3) shouldBe false
      qf.connected(3, 4) shouldBe false
    }

    it("should respect the transitive property") {
      val qf = new QuickFind(5)
      qf.union(1, 3)
      qf.union(3, 4)
      qf.printArray() shouldBe "0 4 2 4 4"
      qf.connected(1, 3) shouldBe true
      qf.connected(3, 4) shouldBe true
      qf.connected(1, 4) shouldBe true
      qf.connected(0, 1) shouldBe false
      qf.connected(1, 2) shouldBe false
      qf.connected(2, 3) shouldBe false
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
