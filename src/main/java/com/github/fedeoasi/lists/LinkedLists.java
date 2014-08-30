package com.github.fedeoasi.lists;

import java.util.HashSet;
import java.util.Set;

public class LinkedLists {
    public static <T> boolean hasCycleWithSet(ListNode<T> head) {
        if(head == null) {
            return false;
        }
        Set<ListNode> seen = new HashSet<>();
        boolean cycle = false;
        for (ListNode node = head; node.next() != null && !cycle; node = node.next()) {
            if(seen.contains(node)) {
                cycle = true;
            } else {
                seen.add(node);
            }
        }
        return cycle;
    }

    public static <T> boolean hasCycle(ListNode<T> head) {
        ListNode<T> fast;
        ListNode<T> slow;
        for(fast = head, slow = head; fast != null; ) {
            fast = fast.next();
            if(fast == slow) {
                return true;
            }
            if(fast != null) {
                fast = fast.next();
                slow = slow.next();
            }
        }
        return false;
    }
}
