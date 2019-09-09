package chuxiao.list;

/**
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * 输入: 1->2->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class 移除链表元素203 {
    public static void main(String[] args) {

    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode ret = head;
        ListNode current = head;
        while (ret.next != null) {
            if (ret.next.val != val) {
                current.next = ret.next;
                current = ret.next;
            }
            ret = ret.next;
        }
        current.next = ret.next;
        return head;
    }
}
