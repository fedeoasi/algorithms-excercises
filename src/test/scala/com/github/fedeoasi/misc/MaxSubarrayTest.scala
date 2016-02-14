package com.github.fedeoasi.misc

import org.scalatest.FunSpec
import org.scalatest.Matchers

class MaxSubarrayTest extends FunSpec with Matchers {
  import MaxSubarray._

  it("should return an empty array when the array is empty") {
    findMaxSubarray(Array()) shouldBe Array()
  }

  it("should return an empty array when all the numbers are negative") {
    findMaxSubarray(Array(-1, -2, -3)) shouldBe Array()
  }

  it("should return a single element when the array is a single positive element") {
    findMaxSubarray(Array(1)) shouldBe Array(1)
  }

  it("should return the correct sub-array for a heterogeneous array") {
    findMaxSubarray(Array(-2, 1, -3, 4, -1, 2, 1, -5, 4)) shouldBe Array(4, -1, 2, 1)
  }
}
