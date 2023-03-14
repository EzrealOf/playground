package com.ezreal.bill;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;

public class BillTreeTest {

    public static void main(String[] args) {
        TreeNode init = init4();
        TreeNode a1 = fuzzyMatch("A", init);
        System.out.println(a1);

    }

    public static TreeNode init1() {
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B", a);
        TreeNode c = new TreeNode("C", a);
        TreeNode d = new TreeNode("D", a);
        a.children = Lists.newArrayList(b, c, d);
        return a;
    }

    public static TreeNode init2() {
        TreeNode a = new TreeNode("A");
        TreeNode aa = new TreeNode("AA", a);
        TreeNode b = new TreeNode("B", a);
        TreeNode c = new TreeNode("C", a);
        a.children = Lists.newArrayList(aa, b, c);
        return a;
    }

    public static TreeNode init3() {
        TreeNode a = new TreeNode("A");
        TreeNode aa = new TreeNode("AA", a);
        TreeNode b = new TreeNode("B", a);
        TreeNode c = new TreeNode("C", a);
        TreeNode d = new TreeNode("DA", b);
        a.children = Lists.newArrayList(aa, b, c);
        b.children = Lists.newArrayList(d);
        return a;
    }

    public static TreeNode init4() {
        TreeNode a = new TreeNode("A");
        TreeNode aa = new TreeNode("AA", a);
        TreeNode da = new TreeNode("DA", a);
        TreeNode c = new TreeNode("C", a);
        TreeNode b = new TreeNode("b", da);
        a.children = Lists.newArrayList(aa, da, c);
        da.children = Lists.newArrayList(b);
        return a;
    }

    public static TreeNode fuzzyMatch(String query, TreeNode root) {
        if (StringUtils.isEmpty(query)){
            return root;
        }
        ArrayDeque<TreeNode> arrayDeque = new ArrayDeque<TreeNode>();
        TreeNode result = new TreeNode();
        recursion(query, root, arrayDeque);
        construction(result, arrayDeque);
        return result;
    }

    public static TreeNode construction(TreeNode result, ArrayDeque<TreeNode> arrayDeque) {
        List<TreeNode> arrayList = Lists.newArrayList();
        while (!Objects.isNull(arrayDeque.peekFirst())) {
            arrayList.add(arrayDeque.pollFirst());
        }
        ccb(result, arrayList);
        return result;
    }

    public static TreeNode ccb(TreeNode result, List<TreeNode> arrayList) {
        List<TreeNode> nodes = Lists.newArrayList(arrayList);
        for (TreeNode current : nodes) {
            if (current.parent == null) {
                result.name = current.name;
                arrayList.remove(current);
                continue;
            }
            TreeNode node = new TreeNode();
            if (current.parent.name == result.name) {
                node.name = current.name;
                result.children.add(node);
                arrayList.remove(current);
                continue;
            } else {
                for (TreeNode child : result.children) {
                    ccb(child, arrayList);
                }
            }
        }
        return result;

    }

    public static void recursion(String query, TreeNode currentNode, ArrayDeque<TreeNode> arrayDeque) {
        if (currentNode == null) {
            return;
        }
        if (currentNode.children == null || currentNode.children.isEmpty()) {
            if (StringUtils.contains(currentNode.name, query)) {
                arrayDeque.offerFirst(currentNode);
            }
            return;
        }
        for (TreeNode child : currentNode.children) {
            recursion(query, child, arrayDeque);
        }
        TreeNode first = arrayDeque.peekFirst();
        if ((!Objects.isNull(first) && Objects.equals(first.parent, currentNode)) || StringUtils.contains(currentNode.name, query)) {
            arrayDeque.offerFirst(currentNode);
        }
    }


}

