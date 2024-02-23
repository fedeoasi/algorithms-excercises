package com.github.fedeoasi.arrays

import org.scalatest.{FunSpec, Matchers}

class SortColorsSpec extends FunSpec with Matchers {

  import SortColors._

  it("leaves an already sorted array unchanged") {
    sortColors(Array(0, 0, 1, 2)) shouldBe Array(0, 0, 1, 2)
  }

  it("solves this case") {
    sortColors(Array(2, 0, 2, 1, 1, 0)) shouldBe Array(0, 0, 1, 1, 2, 2)
  }

  it("solves this case as well") {
    sortColors(Array(2, 0, 1)) shouldBe Array(0, 1, 2)
  }

  it("handles a larger array") {
    val array = Array(2, 1, 0, 1, 0, 0, 2, 2, 1, 1, 0, 2, 2, 1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0, 1, 2, 1, 2, 1, 1, 0, 0, 2, 2, 1, 0, 0, 1, 0, 1, 2, 1, 0, 2, 2, 2, 2, 0, 0, 2, 0, 2, 1, 0, 2, 2, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 1, 2, 0, 1, 0, 2, 0, 0, 1)
    sortColors(array) shouldBe array.sorted
  }
}
