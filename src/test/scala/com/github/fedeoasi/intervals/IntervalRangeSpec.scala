package com.github.fedeoasi.intervals

import org.scalatest.FunSpec
import org.scalatest.Matchers

class IntervalRangeSpec extends FunSpec with Matchers {
  describe("IntervalRange") {
    it("should have range zero by default") {
      val range = new IntervalRangeImpl
      range.range() shouldBe 0
    }

    it("should have the range of a single element") {
      val range = new IntervalRangeImpl
      range.add(1, 2)
      range.range() shouldBe 1
    }

    it("should sum the range of non intersecting intervals") {
      val range = new IntervalRangeImpl
      range.add(1, 2)
      range.add(3, 5)
      range.range() shouldBe 3
    }

    it("should handle two intersecting intervals") {
      val range = new IntervalRangeImpl
      range.add(1, 3)
      range.add(2, 4)
      range.range() shouldBe 3
    }

    it("should handle intersecting and non-intersecting intervals") {
      val range = new IntervalRangeImpl
      range.add(1, 3)
      range.add(2, 5)
      range.add(8, 9)
      range.range() shouldBe 5
    }

    it("should handle multiple intersecting intervals") {
      val range = new IntervalRangeImpl
      range.add(1, 2)
      range.add(1, 3)
      range.add(1, 4)
      range.add(1, 5)
      range.range() shouldBe 4
    }
  }
}
