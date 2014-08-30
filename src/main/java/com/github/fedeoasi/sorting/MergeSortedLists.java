package com.github.fedeoasi.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MergeSortedLists {
    public static List<Integer> mergeSortedLists(List<List<Integer>> lists) {
        List<Integer> result = new ArrayList<>();

        PriorityQueue<SortNode> minHeap = new PriorityQueue<>();
        for (int i = 0; i < lists.size(); i++) {
            List<Integer> l = lists.get(i);
            if (l.size() > 0) {
                minHeap.add(new SortNode(l.get(0), i, 0));
            }
        }

        while(minHeap.size() > 0) {
            SortNode min = minHeap.poll();
            result.add(min.getValue());
            List<Integer> list = lists.get(min.getListId());
            int newIndex = min.getListIndex() + 1;
            if (list.size() > newIndex) {
                minHeap.add(new SortNode(list.get(newIndex), min.getListId(), newIndex));
            }
        }
        return result;
    }

    static class SortNode implements Comparable<SortNode> {
        private int value;
        private int listId;
        private int listIndex;


        SortNode(int value, int listId, int listIndex) {
            this.value = value;
            this.listId = listId;
            this.listIndex = listIndex;
        }

        public int getValue() {
            return value;
        }

        public int getListIndex() {
            return listIndex;
        }

        public int getListId() {
            return listId;
        }

        @Override
        public int compareTo(SortNode o) {
            if (this == o) return 0;
            return value - o.value;
        }
    }
}
