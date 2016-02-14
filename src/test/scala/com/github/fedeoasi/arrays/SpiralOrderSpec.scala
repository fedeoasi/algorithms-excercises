package com.github.fedeoasi.arrays

import org.scalatest.FunSpec
import org.scalatest.Matchers
import MatrixSpiralOrder._

class SpiralOrderSpec extends FunSpec with Matchers {
  describe("Spiral Order") {
    it("should traverse an empty matrix") {
      spiralOrder(Array()) shouldBe Array()
    }

    it("should traverse a single element") {
      spiralOrder(Array(Array(1))) shouldBe Array(1)
    }

    it("should traverse a 2x2") {
      spiralOrder(Array(Array(1, 2), Array(4, 3))) shouldBe(
        1 to 4 toArray
      )
    }

    it("should traverse a 3x3") {
      spiralOrder(Array(
        Array(1, 2, 3),
        Array(8, 9, 4),
        Array(7, 6, 5))) shouldBe(
        1 to 9 toArray
      )
    }

    it("should traverse a 4x4") {
      spiralOrder(Array(
        Array(1,   2,  3,  4),
        Array(12, 13, 14,  5),
        Array(11, 16, 15,  6),
        Array(10,  9,  8,  7))) shouldBe(
        1 to 16 toArray
      )
    }

    it("should traverse a 5x5") {
      spiralOrder(Array(
        Array(1,   2,   3,   4,  5),
        Array(16, 17,  18,  19,  6),
        Array(15, 24,  25,  20,  7),
        Array(14, 23,  22,  21,  8),
        Array(13, 12,  11,  10,  9))) shouldBe(
        1 to 25 toArray
      )
    }
  }
}
