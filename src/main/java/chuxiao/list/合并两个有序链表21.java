package chuxiao.list;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */
public class 合并两个有序链表21 {

    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        ListNode current = null;
        ListNode tmp = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (head == null) {
                    head = l1;
                    current = l1;
                    continue;

                }
                tmp = l1;
                l1 = l1.next;
                current.next = tmp;
                current = tmp;

            } else {
                if (head == null) {
                    head = l2;
                    current = l2;
                    continue;
                }
                tmp = l2;
                l2 = l2.next;
                current.next = tmp;
                current = tmp;

            }
        }

        if (l1 != null) {
            current.next = l1;
        }
        if (l2 != null) {
            current.next = l2;
        }
        return head;
    }

}
