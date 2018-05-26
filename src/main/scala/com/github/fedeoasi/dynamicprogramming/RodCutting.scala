package com.github.fedeoasi.dynamicprogramming

class RodCutting(weights: Seq[Int]) {
  private val optimalCosts = {
    val costs = weights.toArray
    (2 to costs.length).foreach { size =>
      costs(size - 1) = (1 to size).map { split =>
        costs(split - 1) + (if (split == size) 0 else costs(size - split - 1))
      }.max
    }
    costs
  }

  def optimalCost(n: Int): Int = {
    optimalCosts(n - 1)
  }
}
