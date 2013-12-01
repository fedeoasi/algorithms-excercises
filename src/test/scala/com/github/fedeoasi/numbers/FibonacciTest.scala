package com.github.fedeoasi.numbers

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec
import com.github.fedeoasi.numbers.Fibonacci

class FibonacciTest extends FunSpec with ShouldMatchers {
  import Fibonacci._

  it("should compute the first number of the sequence") {
    fibonacci(1) should be(1)
  }

  it("should compute the second number of the sequence") {
    fibonacci(2) should be(1)
  }

  it("should compute the third number of the sequence") {
    fibonacci(3) should be(2)
  }

  it("should compute the fourth number of the sequence") {
    fibonacci(4) should be(3)
  }

  it("should compute a higher number of the sequence") {
    fibonacci(36) should be(14930352)
  }
}
