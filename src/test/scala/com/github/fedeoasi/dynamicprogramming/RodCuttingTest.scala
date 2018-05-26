package com.github.fedeoasi.dynamicprogramming

import org.scalatest.{FunSpec, Matchers}

class RodCuttingTest extends FunSpec with Matchers {
  private val weights = Seq(1, 5, 8, 9, 10, 17, 20, 24, 30)
  private val rodCutting = new RodCutting(weights)

  it("handles the base case of one") {
    rodCutting.optimalCost(1) shouldBe 1
  }

  it("handles two by using a rod of length two") {
    rodCutting.optimalCost(2) shouldBe 5
  }

  it("handles three by using a rod of length three") {
    rodCutting.optimalCost(3) shouldBe 8
  }

  it("handles four by using two rods of length two") {
    rodCutting.optimalCost(4) shouldBe 10
  }

  it("handles five by using two rods of length two and three respectively") {
    rodCutting.optimalCost(5) shouldBe 13
  }
}
