package com.github.fedeoasi.trees

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import Reconstruct._

class ReconstructSpec extends FunSpec with ShouldMatchers {
  describe("Build Tree from in-order and pre-order traversals") {
    it("empty traversals") {
      fromTraversals(List(), List()) should be(null)
    }

    it("single node") {
      val tree = fromTraversals(List("A"), List("A"))
      tree.getValue should be("A")
      tree.getLeft should be(null)
      tree.getRight should be(null)
    }

    it("complex example") {
      val tree = fromTraversals(
        List("F", "B", "A", "E", "H", "C", "D", "I", "G"),
        List("H", "B", "F", "E", "A", "C", "D", "G", "I")
      )
      val (b, c) = assertValue(tree, "H")
      val (f, e) = assertValue(b, "B")
      val (c1, d) = assertValue(c, "C")
      c1 should be(null)
      val (f1, f2) = assertValue(f, "F")
      val (a, e2) = assertValue(e, "E")
      val (a1, a2) = assertValue(a, "A")
      val (d1, g) = assertValue(d, "D")
      val (i, g2) = assertValue(g, "G")
      val (i1, i2) = assertValue(i, "I")
      val nullNodes = Seq(c1, f1, f2, e2, a1, a2, d1, g2, i1, i2)
      nullNodes.foreach(_ should be(null))
    }
  }

  def assertValue[T](node: TreeNode[T], value: T): (TreeNode[T], TreeNode[T]) = {
    node.getValue should be(value)
    (node.getLeft, node.getRight)
  }
}
