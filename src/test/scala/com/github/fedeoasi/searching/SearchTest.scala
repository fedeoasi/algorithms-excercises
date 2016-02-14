package com.github.fedeoasi.searching

import org.scalatest.FunSpec
import org.scalatest.Matchers
import searching.Search

class SearchTest extends FunSpec with Matchers {
  val searcher = new Search[Integer]

  it("should not find an element in an empty array") {
    searcher.binarySearch(Array[Integer](), 1) shouldBe false
  }

  it("should search in a single element array") {
    val array = Array[Integer](2)
    searcher.binarySearch(array, 1) shouldBe false
    searcher.binarySearch(array, 2) shouldBe true
    searcher.binarySearch(array, 3) shouldBe false
  }

  it("should search in a sorted array with an even number of elements") {
    val array = Array[Integer](2, 3, 6, 8)
    searcher.binarySearch(array, 1) shouldBe false
    searcher.binarySearch(array, 2) shouldBe true
    searcher.binarySearch(array, 3) shouldBe true
    searcher.binarySearch(array, 5) shouldBe false
    searcher.binarySearch(array, 6) shouldBe true
    searcher.binarySearch(array, 7) shouldBe false
    searcher.binarySearch(array, 8) shouldBe true
    searcher.binarySearch(array, 9) shouldBe false
  }

  it("should search in a sorted array with an odd number of elements") {
    val array = Array[Integer](2, 3, 5, 6, 8)
    searcher.binarySearch(array, 1) shouldBe false
    searcher.binarySearch(array, 2) shouldBe true
    searcher.binarySearch(array, 3) shouldBe true
    searcher.binarySearch(array, 5) shouldBe true
    searcher.binarySearch(array, 6) shouldBe true
    searcher.binarySearch(array, 7) shouldBe false
    searcher.binarySearch(array, 8) shouldBe true
    searcher.binarySearch(array, 9) shouldBe false
  }

}
