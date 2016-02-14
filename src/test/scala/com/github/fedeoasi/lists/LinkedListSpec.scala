package com.github.fedeoasi.lists

import org.scalatest.FunSpec
import org.scalatest.Matchers

class LinkedListSpec extends FunSpec with Matchers {
  import LinkedLists._

  describe("Linked List") {
    describe("Cycles") {
      it("returns false on an empty node") {
        hasCycle(null) shouldBe false
      }

      it("returns false on an single node") {
        hasCycle(new ListNode(3)) shouldBe false
      }

      it("returns false when there is no cycle (even)") {
        val n1 = new ListNode(3)
        val n2 = new ListNode(4)
        n1.setNext(n2)
        hasCycle(n1) shouldBe false
      }

      it("returns false when there is no cycle (odd)") {
        val n1 = new ListNode(3)
        val n2 = new ListNode(4)
        val n3 = new ListNode(5)
        n1.setNext(n2)
        n2.setNext(n3)
        hasCycle(n1) shouldBe false
      }

      it("returns true when there is a cycle (even)") {
        val n1 = new ListNode(3)
        val n2 = new ListNode(4)
        val n3 = new ListNode(5)
        n1.setNext(n2)
        n2.setNext(n3)
        n3.setNext(n1)
        hasCycle(n1) shouldBe true
      }

      it("returns true when there is a cycle (odd)") {
        val n1 = new ListNode(3)
        val n2 = new ListNode(4)
        val n3 = new ListNode(5)
        val n4 = new ListNode(6)
        n1.setNext(n2)
        n2.setNext(n3)
        n3.setNext(n4)
        n4.setNext(n1)
        hasCycle(n1) shouldBe true
      }
    }
  }
}
