package com.github.fedeoasi.trees

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class TreeNodeSpec extends FunSpec with ShouldMatchers {
  it("should search in a single node") {
    val tree = new TreeNode[Int](3)
    assertSearch(tree, 4, false)
    assertSearch(tree, 3, true)
  }

  it("should search in a simple tree") {
    val tree = new TreeNode[Int](3)
    tree.setLeft(new TreeNode[Int](4))
    tree.setRight(new TreeNode[Int](5))
    assertSearch(tree, 1, false)
    assertSearch(tree, 3, true)
    assertSearch(tree, 4, true)
    assertSearch(tree, 5, true)
    assertSearch(tree, 6, false)
  }

  it("should search in a nested tree") {
    /*
               3
            4     5
         1     7    15
           12
    */

    val tree = new TreeNode[Int](3)
    val a = new TreeNode[Int](4)
    val b = new TreeNode[Int](5)
    val c = new TreeNode[Int](1)
    val d = new TreeNode[Int](7)
    val e = new TreeNode[Int](12)
    val f = new TreeNode[Int](15)
    tree.setLeft(a)
    tree.setRight(b)
    a.setLeft(c)
    b.setRight(d)
    b.setLeft(f)
    c.setLeft(e)

    assertSearch(tree, 1, true)
    assertSearch(tree, 2, false)
    assertSearch(tree, 3, true)
    assertSearch(tree, 4, true)
    assertSearch(tree, 5, true)
    assertSearch(tree, 6, false)
    assertSearch(tree, 7, true)
    assertSearch(tree, 8, false)
    assertSearch(tree, 15, true)
    assertSearch(tree, 20, false)
  }

  def assertSearch(tree: TreeNode[Int], value: Int, assertion: Boolean) {
    tree.depthFirstSearch(value) should be(assertion)
    tree.breadthFirstSearch(value) should be(assertion)
  }
}
