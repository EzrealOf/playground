package com.ezreal.leetcode.linklist;

import static com.ezreal.leetcode.linklist.ListNode.createLinkList;
import static com.ezreal.leetcode.linklist.ListNode.printLinkList;

/**
 * Created on 2021/6/13.
 *
 * @author Ezreal
 * @since 2.0.0
 */
public class Medium24 {

    public static void main(String[] args) {
        int[] nums = {1, 2};
        ListNode head = createLinkList(nums);
        printLinkList(head);
        ListNode listNode = swapPairs(head);
        printLinkList(listNode);
    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;

        }
        ListNode t = new ListNode();
        t.next = head.next;
        ListNode cur = head.next;
        ListNode nex = cur.next;

        while (nex != null) {
            cur.next = head;
            head.next = nex;
            cur = nex.next;
            nex = cur.next;
        }
        return t.next;
    }

}
