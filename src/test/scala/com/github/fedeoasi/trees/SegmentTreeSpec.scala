package com.github.fedeoasi.trees

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class SegmentTreeSpec extends FunSpec with ShouldMatchers {
  describe("with a single element") {
    val tree = SegmentTree(Seq(1))

    it("returns the element as min when the interval contains it") {
      tree.min(0, 0) should be(Some(1))
      tree.min(0, 1) should be(Some(1))
    }

    it("returns None when the interval does not contain") {
      tree.min(1, 1) should be(None)
      tree.min(1, 3) should be(None)
    }
  }

  describe("with two elements in sorted order") {
    val tree = SegmentTree(Seq(1, 2))

    it("returns the global min") {
      tree.min(0, 1) should be(Some(1))
      tree.min(0, 2) should be(Some(1))
    }

    it("returns a leaf element") {
      tree.min(0, 0) should be(Some(1))
      tree.min(1, 1) should be(Some(2))
      tree.min(1, 2) should be(Some(2))
    }
  }

  describe("with two elements in reversed order") {
    val tree = SegmentTree(Seq(2, 1))

    it("returns the element in a certain position") {
      tree.min(0, 0) should be(Some(2))
      tree.min(1, 1) should be(Some(1))
    }

    it("returns the global min") {
      tree.min(0, 1) should be(Some(1))
      tree.min(0, 2) should be(Some(1))
    }
  }

  describe("with a complex example") {
    val tree = SegmentTree(Seq(10, 20, 30, 40, 11, 22, 33, 44, 15, 5))

    it("queries the tree") {
      tree.min(0, 5) should be(Some(10))
      tree.min(1, 2) should be(Some(20))
      tree.min(8, 9) should be(Some(5))
      tree.min(0, 9) should be(Some(5))
      tree.min(4, 6) should be(Some(11))
    }
  }
}
