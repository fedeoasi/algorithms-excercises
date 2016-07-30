package com.github.fedeoasi.intervals

import org.scalatest.{FunSpec, Matchers}

class IntervalIntersectSpec extends FunSpec with Matchers {
  it("two non intersecting intervals") {
    val source = Seq(Interval(3, 5))
    val target = Seq(Interval(1, 2))
    new IntervalStrength(target, source).computeSolution shouldBe 0
  }

  it("two intersecting intervals") {
    val source = Seq(Interval(1, 5))
    val target = Seq(Interval(1, 2))
    new IntervalStrength(target, source).computeSolution shouldBe 1
  }

  it("computes the full solution") {
    val source = Seq(
      Interval(1, 5),
      Interval(2, 3),
      Interval(4, 7),
      Interval(5, 7)
    )
    val target = Seq(
      Interval(1, 2),
      Interval(2, 3),
      Interval(4, 5),
      Interval(6, 7)
    )
    new IntervalStrength(source, target).computeSolution shouldBe 9
  }
}
