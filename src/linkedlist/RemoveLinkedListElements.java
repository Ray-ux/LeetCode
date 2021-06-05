package linkedlist;

/**
 * 移除链表元素
 *
 * @author 张烈文
 */
public class RemoveLinkedListElements {
    /**
     * 思路1:设置虚拟投机点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode cur = dummyHead;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }


}
