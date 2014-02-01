package com.github.fedeoasi.connectivity;

public class WeightedQuickUnion {
    private int[] a;
    private int[] size;

    public WeightedQuickUnion(int n) {
        a = new int[n];
        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        size = new int[n];
        for(int i = 0; i < size.length; i++) {
            size[i] = 1;
        }
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if(pRoot == qRoot) {
            return;
        }
        if(size[pRoot] >= size[qRoot]) {
            a[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        } else {
            a[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int p) {
        int cur = p;
        while(a[cur] != cur) {
            cur = a[cur];
        }
        return cur;
    }

    public String printArray() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < a.length; i++) {
            sb.append(a[i]);
            if(i != a.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
