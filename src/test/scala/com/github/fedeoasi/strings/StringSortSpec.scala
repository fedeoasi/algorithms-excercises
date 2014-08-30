package com.github.fedeoasi.strings

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class StringSortSpec extends FunSpec with ShouldMatchers {
  import StringSort._

  describe("String sorting") {
    it("should sort an empty list") {
      sort("") should be("")
    }

    it("should sort a single character") {
      sort("l") should be("l")
    }

    it("should sort a simple word") {
      sort("home") should be("ehmo")
    }

    it("should sort a word with duplicate letters") {
      sort("hello") should be("ehllo")
    }

    it("should sort a word with numbers") {
      sort("hello123") should be("123ehllo")
    }

    it("should sort a phrase with spaces") {
      sort("hello 123") should be(" 123ehllo")
    }
  }
}
