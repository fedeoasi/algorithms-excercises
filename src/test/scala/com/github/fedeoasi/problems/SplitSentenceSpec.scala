package com.github.fedeoasi.problems

import org.scalatest.FunSpec
import org.scalatest.Matchers
import SplitSentenceScala._

class SplitSentenceSpec extends FunSpec with Matchers {
  describe("Split Sentence") {
    it("should return true for an empty sentence") {
      canSplit("") shouldBe true
    }

    it("should return false for a single word not in the vocabulary") {
      canSplit("ciao") shouldBe false
    }

    it("should return true for a single word in the vocabulary") {
      canSplit("hello") shouldBe true
    }

    it("should return true for a simple sentence") {
      canSplit("hello") shouldBe true
    }

    it("should return true for a more complex sentence") {
      canSplit("thissentenceisseparated") shouldBe true
    }
  }
}
