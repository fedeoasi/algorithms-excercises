package com.github.fedeoasi.arrays

import org.scalatest.{FunSpec, Matchers}

class StockBuyAndSellSpec extends FunSpec with Matchers {

  import StockBuyAndSell._

  it("buys and sells to maximize profit") {
    maxProfit(Array(7, 1, 5, 3, 6, 4)) shouldBe 5
  }

  it("does not buy when the price is monotonically decreasing") {
    maxProfit(Array(7, 6, 5, 4, 3, 1)) shouldBe 0
  }
}
