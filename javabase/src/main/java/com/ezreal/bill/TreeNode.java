package com.ezreal.bill;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.util.List;

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
        return "TreeNode{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", parent=" + parent +
                '}';
    }
}
