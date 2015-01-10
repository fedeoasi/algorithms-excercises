package com.github.fedeoasi.combinatorics

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class BinomialCoefficientsSpec extends FunSpec with ShouldMatchers {
  describe("Binomial Coefficients") {
    it("iterates through the coefficients for n = 1") {
      assertCoefficients(1, List(1, 1))
    }

    it("iterates through the coefficients for n = 2") {
      assertCoefficients(2, List(1, 2, 1))
    }

    it("iterates through the coefficients for n = 3") {
      assertCoefficients(3, List(1, 3, 3, 1))
    }

    it("iterates through the coefficients for n = 4") {
      assertCoefficients(4, List(1, 4, 6, 4, 1))
    }
  }

  private def assertCoefficients(n: Int, result: List[Int]): Unit = {
    new BinomialCoefficients(n).toList should be(result)
  }
}
