package com.github.fedeoasi.combinatorics

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers
import scala.collection.JavaConverters._

trait SubsetsSpec extends FunSpec with ShouldMatchers {
  def enumerator: SubsetEnumerator

  describe("Subset Generation") {
    it("should generate an empty subset set for an empty string") {
      val subsets = enumerator.enumerateSubsets("")
      subsets.size() should be(0)
    }

    it("subset of one element is itself") {
      val subsets = enumerator.enumerateSubsets("a").toArray
      subsets.size should be(1)
      subsets(0) should be("a")
    }

    it("generates subsets for size 2") {
      val subsets = enumerator.enumerateSubsets("ab").asScala.toArray
      testContains(subsets, Array("a", "ab", "b"))
    }

    it("generates subsets for size 3") {
      val subsets = enumerator.enumerateSubsets("abc").asScala.toArray
      testContains(subsets, Array("a", "ab", "abc", "ac", "b", "bc", "c"))
    }

    it("times generating large subsets") {
      val string = "abcdefghijklmnopqrstuvxyzasdfasdfasdfasdfasdfasdfasdfasdf"
      val start = System.currentTimeMillis()
      val subsets = enumerator.enumerateSubsets(string.take(22))
      println(subsets.size())
      val end = System.currentTimeMillis()
      println(s"${enumerator.getClass.getSimpleName} time: ${end - start} size: ${subsets.size}")
    }
  }

  private def testContains(actual: Array[String], expected: Array[String]): Unit = {
    actual.size should be(expected.size)
    actual.sorted should be (expected.sorted)
  }
}

class BitMaskedSubsetEnumeratorSpec extends SubsetsSpec {
  lazy val enumerator = new BitMaskedSubsetEnumerator
}

class LexicographicSubsetEnumeratorSpec extends SubsetsSpec {
  lazy val enumerator = new LexicographicSubsetEnumerator
}