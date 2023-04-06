/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */




class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {//空链表
            //noinspection AlibabaRemoveCommentedCode
            return null;
        }
        ListNode listNode = head;
        ListNode cur = head;
        int temp = 0;
        while (listNode != null) {
            temp++;
            listNode = listNode.next;
        }
        System.out.println(temp);
        if (k > temp) {
            return null;
        } else {
            for (int i = 0; i < temp - k; i++) {
                cur = cur.next;
            }
        }
        return cur;
    }
//    public ListNode getKthFromEnd(ListNode head, int k) {
//
//            ListNode front = head;
//            ListNode behind = head;
//            while (front != null && k > 0) {
//                front = front.next;
//                k--;
//            }
//            while (front != null) {
//                front = front.next;
//                behind = behind.next;
//            }
//            return behind;
//        }

}

