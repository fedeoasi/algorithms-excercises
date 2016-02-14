package com.github.fedeoasi.combinatorics

import org.scalatest.Matchers
import org.scalatest.FunSpec
import scala.collection.JavaConversions._

class GeneratorSpec extends FunSpec with Matchers {
  val gen = new Generator

  it("should generate the permutations for 1") {
    gen.permutations(1).map(_.toList).toList shouldBe List(List(1))
  }

  it("should generate the permutations for 2") {
    gen.permutations(2).map(_.toList).toList shouldBe List(List(1, 2), List(2, 1))
  }

  it("should generate the permutations for 3") {
    gen.permutations(3).map(_.toList).toList shouldBe List(
      List(1, 2, 3),
      List(1, 3, 2),
      List(3, 1, 2),
      List(2, 1, 3),
      List(2, 3, 1),
      List(3, 2, 1)
    )
  }
}
