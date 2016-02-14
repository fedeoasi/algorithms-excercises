package com.github.fedeoasi.numbers

import org.scalatest.Matchers
import org.scalatest.FunSpec

class FibonacciTest extends FunSpec with Matchers {
  import Fibonacci._

  it("should compute the first number of the sequence") {
    fibonacci(1) shouldBe 1
  }

  it("should compute the second number of the sequence") {
    fibonacci(2) shouldBe 1
  }

  it("should compute the third number of the sequence") {
    fibonacci(3) shouldBe 2
  }

  it("should compute the fourth number of the sequence") {
    fibonacci(4) shouldBe 3
  }

  it("should compute a higher number of the sequence") {
    fibonacci(36) shouldBe 14930352
  }
}
