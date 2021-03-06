package com.github.fedeoasi.connectivity

import scala.annotation.tailrec

class DisjointSetImpl(n: Int) extends DisjointSet {
  private val a = (0 to n - 1).toArray
  private val size = (0 to n - 1).map(_ => 1).toArray

  override def union(p: Int, q: Int): Unit = {
    val pRoot = root(p)
    val qRoot = root(q)
    if (pRoot != qRoot) {
      if (size(pRoot) >= size(qRoot)) {
        a(qRoot) = pRoot
        size(pRoot) += size(qRoot)
      } else {
        a(pRoot) = qRoot
        size(qRoot) += size(pRoot)
      }
    }
  }

  override def connected(p: Int, q: Int): Boolean = {
    root(p) == root(q)
  }

  def componentSize(p: Int): Int = size(root(p))

  @tailrec
  private def root(x: Int): Int = {
    val parent = a(x)
    if (parent == x) {
      x
    } else {
      a(x) = a(parent)
      root(parent)
    }
  }

  private[connectivity] def printArray(): String = {
    a.mkString(" ")
  }
}
