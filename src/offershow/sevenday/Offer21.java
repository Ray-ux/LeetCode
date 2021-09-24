package offershow.sevenday;

import linkedlist.ListNode;

/**
 * 删除链表的倒数第n个节点
 *
 * @author 张烈文
 * @date 2021/9/24 11:01
 */
public class Offer21 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode fast = head;
        ListNode slow = dummyHead;
        while (n > 0) {
            fast = fast.next;
            n--;
        }
        while (fast!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return dummyHead.next;
    }
}
