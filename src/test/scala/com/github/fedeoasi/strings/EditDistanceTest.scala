package com.github.fedeoasi.strings

import org.scalatest.{FunSpec, Matchers}

class EditDistanceTest extends FunSpec with Matchers {
  import EditDistance._

  it("returns zero for two equal strings") {
    distance("hello", "hello") shouldBe 0
  }

  it("returns the length of the second string when the first one is empty") {
    distance("", "lake") shouldBe 4
  }

  it("returns the length of the first string when the second one is empty") {
    distance("lake", "") shouldBe 4
  }

  it("returns one when one character was changed") {
    distance("cake", "lake") shouldBe 1
  }

  it("uses deletions and substitutions") {
    distance("zeil", "trials") shouldBe 4
  }

  it("uses deletions, additions, and substitutions") {
    distance("intention", "execution") shouldBe 4
  }
}
