package com.github.fedeoasi.bits

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec

class SumSpec extends FunSpec with ShouldMatchers {
  import Summer._

  describe("Summing Arrays") {
    it("should return zero when the numbers are all the same") {
      val a = Array[Int](3, 3, 3, 3)
      xor(a) should be (0)
    }

    it("should find the only distinct number") {
      val a = Array[Int](3, 3, 3, 3, 3)
      xor(a) should be (3)
    }

    it("should figure out the only number different appearing an odd number of times in an array") {
      val a = Array[Int](4, 3, 3, 6, 6, 6 ,6 , 10, 8, 10, 8)
      xor(a) should be (4)
    }
  }
}
