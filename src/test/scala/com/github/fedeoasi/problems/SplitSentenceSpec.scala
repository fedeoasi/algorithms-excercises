package com.github.fedeoasi.problems

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import SplitSentenceScala._

class SplitSentenceSpec extends FunSpec with ShouldMatchers {
  describe("Split Sentence") {
    it("should return true for an empty sentence") {
      canSplit("") should be(true)
    }

    it("should return false for a single word not in the vocabulary") {
      canSplit("ciao") should be(false)
    }

    it("should return true for a single word in the vocabulary") {
      canSplit("hello") should be(true)
    }

    it("should return true for a simple sentence") {
      canSplit("hello") should be(true)
    }

    it("should return true for a more complex sentence") {
      canSplit("thissentenceisseparated") should be(true)
    }
  }
}
