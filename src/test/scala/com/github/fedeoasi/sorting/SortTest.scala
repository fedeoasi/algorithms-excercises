package com.github.fedeoasi.sorting

import org.scalatest.FunSpec
import org.scalatest.Matchers

class SortTest extends FunSpec with Matchers {
  val compSort = new ComparisonCountingSort
  val mergeSort = new MergeSort

  def assertSorted(a: Array[Int], sorted: Array[Int]) = {
    compSort.sort(a) shouldBe sorted
    mergeSort.sort(a) shouldBe sorted
  }

  it("should sort an empty array") {
    assertSorted(Array(), Array())
  }

  it("should sort a single element") {
    val a = Array(1)
    assertSorted(a, a)
  }

  it("should sort a simple array") {
    val a = Array(60, 35, 81, 98, 14, 47)
    assertSorted(a, Array(14, 35, 47, 60, 81, 98))
  }

  it("should sort an array with duplicates") {
    val a = Array(60, 35, 81, 81, 14, 47)
    assertSorted(a, Array(14, 35, 47, 60, 81, 81))
  }
}
