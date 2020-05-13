package chuxiao.leetcode.linear.list.leetcode203;

import chuxiao.leetcode.linear.list.ListNode;

public class Solution {
    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 4, 3, 6, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 6);
        System.out.println(res);
    }

    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
//                ListNode delNode = prev.next;
//                prev.next = delNode.next;
//                delNode.next = null;

                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }
}