package com.github.fedeoasi.arrays

import org.scalatest.{FunSpec, Matchers}

class MinimumWindowSubstringSpec extends FunSpec with Matchers {
  import MinimumWindowSubstring._

  it("returns empty string when one of the strings is empty") {
    minWindow("", "a") shouldBe ""
  }

  it("returns empty string it cannot find a window containing all characters from the second string") {
    minWindow("aa", "a") shouldBe "a"
  }

  it("finds the minimum window when it is at the end") {
    minWindow("ADOBECODEBANC", "ABC") shouldBe "BANC"
  }

  it("finds the minimum window when it is not at the end") {
    minWindow("ADOBECODEBANCA", "ABC") shouldBe "BANC"
  }

  it("handles this case") {
    val s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ"
    minWindow(s, "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ") shouldBe "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ"
  }
}
