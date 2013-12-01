package com.github.fedeoasi.combinatorics;

import java.util.ArrayList;
import java.util.List;

public class Generator {
    public List<List<Integer>> permutations(int n) {
        if(n < 1) {
            return new ArrayList<>();
        }
        if(n == 1) {
            ArrayList<Integer> perm = new ArrayList<>();
            perm.add(1);
            List<List<Integer>> result = new ArrayList<>();
            result.add(perm);
            return result;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> smallerPerm = permutations(n - 1);
        for(int i = 0; i < smallerPerm.size(); i++) {
            List<Integer> toDecorate = smallerPerm.get(i);
            for(int j = toDecorate.size(); j >= 0; j--) {
                result.add(decorateList(toDecorate, n, j));
            }
        }
        return result;
    }

    private List<Integer> decorateList(List<Integer> toDecorate, int value, int index) {
        List<Integer> result = new ArrayList<>();
        boolean added = false;
        for (int i = 0; i < toDecorate.size(); i++) {
            if(i == index) {
                result.add(value);
                added = true;
            }
            result.add(toDecorate.get(i));
        }
        if(added == false) {
            result.add(value);
        }
        return result;
    }
}
