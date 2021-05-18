package com.ezreal.leetcode.linklist;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class Simple203 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = createLinkList(nums);
        System.out.println(head);
        ListNode listNode = removeElements(head, 1);
        System.out.println(listNode);
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        remove(dummyNode, dummyNode.next, val);
        return dummyNode.next;
    }

    public static void remove(ListNode head, ListNode current, int val) {
        if (current == null) {
            return;
        }
        if (current.val == val) {
            head.next = null;
            remove(head, current.next, val);
        } else {
            head.next = current;
            remove(head.next, current.next, val);
        }
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

/**
 * Definition for singly-linked list.
 */
class ListNode {
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
}
