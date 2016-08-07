package com.github.fedeoasi.numbers

import org.scalatest.{FunSpec, Matchers}

class ClockTickTest extends FunSpec with Matchers {
  val counter = new ClockTick

  it("knows its boundaries") {
    counter.boundary(0) shouldBe 3
    counter.boundary(1) shouldBe 9
    counter.boundary(2) shouldBe 21
    counter.boundary(3) shouldBe 45
  }

  it("returns the correct group for the group boundaries") {
    counter.group(3) shouldBe 0
    counter.group(9) shouldBe 1
    counter.group(21) shouldBe 2
    counter.group(45) shouldBe 3
  }

  it("returns first group for the first three numbers") {
    counter.group(1) shouldBe 0
    counter.group(2) shouldBe 0
    counter.group(3) shouldBe 0
  }

  it("returns second group for the next six numbers") {
    counter.group(4) shouldBe 1
    counter.group(5) shouldBe 1
    counter.group(6) shouldBe 1
    counter.group(7) shouldBe 1
    counter.group(8) shouldBe 1
    counter.group(9) shouldBe 1
  }

  it("returns first group values for the first three numbers") {
    counter.value(1) shouldBe 3
    counter.value(2) shouldBe 2
    counter.value(3) shouldBe 1
  }

  it("returns second group values for the next six numbers") {
    counter.value(4) shouldBe 6
    counter.value(5) shouldBe 5
    counter.value(6) shouldBe 4
    counter.value(7) shouldBe 3
    counter.value(8) shouldBe 2
    counter.value(9) shouldBe 1
  }
}
