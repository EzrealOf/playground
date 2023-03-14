package com.ezreal.bill;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Objects;

/**
 * 树结构定义
 */
class TreeNode {
    public String name;
    public List<TreeNode> children;
    public TreeNode parent;

    public TreeNode() {
        children = Lists.newArrayList();

    }

    public TreeNode(String name) {
        this.name = name;
        children = Lists.newArrayList();
    }

    public TreeNode(String name, TreeNode parent) {
        this.name = name;
        this.parent = parent;
        children = Lists.newArrayList();
    }

    @Override
    public String toString() {
        if (Objects.isNull(parent)) {
            return "TreeNode{" +
                    "name='" + name + '\'' +
                    ", children=" + children +
                    ", parent=" + null +
                    '}';
        }else {
            return "TreeNode{" +
                    "name='" + name + '\'' +
                    ", children=" + children +
                    ", parent=" + parent.name +
                    '}';
        }
    }
}
