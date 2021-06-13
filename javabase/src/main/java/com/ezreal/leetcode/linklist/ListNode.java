package com.ezreal.leetcode.linklist;

/**
 * Created on 2021/5/18.
 *
 * @author Ezreal
 * @since 2.0.0
 */
public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }


    protected static void printLinkList(ListNode node) {
        System.out.print("当前node:【");
        ListNode cur = node;
        while (cur != null) {
            System.out.print("\t" + cur.val + "\t");
            cur = cur.next;
        }
        System.out.print(" 】");
        System.out.println();
    }


    public static ListNode createLinkList(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode current = head;
        for (int i = 1, numsLength = nums.length; i < numsLength; i++) {
            current = pickListNode(current, nums[i]);
        }
        return head;
    }

    private static ListNode pickListNode(ListNode currentNode, int num) {
        ListNode node = new ListNode(num);
        currentNode.next = node;
        return node;
    }
}
