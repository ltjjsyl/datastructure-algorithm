package chuxiao.leetcode.linear.list.leetcode203;

import chuxiao.leetcode.linear.list.ListNode;

public class Solution2 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 4, 3, 6, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution2()).removeElements(head, 6);
        System.out.println(res);
    }

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
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
        return dummyHead.next;
    }
}