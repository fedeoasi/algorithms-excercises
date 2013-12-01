package com.github.fedeoasi.sorting

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import com.github.fedeoasi.sorting.ComparisonCountingSort

class CountingSortTest extends FunSpec with ShouldMatchers {
  import ComparisonCountingSort._

  it("should sort an empty array") {
    sort(Array()) should be(Array())
  }

  it("should sort a single element") {
    val array = Array(1)
    sort(array) should be(array)
  }

  it("should sort a simple array") {
    val array = Array(60, 35, 81, 98, 14, 47)
    sort(array) should be(Array(14, 35, 47, 60, 81, 98))
  }

  it("should sort an array with duplicates") {
    val array = Array(60, 35, 81, 81, 14, 47)
    sort(array) should be(Array(14, 35, 47, 60, 81, 81))
  }
}
