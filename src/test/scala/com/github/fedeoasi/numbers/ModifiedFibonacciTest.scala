package com.github.fedeoasi.numbers

import org.scalatest.{Matchers, FunSpec}

object Solution {
  def main(args: Array[String]) {
    val lines = io.Source.stdin.getLines()
    val Array(a, b, n) = readIntArray(lines)
    println(new ModifiedFibonacci(a, b).compute(n))
  }

  def readIntArray(input: Iterator[String]): Array[Int] = {
    input.take(1).next().split(" ").map(_.toInt)
  }
}

class ModifiedFibonacciTest extends FunSpec with Matchers {
  it("computes the sequence") {
    val fib = new ModifiedFibonacci(0, 1)
    fib.compute(1) shouldBe 0
    fib.compute(2) shouldBe 1
    fib.compute(3) shouldBe 1
    fib.compute(4) shouldBe 2
    fib.compute(5) shouldBe 5
    fib.compute(6) shouldBe 27
  }

  it("computes the sequence with a different seed") {
    val fib = new ModifiedFibonacci(2, 2)
    fib.compute(1) shouldBe 2
    fib.compute(2) shouldBe 2
    fib.compute(3) shouldBe 6
    fib.compute(4) shouldBe 38
  }
}
