package com.github.fedeoasi.connectivity;

public interface DisjointSet {
    void union(int p, int q);
    boolean connected(int p, int q);
}
