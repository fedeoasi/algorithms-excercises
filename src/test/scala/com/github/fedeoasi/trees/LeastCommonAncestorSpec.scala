package com.github.fedeoasi.trees

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import LeastCommonAncestor._

class LeastCommonAncestorSpec extends FunSpec with ShouldMatchers {
  describe("LeastCommonAncestor") {
    it("should find the root as common ancestor in a simple tree") {
      val root = new TreeNode(2)
      val left = new TreeNode(1)
      val right = new TreeNode(3)
      root.setLeft(left)
      root.setRight(right)
      leastCommonAncestor(root, left) should be (root)
      leastCommonAncestor(right, left) should be (root)
      leastCommonAncestor(root, right) should be (root)
      leastCommonAncestor(left, root) should be (root)
      leastCommonAncestor(left, right) should be (root)
      leastCommonAncestor(right, root) should be (root)
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
      leastCommonAncestor(two, four) should be (three)
      leastCommonAncestor(six, four) should be (five)
      leastCommonAncestor(eight, eleven) should be (eight)
      leastCommonAncestor(ten, eleven) should be (ten)
      leastCommonAncestor(one, ten) should be (five)
    }
  }
}
