package com.github.fedeoasi.arrays

object StockBuyAndSell {
  def maxProfit(prices: Array[Int]): Int = {

    val initialValue = (0, Int.MaxValue)
    val (result, _) = prices.indices.foldLeft(initialValue) {
      case ((best, currentMin), i) =>
        val value = prices(i)
        val newBest = if (value - currentMin > best) value - currentMin else best
        val newMin = if (value < currentMin) value else currentMin
        (newBest, newMin)
    }
    result
  }
}
