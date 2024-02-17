package com.github.fedeoasi

import org.scalatest.{FunSpec, Matchers}

class LongestSubstringWithoutRepeatingCharactersSpec extends FunSpec with Matchers {

  import LongestSubstringWithoutRepeatingCharacters._

  it("handles an empty sequence") {
    substring(Array.empty[Int]) shouldBe None
  }

  it("handles a sequence with one character sequence") {
    substring(Array(1)).map(_.toSeq) shouldBe Some(Seq(1))
  }

  it("handles a sequence with no repeating characters") {
    substring(Array(1, 2, 3)).map(_.toSeq) shouldBe Some(Seq(1, 2, 3))
  }

  it("handles a sequence with repeating characters where the best is at the end") {
    substring(Array(1, 2, 3, 2, 3, 5, 6)).map(_.toSeq) shouldBe Some(Seq(2, 3, 5, 6))
  }

  it("handles a sequence with repeating characters where the best is at the beginning") {
    substring(Array(2, 3, 5, 6, 1, 2, 3, 4)).map(_.toSeq) shouldBe Some(Seq(2, 3, 5, 6, 1))
  }
}
