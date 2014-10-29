package com.github.fedeoasi.arrays

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import MatrixSpiralOrder._

class SpiralOrderSpec extends FunSpec with ShouldMatchers {
  describe("Spiral Order") {
    it("should traverse an empty matrix") {
      spiralOrder(Array()) should be(Array())
    }

    it("should traverse a single element") {
      spiralOrder(Array(Array(1))) should be(Array(1))
    }

    it("should traverse a 2x2") {
      spiralOrder(Array(Array(1, 2), Array(4, 3))) should be(
        1 to 4 toArray
      )
    }

    it("should traverse a 3x3") {
      spiralOrder(Array(
        Array(1, 2, 3),
        Array(8, 9, 4),
        Array(7, 6, 5))) should be(
        1 to 9 toArray
      )
    }
  }
}
