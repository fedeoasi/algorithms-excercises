package com.github.fedeoasi.trees

import org.scalatest.FunSpec
import org.scalatest.Matchers
import LowestCommonAncestor._

class LowestCommonAncestorSpec extends FunSpec with Matchers {
  describe("LeastCommonAncestor") {
    it("should find the root as common ancestor in a simple tree") {
      val root = new TreeNode(2)
      val left = new TreeNode(1)
      val right = new TreeNode(3)
      root.setLeft(left)
      root.setRight(right)
      leastCommonAncestor(root, left) shouldBe root
      leastCommonAncestor(right, left) shouldBe root
      leastCommonAncestor(root, right) shouldBe root
      leastCommonAncestor(left, root) shouldBe root
      leastCommonAncestor(left, right) shouldBe root
      leastCommonAncestor(right, root) shouldBe root
    }

    it("should find the common ancestor in a complicated tree") {
      /*
                   5
               3       8
            1    4   6   10
             2             11
       */

      val one = new TreeNode(1)
      val two = new TreeNode(2)
      val three = new TreeNode(3)
      val four = new TreeNode(4)
      val five = new TreeNode(5)
      val six = new TreeNode(6)
      val eight = new TreeNode(8)
      val ten = new TreeNode(10)
      val eleven = new TreeNode(11)
      five.setLeft(three)
      five.setRight(eight)
      three.setLeft(one)
      three.setRight(four)
      one.setRight(two)
      eight.setLeft(six)
      eight.setRight(ten)
      ten.setRight(eleven)
      leastCommonAncestor(two, four) shouldBe three
      leastCommonAncestor(six, four) shouldBe five
      leastCommonAncestor(eight, eleven) shouldBe eight
      leastCommonAncestor(ten, eleven) shouldBe ten
      leastCommonAncestor(one, ten) shouldBe five
    }
  }
}
