package com.github.fedeoasi.trees

trait SegmentTree {
  protected def low: Int
  protected def high: Int
  def min: Int

  def min(l: Int, h: Int): Option[Int]
}

object SegmentTree {
  def apply(numbers: Seq[Int]): SegmentTree = {
    require(numbers.nonEmpty)
    def build(low: Int, high: Int): SegmentTree = {
      if (low == high) {
        Leaf(low, numbers(low))
      } else {
        val n = (low + high) / 2
        val left = build(low, n)
        val right = build(n + 1, high)
        val min = math.min(left.min, right.min)
        new Node(low, high, min, left, right)
      }
    }
    build(0, numbers.size - 1)
  }

  class Leaf (val low: Int, val min: Int) extends SegmentTree {
    override protected def high: Int = low

    override def min(l: Int, h: Int): Option[Int] = {
      if(l <= low && h >= low) Some(min) else None
    }
  }

  object Leaf {
    def apply(low: Int, min: Int): Leaf = new Leaf(low, min)
  }


  case class Node(low: Int,
                  high: Int,
                  min: Int,
                  left: SegmentTree,
                  right: SegmentTree) extends SegmentTree {

    override def min(l: Int, h: Int): Option[Int] = {
      if (l > high || h < low) {
        None
      } else if (l <= low && h >= high) {
        Some(min)
      } else {
        val rightMin = right.min(l, h)
        val leftMin = left.min(l, h)
        (leftMin, rightMin) match {
          case (None, _) => rightMin
          case (_, None) => leftMin
          case (Some(lMin), Some(rMin)) => Some(Math.min(lMin, rMin))
        }
      }
    }
  }
}
