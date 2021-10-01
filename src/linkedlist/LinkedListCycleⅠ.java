package linkedlist;



/**
 * @author 张烈文
 */
public class LinkedListCycleⅠ {

    public boolean hasCycle(ListNode head) {
//        当一个链表有环时，快慢指针都会陷入环中进行无限次移动，然后变成了追击问题。
//        两个人从同一个七点围绕操场跑步，快的人一定可以追上慢的人
        ListNode fast = head, slow = head;
        while (true) {
//            如果没环直接返回false
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
    }
}
