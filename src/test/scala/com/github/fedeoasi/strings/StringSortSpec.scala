package com.github.fedeoasi.strings

import org.scalatest.FunSpec
import org.scalatest.Matchers

class StringSortSpec extends FunSpec with Matchers {
  import StringSort._

  describe("String sorting") {
    it("should sort an empty list") {
      sort("") shouldBe ""
    }

    it("should sort a single character") {
      sort("l") shouldBe "l"
    }

    it("should sort a simple word") {
      sort("home") shouldBe "ehmo"
    }

    it("should sort a word with duplicate letters") {
      sort("hello") shouldBe "ehllo"
    }

    it("should sort a word with numbers") {
      sort("hello123") shouldBe "123ehllo"
    }

    it("should sort a phrase with spaces") {
      sort("hello 123") shouldBe " 123ehllo"
    }
  }
}
