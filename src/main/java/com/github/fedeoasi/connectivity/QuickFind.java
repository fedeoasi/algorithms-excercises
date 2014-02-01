package com.github.fedeoasi.connectivity;

public class QuickFind {
    private int[] a;

    public QuickFind(int n) {
        a = new int[n];
        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }
    }

    public void union(int p, int q) {
        int pid = a[p];
        int qid = a[q];
        for(int i = 0; i < a.length; i++) {
            if(a[i] == pid) {
                a[i] = qid;
            }
        }
    }

    public boolean connected(int p, int q) {
        return a[p] == a[q];
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
