package com.ezreal.leetcode.linklist;


/**
 * Created on 2021/5/18.
 * <p>
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val 和 next。val 是当前节点的值，next 是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性 prev 以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 * <p>
 * 在链表类中实现这些功能：
 * <p>
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *  
 * <p>
 * 示例：
 * <p>
 * MyLinkedList linkedList = new MyLinkedList();
 * linkedList.addAtHead(1);
 * linkedList.addAtTail(3);
 * linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
 * linkedList.get(1);            //返回2
 * linkedList.deleteAtIndex(1);  //现在链表是1-> 3
 * linkedList.get(1);            //返回3
 *  
 * <p>
 * 提示：
 * <p>
 * 所有val值都在 [1, 1000] 之内。
 * 操作次数将在  [1, 1000] 之内。
 * 请不要使用内置的 LinkedList 库。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ezreal
 * @since 2.0.0
 */
public class Medium707 {

    public static void main(String[] args) {
//        int[] nums = {1, 2, 6, 3, 4, 5, 6};
//        ListNode head = createLinkList(nums);
        MyLinkedList myLinkedList = new MyLinkedList();
        /*int i = 6;
        int res = myLinkedList.get(i);
        System.out.println("获取当前第" + i + "对应的值" + res);

        myLinkedList.addAtHead(3);
        System.out.println(myLinkedList.toString());

        myLinkedList.addAtHead(2);
        System.out.println(myLinkedList.toString());

        myLinkedList.addAtTail(7);
        System.out.println(myLinkedList.toString());

        myLinkedList.addAtIndex(1, 9);
        System.out.println(myLinkedList.toString());

        myLinkedList.deleteAtIndex(100);
        System.out.println(myLinkedList.toString());*/


        myLinkedList.addAtHead(2);
        System.out.println(myLinkedList.toString());
        myLinkedList.deleteAtIndex(2);
        System.out.println(myLinkedList.toString());
        myLinkedList.addAtHead(1);
        System.out.println(myLinkedList.toString());
        myLinkedList.addAtHead(2);
        System.out.println(myLinkedList.toString());
        myLinkedList.addAtHead(7);
        System.out.println(myLinkedList.toString());
        myLinkedList.addAtHead(3);
        System.out.println(myLinkedList.toString());
        myLinkedList.addAtHead(2);
        System.out.println(myLinkedList.toString());
        myLinkedList.addAtTail(5);
        System.out.println(myLinkedList.toString());
        myLinkedList.get(5);
        System.out.println(myLinkedList.toString());
        myLinkedList.get(5);
        System.out.println(myLinkedList.toString());
        myLinkedList.deleteAtIndex(6);
        System.out.println(myLinkedList.toString());
        myLinkedList.deleteAtIndex(4);
        System.out.println(myLinkedList.toString());


    }

    /*
    ["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
[[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]]
     */


}
