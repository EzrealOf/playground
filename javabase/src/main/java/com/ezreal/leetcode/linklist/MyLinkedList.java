package com.ezreal.leetcode.linklist;

/**
 * Created on 2021/5/18.
 *
 * @author Ezreal
 * @since 2.0.0
 */
public class MyLinkedList {
    ListNode node;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {

    }

    public MyLinkedList(ListNode node) {
        this.node = node;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        int count = 0;
        ListNode cur = node;
        while (cur != null) {
            if (count == index) {
                return cur.val;
            }
            cur = cur.next;
            count++;

        }
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        ListNode listNode = new ListNode(val);
        listNode.next = this.node;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        ListNode listNode = new ListNode(val);
        ListNode cur = this.node;
        while (cur != null) {
            if (cur.next == null) {
                cur.next = listNode;
            }
            cur = cur.next;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        ListNode listNode = new ListNode(val);
        ListNode cur = this.node;

    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {

    }
}
