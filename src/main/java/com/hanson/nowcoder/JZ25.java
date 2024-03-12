package com.hanson.nowcoder;

import java.util.List;

/**
 * @author hanson
 * @date 2024/3/12 22:40
 */
public class JZ25 {
    /*
     * 输入两个递增的链表，单个链表的长度为n，合并这两个链表并使新链表中的节点仍然是递增排序的。
     * 如输入{1,3,5},{2,4,6}时，合并后的链表为{1,2,3,4,5,6}，所以对应的输出为{1,2,3,4,5,6}，转换过程如下图所示：
     * */
    // 定义链表节点类
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode Merge(ListNode head1, ListNode head2) {
        //谁比较小,谁就是next
        //循环结束后,谁不为空,就接着往后面放
        ListNode newHead = new ListNode(-1);
        ListNode tmp = newHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                tmp.next = head1;
                head1 = head1.next;
            } else {
                tmp.next = head2;
                head2 = head2.next;
            }
            tmp = tmp.next;
        }
        if (head1 != null) {
            tmp.next = head1;
        }

        if (head2 != null) {
            tmp.next = head2;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        // 创建第一个链表: 1 -> 3 -> 5 -> null
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        System.out.println("head1:");
        printList(head1);

        // 创建第二个链表: 2 -> 4 -> 6 -> null
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);

        System.out.println("head2:");
        printList(head2);

        ListNode merge = Merge(head1, head2);

        System.out.println("merge:");
        printList(merge);

    }

    // 打印链表的方法
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
