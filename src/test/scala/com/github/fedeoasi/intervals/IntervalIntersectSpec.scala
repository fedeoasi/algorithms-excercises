package com.github.fedeoasi.intervals

import org.scalatest.{FunSpec, Matchers}

class IntervalIntersectSpec extends FunSpec with Matchers {
  it("single target does not intersect single source") {
    val source = Seq(Interval(1, 3, 5))
    val target = Seq(Interval(2, 1, 2))
    new IntervalStrength(target, source).computeSolution shouldBe 0
  }

  it("single target intersects single source") {
    val source = Seq(Interval(1, 1, 5))
    val target = Seq(Interval(2, 1, 2))
    new IntervalStrength(target, source).computeSolution shouldBe 1
  }

  describe("source has two intersecting intervals") {
    val source = Seq(Interval(1, 1, 5), Interval(2, 3, 7))

    it("target does not intersect with any") {
      new IntervalStrength(Seq(Interval(10, 0, 0)), source).computeSolution shouldBe 0
      new IntervalStrength(Seq(Interval(10, 8, 9)), source).computeSolution shouldBe 0
    }

    it("target is a subset of the second one") {
      new IntervalStrength(Seq(Interval(2, 6, 7)), source).computeSolution shouldBe 1
    }

    it("target is the same as the first one") {
      new IntervalStrength(Seq(Interval(2, 1, 5)), source).computeSolution shouldBe 2
    }

    it("target is both of them combined") {
      new IntervalStrength(Seq(Interval(2, 1, 7)), source).computeSolution shouldBe 2
    }

    it("target is the same as the second one") {
      new IntervalStrength(Seq(Interval(2, 3, 7)), source).computeSolution shouldBe 2
    }
  }



  it("computes the full solution") {
    val source = Seq(
      Interval(1, 1, 5),
      Interval(2, 2, 3),
      Interval(3, 4, 7),
      Interval(4, 5, 7)
    )
    val target = Seq(
      Interval(1, 1, 2),
      Interval(2, 2, 3),
      Interval(3, 4, 5),
      Interval(4, 6, 7)
    )
    new IntervalStrength(source, target).computeSolution shouldBe 9
  }
}
