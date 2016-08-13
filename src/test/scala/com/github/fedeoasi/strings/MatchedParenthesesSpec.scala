package com.github.fedeoasi.strings

import org.scalatest.{FunSpec, Matchers}

import com.github.fedeoasi.strings.MatchedParentheses._

class MatchedParenthesesSpec extends FunSpec with Matchers {
  it("handles an empty string") {
    matches("") shouldBe true
  }

  it("does not match a single paren") {
    matches("(") shouldBe false
  }

  it("matches an open-close") {
    matches("()") shouldBe true
  }

  it("matches a nested open-close") {
    matches("(())") shouldBe true
  }

  it("matches a nested open-close with extra characters") {
    matches("(,(.),)") shouldBe true
  }

  it("does not match a close-open") {
    matches(")(") shouldBe false
  }

  it("does not match am open-close-close") {
    matches("())") shouldBe false
  }
}
