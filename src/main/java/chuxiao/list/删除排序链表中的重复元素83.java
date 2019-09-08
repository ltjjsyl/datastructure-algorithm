package chuxiao.list;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 * <p>
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 */
public class 删除排序链表中的重复元素83 {
    public static void main(String[] args) {

    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode ret = head;
        ListNode current = head;
        while (ret.next != null) {
            if (current.val == ret.next.val) {

            } else {
                current.next = ret.next;
                current = ret.next;
            }
            ret = ret.next;
        }
        current.next = ret.next;

        return head;
    }
}
