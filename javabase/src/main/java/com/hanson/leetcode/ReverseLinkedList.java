package com.hanson.leetcode;

import org.w3c.dom.ls.LSException;

import java.util.Stack;

/**
 * 反转链表
 * 1->2->3->4->5->null
 * <p>
 * 5->4->3->2->1->null
 *
 * @author hanson
 * @date 2024/3/28 21:40
 */
public class ReverseLinkedList {

    static class ListNode {

        int value;

        ListNode next;

        // 构造函数
        ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    /**
     * 使用栈的方法翻转链表
     *
     * @param head
     * @return
     */
    public static ListNode StackMethod(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Stack<ListNode> stack = new Stack<>();// 创建一个整型栈

        ListNode current = head;

        while (current != null) {
            stack.push(current); // 将链表的值依次压入栈中
            current = current.next;
        }


        // 弹出栈顶元素作为新的头节点
        ListNode newHead = stack.pop();

        ListNode temp = newHead;

        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }


        // 最后一个节点的 next 设为 null，防止链表循环
        temp.next = null;

        return newHead;
    }

    /**
     * 头插法
     *
     * @param head
     * @return
     */
    public static ListNode headInsertion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = null;
        ListNode temp;

        while (head != null) {
            temp = head;
            head = head.next;
            temp.next = newHead;
            newHead = temp;
        }

        return newHead;

    }


    /**
     * 三指针法
     *
     * @param head
     * @return
     */
    public static ListNode threePointMethod(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

    public static void main(String[] args) {
        // 创建链表:1->2->3->4->5->null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;

        // 打印原始链表
        System.out.println("原始链表：");
        printLinkedList(head);

        // 反转链表
//        ListNode reversedHead = threePointMethod(head);

        // 头插法
//        ListNode headInsertion = headInsertion(head);

        ListNode stackMethod = StackMethod(head);

        // 打印反转后的链表
        System.out.println("反转后的链表：");
        printLinkedList(stackMethod);
    }

    // 辅助方法：打印链表
    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.value + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
