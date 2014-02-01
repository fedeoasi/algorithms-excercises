package com.github.fedeoasi.connectivity;

public class QuickUnion {
    private int[] a;

    public QuickUnion(int n) {
        a = new int[n];
        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }
    }

    public void union(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        a[pRoot] = qRoot;
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
