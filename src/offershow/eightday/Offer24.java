package offershow.eightday;

import linkedlist.ListNode;

import java.util.List;

/**
 *
 * 反转链表
 * @author 张烈文
 * @date 2021/9/25 13:18
 */
public class Offer24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }
}
