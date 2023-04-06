package com.example.leetcodedemo.easy;

/**
 * @author wc
 * @date 2023/2/27 13:57
 * desc   Stay hungry, stay foolish
 **/
public class num22 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = new ListNode(6, new ListNode(0, null));
        System.out.println(solution.getKthFromEnd(listNode, 1));
    }


    static class Solution {
//        public ListNode getKthFromEnd(ListNode head, int k) {
//            if (head==null){
//                return null;
//            }
//            ListNode front=head;
//            ListNode behind=head;
//            while (front!=null && k>0){
//                front=front.next;
//            }
//            while (front!=null){
//                front=front.next;
//                behind=behind.next;
//            }
//            return behind;
//        }

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
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            this.val = x;
            this.next = next;
        }

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
}
