package com.github.fedeoasi.connectivity

import org.scalatest.FunSpec
import org.scalatest.Matchers

class QuickUnionSpec extends FunSpec with Matchers {
  describe("Weighted Quick Union") {
    it("should initialize to an array where the values are the indexes") {
      val qu = new QuickUnion(5)
      qu.printArray() shouldBe "0 1 2 3 4"
    }

    it("nothing shouldBe connected in the initial state") {
      val qu = new QuickUnion(5)
      qu.connected(0, 1) shouldBe false
      qu.connected(1, 2) shouldBe false
      qu.connected(2, 3) shouldBe false
      qu.connected(3, 4) shouldBe false
      qu.printArray() shouldBe "0 1 2 3 4"
    }

    it("should connect a component") {
      val qu = new QuickUnion(5)
      qu.union(1, 3)
      qu.printArray() shouldBe "0 3 2 3 4"
      qu.connected(1, 3) shouldBe true
      qu.connected(0, 1) shouldBe false
      qu.connected(1, 2) shouldBe false
      qu.connected(2, 3) shouldBe false
      qu.connected(3, 4) shouldBe false
    }

    it("should respect the transitive property") {
      val qu = new QuickUnion(5)
      qu.union(1, 3)
      qu.union(3, 4)
      qu.printArray() shouldBe "0 3 2 4 4"
      qu.connected(1, 3) shouldBe true
      qu.connected(3, 4) shouldBe true
      qu.connected(1, 4) shouldBe true
      qu.connected(0, 1) shouldBe false
      qu.connected(1, 2) shouldBe false
      qu.connected(2, 3) shouldBe false
    }

    it("should connect two subtrees") {
      val qu = new QuickUnion(5)
      qu.union(1, 3)
      qu.union(3, 4)
      qu.union(0, 2)
      qu.union(1, 2)
      qu.connected(0, 1) shouldBe true
      qu.connected(1, 2) shouldBe true
      qu.connected(2, 3) shouldBe true
      qu.connected(3, 4) shouldBe true
      qu.connected(0, 2) shouldBe true
      qu.connected(0, 3) shouldBe true
      qu.connected(0, 4) shouldBe true
      qu.connected(1, 3) shouldBe true
      qu.connected(1, 4) shouldBe true
      qu.connected(2, 4) shouldBe true
      qu.printArray() shouldBe "2 3 2 4 2"
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
