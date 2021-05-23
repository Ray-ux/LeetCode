package linkedlist;

/**
 * @author 张烈文
 */
public class LinkedListCycleⅡ {
    public ListNode detectCycle(ListNode head) {

//        双指针
        ListNode fast = head, slow = head;


        while (true) {
//        如果链表没环直接返回
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
//            有环则终止循环
            if (slow == fast) {
                break;
            }
        }

//        将fast指针重新指向head
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
