package com.github.fedeoasi.sorting

import org.scalatest.FunSpec
import org.scalatest.Matchers
import scala.collection.JavaConverters._
import java.util

class MergeSortedListsSpec extends FunSpec with Matchers {
  import MergeSortedLists._

  describe("Merge k sorted lists") {
    it("should merge an empty set of lists") {
      mergeSortedLists(List.empty[util.List[Integer]].asJava)
    }

    it("should merge a single list") {
      val sortedList: util.List[Integer] = List(1, 2, 4, 5)
      val lists = List[util.List[Integer]](sortedList)
      mergeSortedLists(lists.asJava) shouldBe sortedList
    }

    it("should merge multiple lists with no duplicates") {
      val lists = List[util.List[Integer]](
        List(1, 4, 5, 8),
        List(2, 3, 6, 7)
      )
      val expected = List(1, 2, 3, 4, 5, 6, 7, 8)
      mergeSortedLists(lists.asJava) shouldBe toJavaIntList(expected)
    }

    it("should merge multiple lists with duplicates") {
      val lists = List[util.List[Integer]](
        List(1, 4, 5, 8),
        List(2, 3, 6, 7, 8)
      )
      val expected = List(1, 2, 3, 4, 5, 6, 7, 8, 8)
      mergeSortedLists(lists.asJava) shouldBe toJavaIntList(expected)
    }

    it("should merge multiple lists") {
      val lists = List[util.List[Integer]](
        List(1, 6, 5, 8),
        List(2, 5, 6, 7),
        List(3, 4, 6, 7)
      )
      val expected = List(1, 2, 3, 4, 5, 6, 7, 8, 8)
      mergeSortedLists(lists.asJava) shouldBe toJavaIntList(expected)
    }

    implicit def toJavaIntList(list: List[Int]): util.List[Integer] = {
      val result = new util.ArrayList[Integer]
      list.foreach(el => result.add(new Integer(el)))
      result
    }
  }
}
