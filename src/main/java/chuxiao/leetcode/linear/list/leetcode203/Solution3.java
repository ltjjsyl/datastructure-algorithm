package chuxiao.leetcode.linear.list.leetcode203;

import chuxiao.leetcode.linear.list.ListNode;

public class Solution3 {
    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 4, 3, 6, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head, 6);
        System.out.println(res);
    }

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;

        //没有去除引用
    }
}