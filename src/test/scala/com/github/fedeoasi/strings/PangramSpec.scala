package com.github.fedeoasi.strings

import org.scalatest.FunSpec
import org.scalatest.Matchers

class PangramSpec extends FunSpec with Matchers {
  describe("Pangram recognition") {
    it("should recognize a pangram") {
      val s = "The quick brown fox jumps over the lazy dog"
      Pangrams.isPangram(s) shouldBe(right = true)
    }

    it("should recognize another pangram with uppercase letters") {
      val s = "We promptly judged antique ivory buckles for the next prize"
      Pangrams.isPangram(s) shouldBe(right = true)
    }

    it("should not recognize a non pangram") {
      val s = "The quick brown fox jumps over the lazy"
      Pangrams.isPangram(s) shouldBe(right = false)
    }

    it("should not recognize another non pangram") {
      val s = "The quick brown jumps over the lazy dog"
      Pangrams.isPangram(s) shouldBe(right = false)
    }
  }
}
