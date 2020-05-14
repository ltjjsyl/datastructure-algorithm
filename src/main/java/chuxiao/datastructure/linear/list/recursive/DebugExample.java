package chuxiao.datastructure.linear.list.recursive;

import chuxiao.leetcode.linear.list.ListNode;

public class DebugExample {
    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 4, 3, 6, 5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new DebugExample()).removeElements(head, 6, 0);
        System.out.println(res);
    }

    public ListNode removeElements(ListNode head, int val, int depth) {

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove " + val + " in:" + head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return " + head);
            return null;
        }

        ListNode res = removeElements(head.next, val, ++depth);
        System.out.print(depthString);
        System.out.println("After remove " + val + " :" + res);

        ListNode ret;

        if (head.val == val) {
            ret = res;
        } else {
            head.next = res;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return " + ret);

        return ret;
    }

    private String generateDepthString(int depth) {

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }

        return res.toString();
    }
}