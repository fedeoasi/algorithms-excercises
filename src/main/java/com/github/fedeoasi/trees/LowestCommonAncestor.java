package com.github.fedeoasi.trees;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestor {
    public static <T> TreeNode<T> leastCommonAncestor(TreeNode<T> n1, TreeNode<T> n2) {
        Set<TreeNode<T>> parents = new HashSet<>();
        TreeNode<T> temp = n1;
        while(temp != null) {
            parents.add(temp);
            temp = temp.getParent();
        }
        temp = n2;
        while(temp != null) {
            if(parents.contains(temp)) {
                return temp;
            }
            temp = temp.getParent();
        }
        return null;
    }
}
