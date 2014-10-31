package com.github.fedeoasi.trees

object Reconstruct {
  def fromTraversals[T](inOrder: List[T], preOrder: List[T]): TreeNode[T] = {
    preOrder.headOption.map { rootValue =>
      val root = new TreeNode(rootValue)
      val leftInOrder = inOrder.takeWhile(_ != rootValue)
      val leftTreeSize = leftInOrder.size
      val rightInOrder = inOrder.drop(leftTreeSize + 1)
      val leftPreOrder = preOrder.tail.take(leftTreeSize)
      val rightPreOrder = preOrder.drop(leftTreeSize + 1)
      root.setLeft(fromTraversals(leftInOrder, leftPreOrder))
      root.setRight(fromTraversals(rightInOrder, rightPreOrder))
      root
    }.getOrElse(null)
  }
}
