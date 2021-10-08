package linkedlist;

import java.util.List;

/**
 * @author 张烈文
 */
public class LinkedListCycleⅡ {
    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return head;
        }
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
//            存在环
            if (fast == slow) {
                ListNode index1 = fast;
                ListNode index2 = head;
//                找环入口
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
