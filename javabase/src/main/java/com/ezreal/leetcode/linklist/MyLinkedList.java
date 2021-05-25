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

    public ListNode getNode() {
        return node;
    }

    public void setNode(ListNode node) {
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
        if (this.node == null) {
            this.node = new ListNode(val);
            return;
        }
        ListNode head = new ListNode(val);
        head.next = this.node;
        this.node = head;

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if (this.node == null) {
            this.node = new ListNode(val);
            return;
        }
        ListNode listNode = new ListNode(val);
        ListNode cur = this.node;
        while (true) {
            if (cur.next == null) {
                cur.next = listNode;
                break;
            }
            cur = cur.next;
        }
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (this.node == null) {
            this.node = new ListNode(val);
            return;
        }
        if (index == 0) {
            this.addAtHead(val);
            return;
        }
        int count = 0;
        ListNode listNode = new ListNode(val);
        ListNode cur = this.node;
        while (true) {
            if (count == (index - 1)) {
                listNode.next = cur.next;
                cur.next = listNode;
                return;
            }
            if (cur.next == null) {
                cur.next = listNode;
                break;
            }
            cur = cur.next;
            count++;

        }


    }


    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        int count = 0;
        ListNode cur = this.node;
        while (cur != null) {
            if (index == 0) {
                this.node = node.next;
                break;
            }
            if (count == (index - 1)) {
                if (cur.next != null) {
                    cur.next = cur.next.next;
                }
            }
            cur = cur.next;
            count++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------当前node:【 ");
        ListNode cur = node;
        while (cur != null) {
            sb.append(cur.val);
            sb.append(",");
            cur = cur.next;
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" 】-------");
        return sb.toString();
    }
}
