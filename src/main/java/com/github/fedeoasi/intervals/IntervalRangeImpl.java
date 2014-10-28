package com.github.fedeoasi.intervals;

import java.util.Set;
import java.util.TreeSet;

public class IntervalRangeImpl implements IntervalRange {
    private Set<Interval> nodes = new TreeSet<>();

    @Override
    public void add(int low, int high) {
        nodes.add(new Interval(low, high));
    }

    @Override
    public int range() {
        int range = 0;
        Interval currentSpan = null;
        for(Interval node: nodes) {
            if(currentSpan != null) {
                if(node.intersects(currentSpan)) {
                    int newHigh = Math.max(node.high, currentSpan.high);
                    currentSpan = currentSpan.withHigh(newHigh);
                } else {
                    range += currentSpan.size();
                    currentSpan = node;
                }
            } else {
                currentSpan = node;
            }
        }
        if(currentSpan != null) {
            range += currentSpan.size();
        }
        return range;
    }

    private class Interval implements Comparable<Interval> {
        Integer low;
        Integer high;

        public Interval(Integer low, Integer high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public int compareTo(Interval o) {
            if(o == null) {
                return 1;
            }
            int lowComp = low.compareTo(o.low);
            return lowComp != 0 ? lowComp : high.compareTo(o.high);
        }

        public boolean intersects(Interval o) {
            return intersectsInternal(this, o) || intersectsInternal(o, this);
        }

        private boolean intersectsInternal(Interval i, Interval o) {
            return o.low >= i.low && o.low <= i.high;
        }

        public int size() {
            return high - low;
        }

        public Interval withHigh(int newHigh) {
            if(newHigh == this.high) {
                return this;
            }
            return new Interval(this.low, newHigh);
        }

        @Override
        public String toString() {
            return "(" + low + ", " + high + ")";
        }
    }
}
