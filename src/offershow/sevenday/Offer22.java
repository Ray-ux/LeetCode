package offershow.sevenday;

import linkedlist.ListNode;

/**
 *
 * 找到环入口节点
 * @author 张烈文
 * @date 2021/9/24 11:41
 */
public class Offer22 {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode index1 = fast;
                ListNode index2 = head;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;

                }
                return index1;
            }
        }
        return null;
    }


}
