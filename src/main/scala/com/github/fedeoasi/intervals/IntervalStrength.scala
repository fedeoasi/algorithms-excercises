package com.github.fedeoasi.intervals

case class Interval(a: Int, b: Int) {
  def intersects(other: Interval): Boolean = {
    other.a >= a && other.a <= b ||
      other.b >= a && other.b <= b
  }
}

class IntervalStrength(source: Seq[Interval], target: Seq[Interval]) {
  def computeSolution: Int = {
    source.map { s =>
      strengthFor(s)
    }.sum
  }

  def strengthFor(s: Interval): Int = {
    target.map { t =>
      println(s"$s $t ${s.intersects(t)}")
      if (s.intersects(t)) 1 else 0
    }.sum
  }
}

